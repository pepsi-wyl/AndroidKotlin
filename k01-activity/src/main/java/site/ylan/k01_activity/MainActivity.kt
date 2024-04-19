package site.ylan.k01_activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import site.ylan.k01_activity.base.BaseActivity
import site.ylan.k01_activity.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {

//    private val tag = javaClass.simpleName
    private val tag = MainActivity::class.java.simpleName


    override fun onCreated(savedInstanceState: Bundle?) {

        Log.d(tag, "onCreate")

        // 取出暂存数据
        val tempData = savedInstanceState?.getString("data_key")
        Log.d(tag, "tempData is $tempData")

        binding.startNormalActivity.setOnClickListener {
            val intent = Intent(this, NormalActivity::class.java)
            startActivity(intent)
        }
        binding.startDialogActivity.setOnClickListener {
            val intent = Intent(this, DialogActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(tag, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(tag, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(tag, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(tag, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(tag, "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(tag, "onRestart")
    }

    // 暂存数据
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val tempData = "Something you just typed"
        outState.putString("data_key", tempData)
    }
}