package site.ylan.k11_net.net.server

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query
import site.ylan.k11_net.model.entity.Data

interface ExampleService {
    @Headers("User-Agent: okhttp", "Cache-Control: max-age=0")
    @GET("get_data.json")
    fun getData(): Call<Data>

    fun getData1(@Header("User-Agent") userAgent: String,
                @Header("Cache-Control") cacheControl: String): Call<Data>

    @GET("{page}/get_data.json")
    fun getData(@Path("page") page: Int): Call<Data>

    @GET("get_data.json")
    fun getData(@Query("u") user: String, @Query("t") token: String): Call<Data>

    @DELETE("data/{id}")
    fun deleteData(@Path("id") id: String): Call<ResponseBody>

    @POST("data/create")
    fun createData(@Body data: Data): Call<ResponseBody>


}