package site.ylan.k11_net

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import okhttp3.FormBody
import okhttp3.OkHttpClient
import okhttp3.Request
import site.ylan.k11_net.base.BaseActivity
import site.ylan.k11_net.databinding.ActivityOkHttpBinding
import java.io.BufferedReader
import java.io.DataOutputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import kotlin.concurrent.thread

class OkHttpActivity : BaseActivity<ActivityOkHttpBinding>() {

    private lateinit var sendRequestBtn: Button
    private lateinit var responseText: TextView

    override fun onCreated(savedInstanceState: Bundle?) {
        sendRequestBtn = binding.sendRequestBtn
        responseText = binding.responseText

        sendRequestBtn.setOnClickListener {
            sendRequestWithOkHttp()
        }
    }

    private fun sendRequestWithOkHttp() {
        // 开启线程发起网络请求
        thread {
            try {

                // OkHttpClient实例
                val client = OkHttpClient()
                // RequestBody对象
                val requestBody = FormBody.Builder()
                    .add("username", "admin")
                    .add("password", "123456")
                    .build()
                // Request对象
                val request = Request.Builder()
                    .url("https://www.baidu.com")
                    .get()
//                    .post(requestBody)
                    .build()
                // newCall()方法执行execute方法，发送请求并获取服务器返回的数据
                val response = client.newCall(request).execute()
                // 获取服务器返回的数据
                val responseData = response.body?.string()

                if (responseData != null){
                    // 刷新UI
                    showResponse(responseData)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private fun showResponse(response: String) {
        runOnUiThread {
            // 在这里进行UI操作，将结果显示到界面上
            responseText.text = response
        }
    }

}