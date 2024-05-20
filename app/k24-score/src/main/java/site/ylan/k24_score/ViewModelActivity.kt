package site.ylan.k24_score

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import site.ylan.k24_score.databinding.ActivityViewModelBinding

class ViewModelActivity : AppCompatActivity() {

    private val binding: ActivityViewModelBinding by lazy {
        ActivityViewModelBinding.inflate(layoutInflater)
    }

    private lateinit var viewModel: NumberViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.textView.text = "0"

        // ViewModel
        viewModel = ViewModelProvider(this)[NumberViewModel::class.java]

        viewModel.number.observe(this) {
            binding.textView.text = it.toString()
        }

        binding.button1.setOnClickListener {
            viewModel.modifyNumber(1)
        }
        binding.button2.setOnClickListener {
            viewModel.modifyNumber(-1)
        }
    }
}