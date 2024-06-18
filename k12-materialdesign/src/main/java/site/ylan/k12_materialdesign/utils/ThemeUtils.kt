package site.ylan.k12_materialdesign.utils

import android.content.Context
import android.content.res.Configuration

/**
 * # ThemeUtils
 */
class ThemeUtils {

    companion object {

        // 判断当前是否是深色模式
        fun isDarkTheme(context: Context): Boolean {
            val flag = context.resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
            return flag == Configuration.UI_MODE_NIGHT_YES
        }
    }
}