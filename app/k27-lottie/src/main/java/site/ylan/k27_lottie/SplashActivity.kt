package site.ylan.k27_lottie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import site.ylan.k27_lottie.MainActivity.Companion.startMainActivity
import site.ylan.k27_lottie.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    private val binding: ActivitySplashBinding by lazy { ActivitySplashBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // 延迟启动主活动
        Handler().postDelayed({
            startMainActivity(this)
            finish()
        }, 10000) // 延迟10s
    }
}