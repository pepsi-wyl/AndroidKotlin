package site.ylan.k11_net.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import java.lang.reflect.ParameterizedType

abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {

    // protected ViewBind变量
    protected lateinit var binding: VB

    // BINDING_METHOD常量
    private val BINDING_METHOD: String = "inflate"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val type = javaClass.genericSuperclass
        if (type is ParameterizedType) {

            // Clazz And Method
            val clazz = type.actualTypeArguments[0] as Class<VB>
            val method = clazz.getMethod(BINDING_METHOD, LayoutInflater::class.java)

            // 执行invoke方法
            binding = method.invoke(null, layoutInflater) as VB

            // 设置视图
            setContentView(binding.root)
        }

        // 添加进ActivityCollector
        ActivityCollector.addActivity(this)

        onCreated(savedInstanceState)
    }

    // 子类覆盖该方法即可
    abstract fun onCreated(savedInstanceState: Bundle?)

    override fun onDestroy() {
        super.onDestroy()

        // 从ActivityCollector删除
        ActivityCollector.removeActivity(this)
    }

}