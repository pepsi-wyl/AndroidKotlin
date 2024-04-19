package site.ylan.k03_fragment.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import site.ylan.k03_fragment.Activity.NewsActivity
import site.ylan.k03_fragment.Activity.NewsContentActivity
import site.ylan.k03_fragment.R
import site.ylan.k03_fragment.base.BaseFragment
import site.ylan.k03_fragment.databinding.NewsTitleFragBinding
import site.ylan.k03_fragment.model.entity.News

class NewsTitleFragment : BaseFragment<NewsTitleFragBinding>() {

    // 双页 默认false
    private var isTwoPane = false

    // 标题列表
    private lateinit var newsTitleRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        // 标题列表
        newsTitleRecyclerView = binding.newsTitleRecyclerView
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // 数据
        val news = News.getNews()
        // 是否双页
        isTwoPane = (activity?.findViewById<View>(R.id.newsContentLayout) as FrameLayout? != null)
        // 布局管理器
        newsTitleRecyclerView.layoutManager = LinearLayoutManager(activity)
        // 适配器
        newsTitleRecyclerView.adapter = NewsAdapter(news)

        // 如果是双页模式，则刷新NewsContentFragment中的内容为列表一
        if (isTwoPane){
            val fragmentManager = (activity as NewsActivity).supportFragmentManager
            val fragment = fragmentManager.findFragmentById(R.id.newsContentFrag) as NewsContentFragment
            fragment.refresh(news[0].title, news[0].context)
        }
    }

    inner class NewsAdapter(private val newsList: List<News>) :
        RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val newsTitle: TextView = view.findViewById(R.id.newsTitle)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.news_item, parent, false)
            val holder = ViewHolder(view)

            holder.itemView.setOnClickListener {
                val news = newsList[holder.adapterPosition]

                if (isTwoPane) {
                    // 如果是双页模式，则刷新NewsContentFragment中的内容
                    val fragmentManager = (activity as NewsActivity).supportFragmentManager
                    val fragment = fragmentManager.findFragmentById(R.id.newsContentFrag) as NewsContentFragment
                    fragment.refresh(news.title, news.context)
                } else {
                    // 如果是单页模式，则直接启动NewsContentActivity
                    NewsContentActivity.actionStart(parent.context, news.title, news.context)
                }
            }
            return holder
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.newsTitle.text = newsList[position].title
        }

        override fun getItemCount() = newsList.size
    }

}