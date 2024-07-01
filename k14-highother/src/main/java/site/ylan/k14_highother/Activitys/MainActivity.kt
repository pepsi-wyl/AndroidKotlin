package site.ylan.k14_highother.Activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import site.ylan.k14_highother.databinding.ActivityMainBinding
import site.ylan.k14_highother.setSafeOnClickListener
import site.ylan.k14_highother.utils.LogUtil

class MainActivity : AppCompatActivity() {

    // TAG
    private val TAG = javaClass.simpleName

    // ActivityMainBinding
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // Intent传递对象 测试
//        binding.intentTraObject.setOnClickListener {
//            LogUtil.v(TAG, "点击了Intent传递对象")
//            FirstActivity.startActivity()
//        }

        binding.intentTraObject.setSafeOnClickListener(600) {
            LogUtil.v(TAG, "点击了Intent传递对象")
            FirstActivity.startActivity()
        }
    }
}