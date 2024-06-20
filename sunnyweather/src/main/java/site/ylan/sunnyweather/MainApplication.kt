package site.ylan.sunnyweather

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

/**
 * MainApplication
 * @author: ylan
 */
class MainApplication : Application() {

    companion object {
        /**
         * 全局上下文
         */
        @SuppressLint("StaticFieldLeak")
        lateinit var globeContext: Context
    }

    /**
     * onCreate
     */
    override fun onCreate() {
        super.onCreate()

        // 初始化全局上下文
        initGlobeContext()
    }

    /**
     * 初始化全局上下文
     */
    private fun initGlobeContext() {
        globeContext = applicationContext
    }

}