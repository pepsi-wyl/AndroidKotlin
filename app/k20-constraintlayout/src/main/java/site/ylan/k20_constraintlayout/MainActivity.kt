package site.ylan.k20_constraintlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import site.ylan.k20_constraintlayout.databinding.ActivityMainBinding

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
    }
}