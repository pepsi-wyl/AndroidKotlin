package site.ylan.k14_highother

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.View
import site.ylan.k14_highother.Application.MainApplication
import java.util.concurrent.atomic.AtomicLong

class UICommon

inline fun <reified T> startActivity(context: Context, block: Intent.() -> Unit) {
    val intent = Intent(context, T::class.java).apply {
        // 添加数据
        block()
        // 添加启动方式
        if (context !is Activity) addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    }
    context.startActivity(intent)
}

inline fun <reified T> startActivity(block: Intent.() -> Unit) {
    startActivity<T>(MainApplication.globeContext) { block() }
}

inline fun <reified T> startActivity(context: Context) {
    startActivity<T>(context) {}
}

inline fun <reified T> startActivity() {
    startActivity<T> {}
}

fun View.setSafeOnClickListener(interval: Long = 500, onSafeClick: (View) -> Unit) {
    val lastClickTime = AtomicLong(0)
    setOnClickListener {
        val currentTime = System.currentTimeMillis()
        if (currentTime - lastClickTime.get() < interval) {
            lastClickTime.set(currentTime)
            return@setOnClickListener
        }
        lastClickTime.set(currentTime)
        onSafeClick(it)
    }
}