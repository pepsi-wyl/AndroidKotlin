package site.ylan.k10_service

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlin.concurrent.thread

/**
 * 在子线程更新UI
 */

class MainActivity : AppCompatActivity() {

    // ====== UI-控件 ====== //
    private var textView:TextView? = null
    private var changeTextBtn:Button? = null

    // Handler-Message
    private var updateTextCode = 123456

    private var handler = object : Handler(Looper.getMainLooper()){
        override fun handleMessage(msg: Message) {
            // 执行更新UI操作
            when(msg.what){
                updateTextCode -> textView?.text = "Nice to meet you"
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ====== UI-控件开始 ====== //
        textView = findViewById(R.id.textView)
        changeTextBtn = findViewById(R.id.changeTextBtn)
        // ====== UI-控件结束 ====== //

        changeTextBtn?.setOnClickListener{
            thread {
                // 创建Message
                val message = Message()
                // 指定what
                message.what = updateTextCode
                // 调用handler的sendMessage方法
                handler.sendMessage(message)
            }
        }
    }
}