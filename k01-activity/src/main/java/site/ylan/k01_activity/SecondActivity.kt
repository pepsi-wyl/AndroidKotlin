package site.ylan.k01_activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import site.ylan.k01_activity.base.BaseActivity
import site.ylan.k01_activity.databinding.ActivitySecondBinding
import site.ylan.k01_activity.databinding.FirstActivityBinding

class SecondActivity : BaseActivity<ActivitySecondBinding>() {

    /**
     * 启动SecondActivity
     */
    companion object{
        fun actionStart(context: Context, data: String){
//            val intent = Intent(context, SecondActivity::class.java)
//            intent.putExtra("send_data", data)
            val intent = Intent(context, SecondActivity::class.java).apply {
                putExtra("send_data", data)
            }
            context.startActivity(intent)
        }
    }

    // 重写BaseActivity的onCreated方法实现onCreate方法的调用
    override fun onCreated(savedInstanceState: Bundle?) {

        // intent==getIntent()
        val extraData = intent.getStringExtra("send_data")
        binding.tv1.text = extraData

        binding.button1.setOnClickListener {
            val intent = Intent()
            val data = "Hello FirstActivity"

            intent.putExtra("return_data",data)
            // 发送数据
            setResult(RESULT_OK, intent)
            // 销毁页面
            finish()
        }
    }

    override fun onBackPressed() {
        val intent = Intent()
        val data = "Hello FirstActivity"
        intent.putExtra("return_data",data)
        // 发送数据
        setResult(RESULT_OK, intent)
        // 销毁页面
        finish()
    }

}