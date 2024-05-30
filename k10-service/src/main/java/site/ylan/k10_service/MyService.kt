package site.ylan.k10_service

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Binder
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat
import kotlin.concurrent.thread

// 继承自系统的Service类
class MyService : Service() {

    class DownloadBinder : Binder() {
        fun startDownload() {
            Log.d("MyService", "startDownload executed")
        }

        fun getProgress(): Int {
            Log.d("MyService", "getProgress executed")
            return 0
        }
    }

    private val mBinder: Binder = DownloadBinder()

    override fun onBind(intent: Intent): IBinder {
        return mBinder
    }

    /**
     * 创建时调用
     */
    @SuppressLint("ForegroundServiceType", "UnspecifiedImmutableFlag")
    override fun onCreate() {
        super.onCreate()
        Log.d("MyService", "onCreate executed")

        /**
         * 前台Service
         */

        // Android 8.0 (Oreo) (API 级别 26) 及以上版本中，所有通知必须分配到一个通知渠道
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // 获取系统的通知服务
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            // 创建一个通知渠道
            manager.createNotificationChannel(
                NotificationChannel(
                    "MyService", // 通知渠道的 ID
                    "前台Service通知", // 通知渠道的名称
                    NotificationManager.IMPORTANCE_DEFAULT // 通知的重要性级别
                )
            )
        }

        // 构建通知
        val notification = NotificationCompat.Builder(this, "MyService")
            .setContentTitle("This is content title")  // 通知的标题
            .setContentText("This is content text")    // 通知的内容文本
            .setSmallIcon(R.drawable.baseline_mood_24) // 通知的小图标
            .setLargeIcon(                             // 通知的大图标
                BitmapFactory.decodeResource(
                    resources,
                    R.drawable.baseline_mood_24
                )
            )
            .setContentIntent(                         // 设置点击通知时的操作
                // 创建待定意图，点击通知时打开某Activity
                PendingIntent.getActivity(
                    this,
                    0,
                    Intent(this, MyActivity::class.java),
                    0
                )
            )
            .build()

        // 启动前台服务，并显示通知
        startForeground(1, notification)

    }

    /**
     * 每次启动时调用
     * 执行动作的逻辑
     */
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d("MyService", "onStartCommand executed")
        thread {
            // 处理具体的逻辑
            Thread.sleep(10000) // 线程阻塞10S
            stopSelf()
        }
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