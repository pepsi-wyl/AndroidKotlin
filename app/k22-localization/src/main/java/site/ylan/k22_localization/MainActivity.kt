package site.ylan.k22_localization

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import site.ylan.k22_localization.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(
            layoutInflater,
            null,
            false
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val tv1 = binding.tv1
        val tv2 = binding.tv2
        tv2.text = ""
        val btn = binding.btn

        btn.setOnClickListener {
            tv2.setText(R.string.message)
        }

    }
}