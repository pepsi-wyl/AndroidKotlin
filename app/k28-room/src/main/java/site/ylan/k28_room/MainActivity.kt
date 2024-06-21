package site.ylan.k28_room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import site.ylan.k28_room.databinding.ActivityMainBinding
import site.ylan.k28_room.date.AppDatabase
import site.ylan.k28_room.date.model.User
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    // binding
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    // appDatabase
    private val appDatabase by lazy {
        AppDatabase.getAppDatabaseInstance(this)
    }

    // userDao
    private val userDao by lazy {
        appDatabase.userDao()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val user1 = User("Tom", "Brady", 40)
        val user2 = User("Tom", "Hanks", 63)

        // 添加数据
        binding.addDataBtn.setOnClickListener {
            thread {
                user1.id = userDao.insertUser(user1)
                user2.id = userDao.insertUser(user2)
            }
        }

        // 更新数据
        binding.updateDataBtn.setOnClickListener {
            thread {
                user1.age = 42
                userDao.updateUser(user1)
            }
        }

        // 删除数据
        binding.deleteDataBtn.setOnClickListener {
            thread {
                userDao.deleteUserByLastName("Hanks")
            }
        }

        // 查询数据
        binding.queryDataBtn.setOnClickListener {
            thread {
                for (user in userDao.loadAllUsers()) {
                    Log.d("MainActivity", user.toString())
                }
            }
        }
    }

}