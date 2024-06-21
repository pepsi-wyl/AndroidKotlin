package site.ylan.sunnyweather.date.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import site.ylan.sunnyweather.common.Constants.WEATHER_TOKEN
import site.ylan.sunnyweather.common.Constants.ZH_CN
import site.ylan.sunnyweather.date.model.PlaceResponse

/**
 * PlaceService
 * @author: ylan
 */
interface PlaceService {

    /**
     * searchPlaces
     */
    @GET("v2/place")
    fun searchPlaces(
        @Query("token") token: String = WEATHER_TOKEN,
        @Query("lang") lang: String = ZH_CN,
        @Query("query") query: String
    ): Call<PlaceResponse>

}