package site.ylan.k14_highother.Activitys

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import site.ylan.k14_highother.Application.MainApplication
import site.ylan.k14_highother.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // ActivityMainBinding
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // Intent传递对象 测试
        binding.intentTraObject.setOnClickListener {
            startActivity(Intent(MainApplication.globeContext, FirstActivity::class.java))
        }
    }
}