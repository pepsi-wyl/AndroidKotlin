package site.ylan.k09_medil

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import site.ylan.k09_medil.databinding.ActivitySendNoticeBinding

class SendNoticeActivity : AppCompatActivity() {

    // ActivitySendNoticeBinding
    private val binding: ActivitySendNoticeBinding by lazy {
        ActivitySendNoticeBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // NotificationManager
        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        // 创建通知渠道
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // 渠道ID 渠道名称 重要等级
            val channel =
                NotificationChannel("important", "important", NotificationManager.IMPORTANCE_HIGH)
            notificationManager.createNotificationChannel(channel)
        }

        // 发送通知
        binding.sendNotice.setOnClickListener {
            // pendingIntent
            val pendingIntent =
                PendingIntent.getActivity(this, 0, Intent(this, SendNoticeActivity::class.java), 0)
            // notification
            val notification = NotificationCompat.Builder(this, "important")
                .setContentTitle("This is content title")
                .setSmallIcon(R.drawable.ic_launcher_foreground)
//                .setContentText("This is content text")
                .setStyle(NotificationCompat.BigTextStyle().bigText("Learn how to build notifications, send and sync data, and use voice actions. Get the official Android IDE and developer tools to build apps for Android."))
//                .setStyle(NotificationCompat.BigPictureStyle().bigPicture(BitmapFactory.decodeResource(resources, R.drawable.big_image)))
                .setLargeIcon(
                    BitmapFactory.decodeResource(
                        resources,
                        R.drawable.ic_launcher_foreground
                    )
                )
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .build()
            notificationManager.notify(1, notification)
        }
    }
}