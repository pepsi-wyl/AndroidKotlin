package site.ylan.sunnyweather.date

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import site.ylan.sunnyweather.common.Constants.OK
import site.ylan.sunnyweather.common.utils.LogUtil
import site.ylan.sunnyweather.date.db.PlaceDao
import site.ylan.sunnyweather.date.model.DailyResponse
import site.ylan.sunnyweather.date.model.PlaceResponse.Place
import site.ylan.sunnyweather.date.model.PlaceResponse
import site.ylan.sunnyweather.date.model.RealtimeResponse
import site.ylan.sunnyweather.date.model.Weather
import site.ylan.sunnyweather.date.network.SunnyWeatherNetwork
import kotlin.coroutines.CoroutineContext

/**
 * Repository
 * @author: ylan
 */
object Repository {

    /**
     * searchPlaces
     */
    fun searchPlaces(query: String): LiveData<Result<List<Place>>> = fire(Dispatchers.IO) {
        val placeResponse: PlaceResponse = SunnyWeatherNetwork.searchPlaces(query)
        LogUtil.d("Repository-searchPlaces", placeResponse.toString())
        if (placeResponse.status == OK) {
            Result.success(placeResponse.places)
        } else {
            Result.failure(RuntimeException("response status is${placeResponse.status}"))
        }
    }


    /**
     * refreshWeather
     */
    fun refreshWeather(lng: String, lat: String): LiveData<Result<Weather>> = fire(Dispatchers.IO) {
        coroutineScope {
            val deferredRealtime: Deferred<RealtimeResponse> = async { SunnyWeatherNetwork.getRealtimeWeather(lng, lat) }
            val deferredDaily: Deferred<DailyResponse> = async { SunnyWeatherNetwork.getDailyWeather(lng, lat) }
            val realtimeResponse = deferredRealtime.await()
            val dailyResponse = deferredDaily.await()
            LogUtil.d("Repository-refreshWeather", "realtimeResponse ===> $realtimeResponse >===< dailyResponse===>$dailyResponse")
            if (realtimeResponse.status == OK && dailyResponse.status == OK) {
                Result.success(Weather(realtimeResponse.result.realtime, dailyResponse.result.daily))
            } else {
                Result.failure(RuntimeException("realtime response status is ${realtimeResponse.status}" + "daily response status is ${dailyResponse.status}"))
            }
        }
    }

    /**
     * fire
     */
    private fun <T> fire(context: CoroutineContext, block: suspend () -> Result<T>): LiveData<Result<T>> =
        liveData<Result<T>>(context) {
            val result = try {
                block()
            } catch (e: Exception) {
                Result.failure<T>(e)
            }
            emit(result)
        }

    /**
     * savePlace
     */
    fun savePlace(place: Place) = PlaceDao.savePlace(place)

    /**
     * getSavedPlace
     */
    fun getSavedPlace() = PlaceDao.getSavedPlace()

    /**
     * isPlaceSaved
     */
    fun isPlaceSaved() = PlaceDao.isPlaceSaved()
}