package site.ylan.k02_ui

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import site.ylan.k02_ui.adapter.MsgAdapter
import site.ylan.k02_ui.base.BaseActivity
import site.ylan.k02_ui.databinding.ActivityMsgBinding
import site.ylan.k02_ui.model.entity.Msg

class MsgActivity : BaseActivity<ActivityMsgBinding>(), View.OnClickListener {

    private val msgList = ArrayList<Msg>()

    private fun initMsg() {
        msgList.apply {
            add(Msg("1", Msg.TYPE_SENT))
            add(Msg("2", Msg.TYPE_RECEIVED))
            add(Msg("3", Msg.TYPE_SENT))
            add(Msg("4", Msg.TYPE_RECEIVED))
            add(Msg("5", Msg.TYPE_SENT))
            add(Msg("6", Msg.TYPE_RECEIVED))
            add(
                Msg(
                    "asdasdadasfasdasdadasdddadasdafcasfaddkfjkkhjkfjksjafhjksfkjsdfkdadadasdasdasd",
                    Msg.TYPE_SENT
                )
            )
            add(Msg("8", Msg.TYPE_RECEIVED))
            add(Msg("9", Msg.TYPE_SENT))
            add(Msg("10", Msg.TYPE_RECEIVED))
            add(Msg("11", Msg.TYPE_SENT))
            add(Msg("12", Msg.TYPE_RECEIVED))
            add(Msg("13", Msg.TYPE_SENT))
            add(Msg("14", Msg.TYPE_RECEIVED))
        }
    }

    private lateinit var adapter: MsgAdapter
    private lateinit var layoutManager: LinearLayoutManager
    private lateinit var recyclerView: RecyclerView
    private lateinit var send: Button
    private lateinit var inputText: EditText

    override fun onCreated(savedInstanceState: Bundle?) {

        recyclerView = binding.recyclerView
        send = binding.send
        inputText = binding.inputText

        initMsg()

        layoutManager = LinearLayoutManager(this)
        if (!::adapter.isInitialized) adapter = MsgAdapter(msgList)

        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter

        send.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view) {
            send -> {
                val content = inputText.text.toString()
                if (content.isNotEmpty()) {
                    // 构建消息
                    val msg = Msg(content, Msg.TYPE_SENT)
                    // 消息加入msgList中
                    msgList.add(msg)
                    // 刷新RecyclerView中的数据 增量刷新
                    adapter.notifyItemInserted(msgList.size - 1)
                    // 刷新RecyclerView中的数据 全量刷新
//                    adapter.notifyDataSetChanged()
                    // 将RecyclerView定位到最后一行
                    recyclerView.scrollToPosition(msgList.size - 1)
                    // 清空输入框中的内容
                    inputText.setText("")
                }
            }
        }
    }

}