package site.ylan.k03_fragment.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import site.ylan.k03_fragment.MainActivity
import site.ylan.k03_fragment.R

class LeftFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // 利用getActivity方法获取Activity
        val mainActivity = activity as MainActivity

        return inflater.inflate(R.layout.left_fragment, container, false)
    }

}