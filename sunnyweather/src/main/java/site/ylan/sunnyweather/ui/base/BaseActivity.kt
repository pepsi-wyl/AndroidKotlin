package site.ylan.sunnyweather.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import site.ylan.sunnyweather.common.Constants
import java.lang.reflect.ParameterizedType

/**
 * BaseActivity
 * @author: ylan
 */
abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {

    protected val TAG = javaClass.simpleName
    protected lateinit var binding: VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val type = javaClass.genericSuperclass
        if (type is ParameterizedType) {

            val clazz = type.actualTypeArguments[0] as Class<*>
            val method = clazz.getMethod(Constants.BINDING_METHOD, LayoutInflater::class.java)

            binding = method.invoke(null, layoutInflater) as VB

            setContentView(binding.root)
        }

        ActivityCollector.addActivity(this)

        onCreated(savedInstanceState)
    }

    abstract fun onCreated(savedInstanceState: Bundle?)

    override fun onDestroy() {
        super.onDestroy()
        ActivityCollector.removeActivity(this)
    }

}