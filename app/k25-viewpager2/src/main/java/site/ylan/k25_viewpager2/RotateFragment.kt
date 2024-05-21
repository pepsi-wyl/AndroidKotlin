package site.ylan.k25_viewpager2

import android.animation.ObjectAnimator
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import site.ylan.k25_viewpager2.databinding.FragmentRotateBinding
import kotlin.random.Random

class RotateFragment : Fragment() {

    private lateinit var binding: FragmentRotateBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentRotateBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.ivRotate.setOnClickListener {
            ObjectAnimator.ofFloat(it, "rotation", it.rotation + 30f).start()
        }
    }

}