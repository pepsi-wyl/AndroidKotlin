package site.ylan.k8_contentprovider

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import site.ylan.k8_contentprovider.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // biding
    private val biding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(biding.root)

    }
}