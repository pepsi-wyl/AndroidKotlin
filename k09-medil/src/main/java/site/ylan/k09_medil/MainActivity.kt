package site.ylan.k09_medil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import site.ylan.k09_medil.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binging: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binging.root)

        // 启动CameraAlbumActivity
        binging.cameraAlbum.setOnClickListener {
            val intent = Intent(this, CameraAlbumActivity::class.java)
            startActivity(intent)
        }

    }
}