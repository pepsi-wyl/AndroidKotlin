package site.ylan.sunnyweather.date

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import site.ylan.sunnyweather.common.Constants.OK
import site.ylan.sunnyweather.common.utils.LogUtil
import site.ylan.sunnyweather.date.model.Place
import site.ylan.sunnyweather.date.model.PlaceResponse
import site.ylan.sunnyweather.date.network.SunnyWeatherNetwork

/**
 * Repository
 * @author: ylan
 */
object Repository {

    /**
     * searchPlaces
     */
    fun searchPlaces(query: String): LiveData<Result<List<Place>>> =
        liveData(Dispatchers.IO) {
            val result: Result<List<Place>> = try {
                val placeResponse: PlaceResponse = SunnyWeatherNetwork.searchPlaces(query)
                LogUtil.d("Repository-searchPlaces", placeResponse.toString())
                if (placeResponse.status == OK) {
                    Result.success(placeResponse.places)
                } else {
                    Result.failure(RuntimeException("response status is${placeResponse.status}"))
                }
            } catch (e: Exception) {
                Result.failure(e)
            }
            emit(result)
        }
}