package site.ylan.k02_ui.adapter.viewHolder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import site.ylan.k02_ui.R

// 密封类
sealed class MsgViewHolder(view: View) : RecyclerView.ViewHolder(view)
// 子类
class LeftViewHolder(view: View) : MsgViewHolder(view) {
    val leftMsg: TextView = view.findViewById(R.id.leftMsg)
}
// 子类
class RightViewHolder(view: View) : MsgViewHolder(view) {
    val rightMsg: TextView = view.findViewById(R.id.rightMsg)
}