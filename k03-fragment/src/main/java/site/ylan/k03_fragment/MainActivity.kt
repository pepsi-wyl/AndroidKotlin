package site.ylan.k03_fragment

import android.annotation.SuppressLint
import android.app.PendingIntent.getActivity
import android.os.Bundle
import android.util.DisplayMetrics
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private var flag: Boolean = true

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        replaceFragment(RightFragment())
//        findViewById<Button>(R.id.button).setOnClickListener {
//            if (flag) {
//                flag = false
//                replaceFragment(AnotherRightFragment())
//            } else {
//                flag = true
//                replaceFragment(RightFragment())
//            }
//        }

    }

//    private fun replaceFragment(fragment: Fragment) {
//        // 获取FragmentManager
//        val fragmentManager = supportFragmentManager
//
//        // 利用FragmentManager获取Fragment
//        val leftFragment = fragmentManager.findFragmentById(R.id.leftFrag) as LeftFragment
//
//        // 开启一个事务
//        val transaction = fragmentManager.beginTransaction()
//        // 向容器内添加或替换Fragment
//        transaction.replace(R.id.rightLayout, fragment)
//        // 添加进Back返回栈
//        transaction.addToBackStack(null)
//        // 提交事务
//        transaction.commit()
//    }
}