package site.ylan.k07_filedb.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import site.ylan.k07_filedb.R
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class FileActivity : AppCompatActivity() {

    private val fileName = "data"

    private lateinit var editText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_file)
        editText = findViewById(R.id.editText)
        initDate()
    }

    override fun onDestroy() {
        super.onDestroy()
        val inputText = editText.text.toString()
        save(inputText)
    }

    private fun initDate() {
        val inputText = load()
        if (inputText.isNotEmpty()) {
            editText.setText(inputText)              // 文本内容
            editText.setSelection(inputText.length)  // 输入框光标移动到尾部
            Toast.makeText(this, "Restoring succeeded", Toast.LENGTH_SHORT).show()
        }
    }

    private fun save(inputText: String) {
        // BufferedWriter流
        val writer =
            BufferedWriter(OutputStreamWriter(openFileOutput(fileName, Context.MODE_PRIVATE)))
        // use保证使用过后关闭流
        writer.use {
            it.write(inputText)
        }
    }

    // 加载文件内容
private fun load(): String {
        // 创建StringBuilder对象
        val builder = StringBuilder()
        // 使用BufferedReader流
        val reader = BufferedReader(InputStreamReader(openFileInput(fileName)))
        // 使用use确保流在操作完成后关闭
        reader.use {
            // 遍历每行内容
            reader.forEachLine {
                // 将每行内容添加到StringBuilder中
                builder.append(it)
            }
        }
        // 返回数据
        return builder.toString()
    }

}