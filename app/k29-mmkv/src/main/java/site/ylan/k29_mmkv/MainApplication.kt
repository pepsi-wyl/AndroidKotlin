package site.ylan.k29_mmkv

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.elvishew.xlog.LogLevel
import com.elvishew.xlog.XLog
import com.tencent.mmkv.MMKV
import site.ylan.k29_mmkv.repository.loacl.cache.MMKVManger

class MainApplication : Application() {

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var globeContext: Context
    }

    override fun onCreate() {
        super.onCreate()

        initGlobeContext()
        initMMKV()
        initXLog()
    }

    private fun initGlobeContext() {
        globeContext = applicationContext
    }

    private fun initMMKV() {
        MMKV.initialize(globeContext)

        val sharedPreferences = getSharedPreferences("your_sharedPreferences_name", Context.MODE_PRIVATE)
        MMKVManger.getSPMMKV().importFromSharedPreferences(sharedPreferences)
        sharedPreferences.edit().clear().apply()
    }

    private fun initXLog() {
        XLog.init(LogLevel.ALL)
    }

}