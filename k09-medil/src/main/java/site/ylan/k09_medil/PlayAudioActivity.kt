package site.ylan.k09_medil

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import site.ylan.k09_medil.databinding.ActivityPlayAudioBinding

class PlayAudioActivity : AppCompatActivity() {

    // MediaPlayer
    private val mediaPlayer by lazy {
        MediaPlayer()
    }

    // ActivityPlayAudioBinding
    private val binding: ActivityPlayAudioBinding by lazy {
        ActivityPlayAudioBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.init.setOnClickListener {
            // 初始化播放器
            initMediaPlayer()
        }

        binding.play.setOnClickListener {
            // 开始播放
            if (!mediaPlayer.isPlaying) mediaPlayer.start()
        }

        binding.pause.setOnClickListener {
            // 暂停播放
            if (mediaPlayer.isPlaying) mediaPlayer.pause()
        }

        binding.stop.setOnClickListener {
            // 停止播放
            if (mediaPlayer.isPlaying) mediaPlayer.reset()
        }
    }

    /**
     * 初始化播放器
     */
    private fun initMediaPlayer() {
        val fd = assets.openFd("music.mp3")
        mediaPlayer.setDataSource(fd.fileDescriptor, fd.startOffset, fd.length)
        mediaPlayer.prepare()
    }

    /**
     * 销毁时释放资源
     */
    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.stop()
        mediaPlayer.release()
    }
}