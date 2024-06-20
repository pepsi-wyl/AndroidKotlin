package site.ylan.sunnyweather

import android.os.Bundle
import site.ylan.sunnyweather.common.utils.LogUtil
import site.ylan.sunnyweather.databinding.ActivityMainBinding
import site.ylan.sunnyweather.ui.base.BaseActivity

/**
 * MainActivity
 * @author: ylan
 */
class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun onCreated(savedInstanceState: Bundle?) {
        LogUtil.d(TAG, "MainActivity 应用启动")
    }
}