package site.ylan.k11_net

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import site.ylan.k11_net.base.BaseActivity
import site.ylan.k11_net.databinding.ActivityHttpUrlconnectionBinding
import java.io.BufferedReader
import java.io.DataOutputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import kotlin.concurrent.thread
import kotlin.text.StringBuilder as StringBuilder

class HttpURLConnectionActivity : BaseActivity<ActivityHttpUrlconnectionBinding>() {

    private lateinit var sendRequestBtn: Button
    private lateinit var responseText: TextView

    override fun onCreated(savedInstanceState: Bundle?) {
        sendRequestBtn = binding.sendRequestBtn
        responseText = binding.responseText

        sendRequestBtn.setOnClickListener {
            sendRequestWithHttpURLConnection()
        }
    }

    private fun sendRequestWithHttpURLConnection() {
        // 开启线程发起网络请求
        thread {
            // HttpURLConnection连接
            var connection: HttpURLConnection? = null
            try {
                // 打开连接
                connection = URL("https://www.baidu.com").openConnection() as HttpURLConnection

                // 请求方法
                connection.requestMethod = "GET"
                connection.requestMethod = "POST"

                // Post方法携带数据
                val outputStream = DataOutputStream(connection.outputStream)
                outputStream.writeBytes("username=admin&password=123456")

                // 设置连接超时时间
                connection.connectTimeout = 8000
                // 设置读取超时时间
                connection.readTimeout = 8000

                // 获取服务器返回的输入流
                val inputStream = connection.inputStream

                // 使用BufferedReader读取数据
                val response = StringBuilder()
                val reader = BufferedReader(InputStreamReader(inputStream))
                reader.use {
                    reader.forEachLine {
                        response.append(it)
                    }
                }

                // 刷新UI
                showResponse(response.toString())

            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                // 关闭连接
                connection?.disconnect()
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