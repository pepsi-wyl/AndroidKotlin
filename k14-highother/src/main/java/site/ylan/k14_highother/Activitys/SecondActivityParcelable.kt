package site.ylan.k14_highother.Activitys

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import site.ylan.k14_highother.databinding.ActivitySecondBinding
import site.ylan.k14_highother.model.bean.PersonParcelable

class SecondActivityParcelable : AppCompatActivity() {

    // ActivitySecondBinding
    private val binding: ActivitySecondBinding by lazy {
        ActivitySecondBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // 获取PersonParcelable数据
        val personParcelable =
            intent.getParcelableExtra<PersonParcelable>(FirstActivity.PERSON_PARCELABLE)
        binding.name.text = personParcelable?.name
        binding.age.text = personParcelable?.age.toString()
    }
}