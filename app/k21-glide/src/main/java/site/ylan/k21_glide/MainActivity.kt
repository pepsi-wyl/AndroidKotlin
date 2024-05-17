package site.ylan.k21_glide

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import site.ylan.k21_glide.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater, null, false)
        setContentView(binding.root)

        // 网络加载图片
//        Glide.with(this)
//            .load(R.drawable.img)
//            .load("https://profile-avatar.csdnimg.cn/e70838d7b78942c4ab201f3cfbf26161_qq_44950283.jpg!1")
//            .into(binding.imageView)

        // 加载视频的第一帧图片
        Glide.with(this)
            .asBitmap()
            .load("https://v-cdn.zjol.com.cn/276985.mp4")
            .apply(RequestOptions.frameOf(0))
            .into(binding.imageView)

    }
}