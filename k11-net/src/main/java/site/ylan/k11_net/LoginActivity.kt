package site.ylan.k11_net

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.alibaba.fastjson2.JSON
import com.alibaba.fastjson2.JSONObject
import okhttp3.Callback
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Response
import site.ylan.k11_net.base.BaseActivity
import site.ylan.k11_net.base.HttpCallbackListener
import site.ylan.k11_net.databinding.ActivityLoginBinding
import site.ylan.k11_net.model.entity.App
import site.ylan.k11_net.model.entity.Data
import site.ylan.k11_net.model.req.LoginReq
import site.ylan.k11_net.model.resp.LoginResp
import site.ylan.k11_net.net.ServiceCreator
import site.ylan.k11_net.net.server.AppService
import site.ylan.k11_net.net.server.ExampleService
import kotlin.concurrent.thread

class LoginActivity : BaseActivity<ActivityLoginBinding>() {

    private lateinit var phoneNumberTv: EditText
    private lateinit var passwordTv: EditText
    private lateinit var loginBtn: Button

    override fun onCreated(savedInstanceState: Bundle?) {
        phoneNumberTv = binding.phoneNumberTv
        passwordTv = binding.passwordTv
        loginBtn = binding.loginBtn

        loginBtn.setOnClickListener {
            val loginReq = LoginReq()
            loginReq.phoneNumber = phoneNumberTv.text.toString()
            loginReq.password = passwordTv.text.toString()
            toSendLoginRequest(loginReq, object : HttpCallbackListener {
                override fun onSuccess(data: String) {
                    Log.i("Login",data)
                }
                override fun onFail(message: String) {
                    Log.i("Login",message)
                }
            })


            val service = ServiceCreator.create(AppService::class.java)



        }
    }

    /**
     * 发送登陆请求
     */
    private fun toSendLoginRequest(loginReq: LoginReq, listener: HttpCallbackListener) {
        thread {
            val client = OkHttpClient()

            val requestBody = RequestBody.create(
                "application/json".toMediaTypeOrNull(),
                JSON.toJSONString(loginReq)
            )
            val request = Request.Builder()
                .url("http://192.168.3.169:8080/api/v1/lejingling/user/login")
                .post(requestBody)
                .build()
            val response = client.newCall(request).execute()

            if (200 == response.code) {
                val responseBody = JSONObject.parseObject(response.body?.string())

                val code = responseBody.getString("code")
                val success = responseBody.getBoolean("success")
                if ("0" == code && true == success) {
                    val token = responseBody.getObject("data", LoginResp::class.java).token
                    listener.onSuccess(token)
                } else {
                    val message = responseBody.getString("message")
                    listener.onFail(message)
                }
            }
        }
    }

}