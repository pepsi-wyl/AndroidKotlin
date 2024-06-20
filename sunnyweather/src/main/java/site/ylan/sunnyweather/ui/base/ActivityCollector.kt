package site.ylan.sunnyweather.ui.base

import android.app.Activity

/**
 * ActivityCollector
 * @author: ylan
 */
object ActivityCollector {

    private val activities = ArrayList<Activity>()

    fun addActivity(activity: Activity) {
        activities.add(activity)
    }

    fun removeActivity(activity: Activity) {
        activities.remove(activity)
    }

    fun finishAll() {
        for (activity in activities) {
            if (!activity.isFinishing) activity.finish()
        }
        activities.clear()
    }

}