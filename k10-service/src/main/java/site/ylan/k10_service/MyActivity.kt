package site.ylan.k10_service

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.widget.Button

class MyActivity : AppCompatActivity() {

    private lateinit var startServiceBtn : Button
    private lateinit var stopServiceBtn : Button
    private lateinit var bindServiceBtn : Button
    private lateinit var unbindServiceBtn : Button
    private lateinit var downloadBinder: MyService.DownloadBinder

    // ServiceConnection
    private val connection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName, service: IBinder) {
            downloadBinder = service as MyService.DownloadBinder

            downloadBinder.startDownload()
            downloadBinder.getProgress()
        }

        override fun onServiceDisconnected(name: ComponentName) {

        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_service)

        startServiceBtn = findViewById(R.id.startServiceBtn)
        stopServiceBtn = findViewById(R.id.stopServiceBtn)
        bindServiceBtn = findViewById(R.id.bindServiceBtn)
        unbindServiceBtn = findViewById(R.id.unbindServiceBtn)

        startServiceBtn.setOnClickListener {
            val intent = Intent(this, MyService::class.java)
            // 启动Service
            startService(intent)
        }

        stopServiceBtn.setOnClickListener {
            val intent = Intent(this, MyService::class.java)
            // 停止Service
            stopService(intent)
        }

        bindServiceBtn.setOnClickListener {
            val intent = Intent(this, MyService::class.java)
            // 绑定Service
            bindService(intent, connection, Context.BIND_AUTO_CREATE)
        }

        unbindServiceBtn.setOnClickListener {
            // 解绑Service
            unbindService(connection)
        }

    }
}