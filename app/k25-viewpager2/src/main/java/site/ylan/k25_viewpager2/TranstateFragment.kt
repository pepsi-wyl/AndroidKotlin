package site.ylan.k25_viewpager2

import android.animation.ObjectAnimator
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import site.ylan.k25_viewpager2.databinding.FragmentTranstateBinding
import kotlin.random.Random

class TranstateFragment : Fragment() {

    private lateinit var binding: FragmentTranstateBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTranstateBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.ivTranstate.setOnClickListener {
            ObjectAnimator.ofFloat(it, "translationX", it.translationX + Random.nextInt(-100, 100)).start()
        }
    }

}