package site.ylan.k26_bottomnavigation

import android.animation.ObjectAnimator
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import site.ylan.k26_bottomnavigation.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    companion object {
        fun newInstance() = FirstFragment()
    }

    private lateinit var binding: FragmentFirstBinding
    private lateinit var viewModel: FirstViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[FirstViewModel::class.java]
        binding.imageView.apply {
            rotation = viewModel.rotationPosition
            setOnClickListener {
                viewModel.rotationPosition += 100
                ObjectAnimator.ofFloat(it, "rotation", viewModel.rotationPosition).start()
            }
        }
    }

}