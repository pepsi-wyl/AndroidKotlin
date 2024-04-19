package site.ylan.k10_service

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log

class MyService : Service() {

    private val mBinder : Binder = DownloadBinder()

    class DownloadBinder : Binder() {
        fun startDownload(){
            Log.d("MyService", "startDownload executed")
        }

        fun getProgress(): Int{
            Log.d("MyService", "getProgress executed")
            return 0
        }
    }

    override fun onBind(intent: Intent): IBinder {
        return mBinder
    }

    /**
     * 创建时调用
     */
    override fun onCreate() {
        super.onCreate()
        Log.d("MyService", "onCreate executed")
    }

    /**
     * 每次启动时调用
     * 执行动作的逻辑
     */
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d("MyService", "onStartCommand executed")
        return super.onStartCommand(intent, flags, startId)
    }

    /**
     * 销毁时调用
     * 回收资源
     */
    override fun onDestroy() {
        super.onDestroy()
        Log.d("MyService", "onDestroy executed")
    }
}