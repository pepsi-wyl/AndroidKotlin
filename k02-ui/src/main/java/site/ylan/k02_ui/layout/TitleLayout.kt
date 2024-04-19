package site.ylan.k02_ui.layout

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import site.ylan.k02_ui.R

class TitleLayout(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {
    init {
        // 引入View
        val view = LayoutInflater.from(context).inflate(R.layout.title, this)

        // 设置点击事件
        view.findViewById<Button>(R.id.titleBack).setOnClickListener {
            val activity = context as Activity
            activity.finish()
        }

        // 设置点击事件
        view.findViewById<Button>(R.id.titleEdit).setOnClickListener {
            Toast.makeText(context, "You clicked Edit button", Toast.LENGTH_SHORT).show()
        }
    }
}