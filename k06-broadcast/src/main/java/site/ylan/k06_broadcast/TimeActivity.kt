package site.ylan.k06_broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class TimeActivity: AppCompatActivity() {

    private lateinit var timeChangeReceiver: TimeChangeReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time)

        // IntentFilter的实例 + 接收广播的Action值
        val intentFilter = IntentFilter("android.intent.action.TIME_TICK")

        // BroadcastReceiver实例
        timeChangeReceiver = TimeChangeReceiver()

        // 调用registerReceiver()方法进行注册 BroadcastReceiver实例+IntentFilter的实例
        registerReceiver(timeChangeReceiver, intentFilter)
    }

    override fun onDestroy() {
        super.onDestroy()

        // unregisterReceiver()方法取消注册 BroadcastReceiver实例
        unregisterReceiver(timeChangeReceiver)
    }

    /**
     * 继承BroadcastReceiver重写onReceive方法
     */
    inner class TimeChangeReceiver : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            Toast.makeText(context, "Time has changed", Toast.LENGTH_SHORT).show()
        }
    }
}