package site.ylan.k14_highother.Application

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

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