package site.ylan.sunnyweather.date.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import site.ylan.sunnyweather.common.Constants.BASE_URL

/**
 * ServiceCreator
 * @author: ylan
 */
object ServiceCreator {

    // GsonConverterFactory
    private val gsonConverterFactory: GsonConverterFactory = GsonConverterFactory.create()

    // Retrofit
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(gsonConverterFactory)
        .build()

    // create
    inline fun <reified T> create(): T = create(T::class.java)
    fun <T> create(serviceClass: Class<T>): T = retrofit.create(serviceClass)

}