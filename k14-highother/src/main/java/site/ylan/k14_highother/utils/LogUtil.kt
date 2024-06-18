package site.ylan.k14_highother.utils

import android.util.Log


/**
 * @author: ylan
 */
object LogUtil {

    // 日志级别
    private const val VERBOSE = 1
    private const val DEBUG = 2
    private const val INFO = 3
    private const val WARN = 4
    private const val ERROR = 5

    // 默认日志级别
    private var level = VERBOSE

    /**
     * Verbose
     */
    fun v(tag: String, msg: String) {
        if (level <= VERBOSE) {
            Log.v(tag, msg)
        }
    }

    /**
     * Debug
     */
    fun d(tag: String, msg: String) {
        if (level <= DEBUG) {
            Log.d(tag, msg)
        }
    }

    /**
     * Info
     */
    fun i(tag: String, msg: String) {
        if (level <= INFO) {
            Log.i(tag, msg)
        }
    }

    /**
     * Warn
     */
    fun w(tag: String, msg: String) {
        if (level <= WARN) {
            Log.w(tag, msg)
        }
    }

    /**
     * Error
     */
    fun e(tag: String, msg: String) {
        if (level <= ERROR) {
            Log.e(tag, msg)
        }
    }
}