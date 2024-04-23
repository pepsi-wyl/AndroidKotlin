package site.ylan.k06_broadcast

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    var action: String = "site.ylan.broadcast.YLAN_BROADCAST"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            // Intent对象 + Action
            val intent = Intent(action)
            // 设置指定包名，指定这条广播是发送给哪个应用程序的
            intent.setPackage(packageName)
            // 发送无序广播
//            sendBroadcast(intent)
            // 发送有序广播
            sendOrderedBroadcast(intent,null)
        }

    }

}