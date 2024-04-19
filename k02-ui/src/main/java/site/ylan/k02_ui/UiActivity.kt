package site.ylan.k02_ui

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import site.ylan.k02_ui.base.BaseActivity
import site.ylan.k02_ui.databinding.ActivityUiBinding

class UiActivity : BaseActivity<ActivityUiBinding>(), View.OnClickListener {

    private val tag = javaClass.simpleName

    private lateinit var progressBar: ProgressBar
    private lateinit var clickBtn: Button
    private lateinit var visibleBtn: Button
    private lateinit var alertBtn: Button

    override fun onCreated(savedInstanceState: Bundle?) {

        // 隐藏标题栏
        supportActionBar?.hide()

        progressBar = binding.progressBar
        clickBtn = binding.clickBtn
        visibleBtn = binding.visibleBtn
        alertBtn = binding.alertBtn

        // 获取引入布局的控件
        findViewById<Button>(R.id.titleBack).setOnClickListener(){
             finish()
        }

        // 获取引入布局的控件
        findViewById<Button>(R.id.titleEdit).setOnClickListener(){
            Toast.makeText(this, "You clicked Edit button", Toast.LENGTH_SHORT).show()
        }

        clickBtn.setOnClickListener(this)
        visibleBtn.setOnClickListener(this)
        alertBtn.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.clickBtn -> {
                progressBar.progress = progressBar.progress + 10
            }

            R.id.visibleBtn -> {
                if (progressBar.visibility == View.VISIBLE) {
                    progressBar.visibility = View.GONE
                } else {
                    progressBar.visibility = View.VISIBLE
                }
            }

            R.id.alertBtn -> {
                AlertDialog.Builder(this).apply {
                    // 标题
                    setTitle("This is Dialog")
                    // 内容
                    setMessage("Something important.")
                    // 可否使用Back键关闭对话框
                    setCancelable(false)
                    // 确定按钮的点击事件
                    setPositiveButton("OK") { dialog, which ->
                        Log.i(tag, "OK")
                    }
                    // 取消按钮的点击事件
                    setNegativeButton("Cancel") { dialog, which ->
                        Log.i(tag, "Cancel")
                    }
                    // 显示对话框
                    show()
                }
            }
        }
    }

}