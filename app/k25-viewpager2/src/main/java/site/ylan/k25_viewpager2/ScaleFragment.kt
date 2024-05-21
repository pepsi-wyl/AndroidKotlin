package site.ylan.k25_viewpager2

import android.animation.ObjectAnimator
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import site.ylan.k25_viewpager2.databinding.FragmentScaleBinding
import kotlin.random.Random

class ScaleFragment : Fragment() {

    private lateinit var binding: FragmentScaleBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentScaleBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.ivScale.setOnClickListener {
            val factory = if (Random.nextBoolean()) 0.1f else -0.1f
            ObjectAnimator.ofFloat(it, "scaleX", it.scaleX + factory).start()
            ObjectAnimator.ofFloat(it, "scaleY", it.scaleY + factory).start()
        }
    }

}