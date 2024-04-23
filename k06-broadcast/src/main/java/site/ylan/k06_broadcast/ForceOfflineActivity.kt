package site.ylan.k06_broadcast

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import site.ylan.k06_broadcast.base.BaseActivity
import site.ylan.k06_broadcast.databinding.ActivityForceOfflineBinding

class ForceOfflineActivity : BaseActivity<ActivityForceOfflineBinding>() {

    companion object{
        var action = "site.ylan.broadcast.FORCE_OFFLINE"
    }

    override fun onCreated(savedInstanceState: Bundle?) {
        val forceOffline = binding.forceOffline
        forceOffline.setOnClickListener{
            val intent = Intent(action)
            sendBroadcast(intent)
        }
    }
}