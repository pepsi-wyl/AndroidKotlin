package site.ylan.k29_mmkv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import site.ylan.k29_mmkv.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}