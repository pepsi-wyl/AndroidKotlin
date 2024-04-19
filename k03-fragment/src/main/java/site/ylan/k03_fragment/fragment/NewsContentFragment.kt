package site.ylan.k03_fragment.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import site.ylan.k03_fragment.base.BaseFragment
import site.ylan.k03_fragment.databinding.NewsContentFragBinding

class NewsContentFragment : BaseFragment<NewsContentFragBinding>() {

    private lateinit var contentLayout: LinearLayout
    private lateinit var newsTitle: TextView
    private lateinit var newsContent: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = super.onCreateView(inflater, container, savedInstanceState)

        contentLayout = binding.contentLayout
        newsTitle = binding.newsTitle
        newsContent = binding.newsContent

        return view
    }


    fun refresh(title: String, context: String) {
        // 新闻内容布局设置可见
        contentLayout.visibility = View.VISIBLE
        // 刷新标题
        newsTitle.text = title
        // 刷新内容
        newsContent.text = context
    }
}