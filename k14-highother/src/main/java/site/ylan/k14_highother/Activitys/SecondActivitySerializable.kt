package site.ylan.k14_highother.Activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import site.ylan.k14_highother.databinding.ActivitySecondBinding
import site.ylan.k14_highother.model.bean.PersonSerializable

class SecondActivitySerializable : AppCompatActivity() {

    // ActivitySecondBinding
    private val binding: ActivitySecondBinding by lazy {
        ActivitySecondBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // 获取PersonSerializable数据
        val personSerializable =
            intent.getSerializableExtra(FirstActivity.PERSON_SERIALIZABLE) as PersonSerializable
        binding.name.text = personSerializable.name
        binding.age.text = personSerializable.age.toString()
    }
}