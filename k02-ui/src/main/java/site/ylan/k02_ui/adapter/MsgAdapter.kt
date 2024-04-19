package site.ylan.k02_ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import site.ylan.k02_ui.R
import site.ylan.k02_ui.adapter.viewHolder.LeftViewHolder
import site.ylan.k02_ui.adapter.viewHolder.MsgViewHolder
import site.ylan.k02_ui.adapter.viewHolder.RightViewHolder
import site.ylan.k02_ui.model.entity.Msg

class MsgAdapter(val msgList: List<Msg>) : RecyclerView.Adapter<MsgViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
    if (viewType == Msg.TYPE_RECEIVED) {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.msg_left_item, parent, false)
        LeftViewHolder(view)
    } else {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.msg_right_item, parent, false)
        RightViewHolder(view)
    }

    override fun onBindViewHolder(holder: MsgViewHolder, position: Int) {
        val msg = msgList[position]
        when (holder) {
            is LeftViewHolder -> {
                holder.leftMsg.text = msg.content
            }
            is RightViewHolder -> {
                holder.rightMsg.text = msg.content
            }
        }
    }

    override fun getItemViewType(position: Int) =  msgList[position].type

    override fun getItemCount() = msgList.size
}