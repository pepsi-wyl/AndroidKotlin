package site.ylan.k25_viewpager2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import site.ylan.k25_viewpager2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewpager2.adapter = object : FragmentStateAdapter(this) {
            override fun getItemCount(): Int = 3
            override fun createFragment(position: Int): Fragment =
                when (position) {
                    0 -> ScaleFragment()
                    1 -> RotateFragment()
                    else -> TranstateFragment()
                }
        }

        TabLayoutMediator(binding.tabLayout, binding.viewpager2) { tab, position ->
            when (position) {
                0 -> tab.text = "缩放"
                1 -> tab.text = "旋转"
                else -> tab.text = "移动"
            }
        }.attach()

    }
}