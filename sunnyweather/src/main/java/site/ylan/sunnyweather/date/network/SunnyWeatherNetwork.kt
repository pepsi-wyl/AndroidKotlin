package site.ylan.sunnyweather.date.network

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import site.ylan.sunnyweather.date.model.DailyResponse
import site.ylan.sunnyweather.date.model.PlaceResponse
import site.ylan.sunnyweather.date.model.RealtimeResponse
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

/**
 * SunnyWeatherNetwork
 * @author: ylan
 */
object SunnyWeatherNetwork {

    // PlaceService
    private val placeService: PlaceService = ServiceCreator.create<PlaceService>()

    // WeatherService
    private val weatherService: WeatherService = ServiceCreator.create<WeatherService>()

    // searchPlaces
    suspend fun searchPlaces(query: String): PlaceResponse = placeService.searchPlaces(query = query).await()

    // getRealtimeWeather
    suspend fun getRealtimeWeather(lng: String, lat: String): RealtimeResponse = weatherService.getRealtimeWeather(lng = lng, lat = lat).await()

    // getDailyWeather
    suspend fun getDailyWeather(lng: String, lat: String): DailyResponse = weatherService.getDailyWeather(lng = lng, lat = lat).await()

    // Call<T>.await(): T
    private suspend fun <T> Call<T>.await(): T {
        return suspendCoroutine { continuation ->
            enqueue(object : Callback<T> {
                // onResponse
                override fun onResponse(call: Call<T>, response: Response<T>) {
                    val body = response.body()
                    if (body != null) {
                        continuation.resume(body)
                    } else {
                        continuation.resumeWithException(RuntimeException("response body is null"))
                    }
                }

                // onFailure
                override fun onFailure(call: Call<T>, t: Throwable) {
                    continuation.resumeWithException(t)
                }
            })
        }
    }
}