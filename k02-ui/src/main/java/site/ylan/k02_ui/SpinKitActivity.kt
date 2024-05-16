package site.ylan.k02_ui

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import com.github.ybq.android.spinkit.sprite.Sprite
import com.github.ybq.android.spinkit.style.DoubleBounce
import site.ylan.k02_ui.base.BaseActivity
import site.ylan.k02_ui.databinding.ActivitySpinKitBinding

class SpinKitActivity : BaseActivity<ActivitySpinKitBinding>() {

    private lateinit var progressBar: ProgressBar

    override fun onCreated(savedInstanceState: Bundle?) {

        window.setBackgroundDrawableResource(R.color.black)

        progressBar = binding.spinKit
        val doubleBounce: Sprite = DoubleBounce()
        progressBar.indeterminateDrawable = doubleBounce
        progressBar.visibility = View.VISIBLE



    }
}