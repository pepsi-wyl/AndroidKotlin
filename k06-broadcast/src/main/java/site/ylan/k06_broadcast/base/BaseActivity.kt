package site.ylan.k06_broadcast.base

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import site.ylan.k06_broadcast.ForceOfflineActivity
import site.ylan.k06_broadcast.LoginActivity
import java.lang.reflect.ParameterizedType

abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {

    // protected ViewBind变量
    protected lateinit var binding: VB

    // 强制下线功能广播接受者
    private lateinit var receiver: ForceOfflineReceiver
    private lateinit var intentFilter: IntentFilter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val type = javaClass.genericSuperclass
        if (type is ParameterizedType) {

            // Clazz And Method
            val clazz = type.actualTypeArguments[0] as Class<VB>
            val method = clazz.getMethod("inflate", LayoutInflater::class.java)

            // 执行invoke方法
            binding = method.invoke(null, layoutInflater) as VB

            // 设置视图
            setContentView(binding.root)
        }

        ActivityCollector.addActivity(this)

        onCreated(savedInstanceState)
    }

    // 子类覆盖该方法即可
    abstract fun onCreated(savedInstanceState: Bundle?)

    override fun onResume() {
        super.onResume()
        intentFilter = IntentFilter(ForceOfflineActivity.action)
        receiver = ForceOfflineReceiver()
        registerReceiver(receiver, intentFilter)
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(receiver)
    }

    override fun onDestroy() {
        super.onDestroy()
        ActivityCollector.removeActivity(this)
    }

    inner class ForceOfflineReceiver : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            AlertDialog.Builder(context).apply {
                setTitle("Warning")
                setMessage("You are forced to be offline. Please try to login again.")
                setCancelable(false)
                setPositiveButton("OK") { _, _ ->
                    // 销毁所有Activity
                    ActivityCollector.finishAll()
                    // 重新启动LoginActivity
                    context.startActivity(Intent(context, LoginActivity::class.java))
                }
                show()
            }
        }
    }

}