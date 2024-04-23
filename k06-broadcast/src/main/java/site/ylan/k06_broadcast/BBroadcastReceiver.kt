package site.ylan.k06_broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class BBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        Toast.makeText(context, "received in BBroadcastReceiver", Toast.LENGTH_SHORT).show()

        // 截断广播
        abortBroadcast()
    }
}