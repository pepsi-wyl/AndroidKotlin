package site.ylan.k24_score

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import site.ylan.k24_score.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 实例化DataBinding对象
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    }
}