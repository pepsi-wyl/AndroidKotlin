package site.ylan.k09_medil

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import site.ylan.k09_medil.databinding.ActivityPlayAudioBinding
import site.ylan.k09_medil.databinding.ActivityPlayVideoBinding

class PlayVideoActivity : AppCompatActivity() {

    // ActivityPlayVideoBinding
    private val binding: ActivityPlayVideoBinding by lazy {
        ActivityPlayVideoBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // VideoView
        val uri = Uri.parse("android.resource://$packageName/${R.raw.video}")
        binding.videoView.setVideoURI(uri)

        // 播放
        binding.play.setOnClickListener {
            if (!binding.videoView.isPlaying) binding.videoView.start()
        }

        // 暂停
        binding.pause.setOnClickListener {
            if (binding.videoView.isPlaying) binding.videoView.pause()
        }

        // 重新播放
        binding.replay.setOnClickListener {
            if (binding.videoView.isPlaying) binding.videoView.resume()
        }
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        binding.videoView.suspend()
    }
}