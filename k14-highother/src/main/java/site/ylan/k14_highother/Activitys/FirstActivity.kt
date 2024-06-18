package site.ylan.k14_highother.Activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import site.ylan.k14_highother.startActivity
import site.ylan.k14_highother.databinding.ActivityFirstBinding
import site.ylan.k14_highother.model.bean.PersonParcelable
import site.ylan.k14_highother.model.bean.PersonSerializable

class FirstActivity : AppCompatActivity() {

    companion object {
        fun startActivity() {
            startActivity<FirstActivity>()
        }
    }

    // ActivityFirstBinding
    private val binding: ActivityFirstBinding by lazy {
        ActivityFirstBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // 跳转到SecondActivity Serializable传递数据
        binding.startToSecondActivitySerializable.setOnClickListener {
            // PersonSerializable
            val personSerializable = PersonSerializable()
            personSerializable.name = "Ylan-Serializable"
            personSerializable.age = 23
            SecondActivitySerializable.startActivity(personSerializable)
        }

        // 跳转到SecondActivity Parcelable传递数据
        binding.startToSecondActivityParcelable.setOnClickListener {
            // PersonParcelable
            val personParcelable = PersonParcelable()
            personParcelable.name = "Ylan-Parcelable"
            personParcelable.age = 23
            SecondActivityParcelable.startActivity(this, personParcelable)
        }
    }
}