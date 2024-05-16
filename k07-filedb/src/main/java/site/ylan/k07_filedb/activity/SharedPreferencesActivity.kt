package site.ylan.k07_filedb.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import site.ylan.k07_filedb.R

class SharedPreferencesActivity : AppCompatActivity() {

    private lateinit var saveButton: Button
    private lateinit var restoreButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preferences)

        saveButton = findViewById(R.id.saveButton)
        restoreButton = findViewById(R.id.restoreButton)

        saveButton.setOnClickListener {
            /** 保存数据到SharedPreferences **/
            // 获取共享 preferences 文件
            val sharedPreferences = getSharedPreferences("data", MODE_PRIVATE)
            // 获取编辑器
            val editor = sharedPreferences.edit()
            // 将 key 对应的数据存入 value
            editor.putString("key", "value")
            // 提交数据，保存更改
            editor.apply()
        }

        restoreButton.setOnClickListener {
            /** 从SharedPreferences读取数据 **/
            // 获取共享 preferences 文件
            val sharedPreferences = getSharedPreferences("data", MODE_PRIVATE)
            // 获取数据
            val value = sharedPreferences.getString("key", "default")
            Log.i("SharedPreferences", "value: $value")
        }
    }
}