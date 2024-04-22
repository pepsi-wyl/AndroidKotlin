package site.ylan.k11_net.net.server

import retrofit2.Call
import retrofit2.http.GET
import site.ylan.k11_net.model.entity.App

interface AppService {

    @GET("get_data.json")
    fun getAppData(): Call<List<App>>
}