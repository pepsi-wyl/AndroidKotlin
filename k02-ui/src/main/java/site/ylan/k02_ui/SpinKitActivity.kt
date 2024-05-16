package site.ylan.k02_ui

import android.app.Activity
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.ProgressBar
import com.github.ybq.android.spinkit.sprite.Sprite
import com.github.ybq.android.spinkit.style.DoubleBounce
import com.github.ybq.android.spinkit.style.FadingCircle
import com.github.ybq.android.spinkit.style.Wave
import site.ylan.k02_ui.base.BaseActivity
import site.ylan.k02_ui.databinding.ActivitySpinKitBinding


class SpinKitActivity : BaseActivity<ActivitySpinKitBinding>() {

    private lateinit var progressBar: ProgressBar

    override fun onCreated(savedInstanceState: Bundle?) {

        // 设置状态栏透明
        makeStatusBarTransparent(this);
        // 状态栏文字自适应
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)
        // 设置全屏黑色
        window.setBackgroundDrawableResource(R.color.black)

        // 进度条
        progressBar = binding.spinKit
        val doubleBounce: Sprite = DoubleBounce()
        val fadingCircle: Sprite = FadingCircle()
        val wave: Sprite = Wave()
        progressBar.indeterminateDrawable = wave
        progressBar.visibility = View.VISIBLE

    }

    fun makeStatusBarTransparent(activity: Activity) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
            return
        }
        val window = activity.window
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            val option =
                window.decorView.systemUiVisibility or View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            window.decorView.systemUiVisibility = option
            window.statusBarColor = Color.TRANSPARENT
        } else {
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        }
    }
}