package site.ylan.k26_bottomnavigation

import android.animation.ObjectAnimator
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import site.ylan.k26_bottomnavigation.databinding.FragmentSecondBinding
import kotlin.random.Random

class SecondFragment : Fragment() {

    companion object {
        fun newInstance() = SecondFragment()
    }

    private lateinit var binding: FragmentSecondBinding
    private lateinit var viewModel: SecondViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[SecondViewModel::class.java]
        binding.imageView.apply {
            scaleX = viewModel.scaleFactor
            scaleY = viewModel.scaleFactor
            setOnClickListener {
                val factory = if (Random.nextBoolean()) 0.1f else -0.1f
                viewModel.scaleFactor += factory
                ObjectAnimator.ofFloat(it, "scaleX", viewModel.scaleFactor).start()
                ObjectAnimator.ofFloat(it, "scaleY", viewModel.scaleFactor).start()
            }
        }
    }

}