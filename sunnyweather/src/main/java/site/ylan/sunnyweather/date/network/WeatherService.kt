package site.ylan.sunnyweather.date.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import site.ylan.sunnyweather.common.Constants.WEATHER_TOKEN
import site.ylan.sunnyweather.date.model.DailyResponse
import site.ylan.sunnyweather.date.model.RealtimeResponse

/**
 * WeatherService
 * @author: ylan
 */
interface WeatherService {

    /**
     * getRealtimeWeather
     */
    @GET("/v2.5/${WEATHER_TOKEN}/{lng},{lat}/realtime.json")
    fun getRealtimeWeather(
        @Path("lng") lng: String,
        @Path("lat") lat: String
    ): Call<RealtimeResponse>

    /**
     * getDailyWeather
     */
    @GET("/v2.5/${WEATHER_TOKEN}/{lng},{lat}/daily.json")
    fun getDailyWeather(
        @Path("lng") lng: String,
        @Path("lat") lat: String
    ): Call<DailyResponse>
}