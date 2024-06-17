package site.ylan.k14_highother.Activitys

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import site.ylan.k14_highother.Application.MainApplication
import site.ylan.k14_highother.databinding.ActivityFirstBinding
import site.ylan.k14_highother.model.bean.PersonParcelable
import site.ylan.k14_highother.model.bean.PersonSerializable

class FirstActivity : AppCompatActivity() {

    companion object {
        val PERSON_SERIALIZABLE = "person_serializable"
        var PERSON_PARCELABLE = "person_parcelable"
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
            // Intent跳转
            val intent =
                Intent(MainApplication.globeContext, SecondActivitySerializable::class.java)
            intent.putExtra(PERSON_SERIALIZABLE, personSerializable)
            startActivity(intent)
        }

        // 跳转到SecondActivity Parcelable传递数据
        binding.startToSecondActivityParcelable.setOnClickListener {
            // PersonParcelable
            val personParcelable = PersonParcelable()
            personParcelable.name = "Ylan-Parcelable"
            personParcelable.age = 23
            // Intent跳转
            val intent =
                Intent(MainApplication.globeContext, SecondActivityParcelable::class.java)
            intent.putExtra(PERSON_PARCELABLE, personParcelable)
            startActivity(intent)
        }
    }
}