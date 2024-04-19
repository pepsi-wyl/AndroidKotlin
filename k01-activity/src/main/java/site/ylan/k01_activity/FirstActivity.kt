package site.ylan.k01_activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import site.ylan.k01_activity.Utils.ToastUtils
import site.ylan.k01_activity.base.BaseActivity
import site.ylan.k01_activity.databinding.FirstActivityBinding

class FirstActivity : BaseActivity<FirstActivityBinding>() {

    private lateinit var register: ActivityResultLauncher<Intent>

    // 重写BaseActivity的onCreated方法实现onCreate方法的调用
    override fun onCreated(savedInstanceState: Bundle?) {

//        register =
//            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult? ->
//                if (result != null) {
//                    val intent = result.data
//                    if (intent != null && result.resultCode == RESULT_OK) {
//                        val returnedData = intent.getStringExtra("return_data")
//                        Log.d("FirstActivity", "returned data is $returnedData")
//                    }
//                }
//            }


        binding.button1.setOnClickListener {
            // 在Activity中使用Toast
            ToastUtils.show(this, "You clicked Button 1")
        }

        binding.button2.setOnClickListener {
            // Activity的销毁
            finish()
        }

        binding.button3.setOnClickListener {
            // 显示意图Activity跳转
//            val intent = Intent(this, SecondActivity::class.java)
//            val data = "Hello SecondActivity"
//            intent.putExtra("send_data", data)
            SecondActivity.actionStart(this, "Hello SecondActivity")

//            startActivity(intent)
            startActivityForResult(intent, 1)
        }

        binding.button4.setOnClickListener {
            // 隐式意图Activity跳转
            val intent = Intent()
            intent.action = "site.ylan.k01_activity.actionStart"
            intent.addCategory("site.ylan.k01_activity.MY_CATEGORY")
            startActivity(intent)
        }

        binding.button5.setOnClickListener {
            // 隐式意图打开浏览器
            val intent = Intent()
            // Action为android.intent.action.VIEW
            intent.action = Intent.ACTION_VIEW
            // 携带Data数据
            intent.data = Uri.parse("https://www.baidu.com")
            startActivity(intent)
        }

        binding.button6.setOnClickListener {
            // 隐式意图打开电话
            val intent = Intent()
            // Action为android.intent.action.DIAL
            intent.action = Intent.ACTION_DIAL
            // 携带Data数据
            intent.data = Uri.parse("tel:13673330837")
            startActivity(intent)

//            register.launch(intent)
        }
    }

    // onCreateOptionsMenu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // 语法糖 getMenuInflater==menuInflater
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    // onOptionsItemSelected
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // 语法糖 getItemId==itemId
        when (item.itemId) {
            R.id.add_item -> ToastUtils.show(this, "You clicked Add")
            R.id.remove_item -> ToastUtils.show(this, "You clicked Remove")
        }
        return true
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            1 -> if (resultCode == RESULT_OK) {
                val returnedData = data?.getStringExtra("return_data")
                Log.d("FirstActivity", "returned data is $returnedData")
            }
        }
    }
}