package site.ylan.k26_bottomnavigation

import android.animation.ObjectAnimator
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import site.ylan.k26_bottomnavigation.databinding.FragmentThirdBinding
import kotlin.random.Random

class ThirdFragment : Fragment() {

    companion object {
        fun newInstance() = ThirdFragment()
    }

    private lateinit var binding: FragmentThirdBinding
    private lateinit var viewModel: ThirdViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentThirdBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[ThirdViewModel::class.java]
        binding.imageView.apply {
            translationX = viewModel.translationX
            setOnClickListener {
                viewModel.translationX += Random.nextInt(-100, 100)
                ObjectAnimator.ofFloat(it, "translationX", viewModel.translationX).start()
            }
        }
    }

}