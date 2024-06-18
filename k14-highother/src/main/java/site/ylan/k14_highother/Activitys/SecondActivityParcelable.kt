package site.ylan.k14_highother.Activitys

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import site.ylan.k14_highother.databinding.ActivitySecondBinding
import site.ylan.k14_highother.model.bean.PersonParcelable
import site.ylan.k14_highother.startActivity

class SecondActivityParcelable : AppCompatActivity() {

    companion object {
        var PERSON_PARCELABLE = "person_parcelable"

        fun startActivity(context: Context, personParcelable: PersonParcelable) {
            startActivity<SecondActivityParcelable>(context) {
                putExtra(PERSON_PARCELABLE, personParcelable)
            }
        }
    }

    // ActivitySecondBinding
    private val binding: ActivitySecondBinding by lazy {
        ActivitySecondBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // 获取PersonParcelable数据
        val personParcelable =
            intent.getParcelableExtra<PersonParcelable>(PERSON_PARCELABLE)
        binding.name.text = personParcelable?.name
        binding.age.text = personParcelable?.age.toString()
    }
}