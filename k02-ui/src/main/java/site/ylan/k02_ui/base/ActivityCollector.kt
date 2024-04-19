package site.ylan.k02_ui.base

import android.app.Activity

object ActivityCollector {
    // 集合
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