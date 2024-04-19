package site.ylan.k03_fragment.Activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import site.ylan.k03_fragment.R
import site.ylan.k03_fragment.base.BaseActivity
import site.ylan.k03_fragment.databinding.ActivityNewsContentBinding
import site.ylan.k03_fragment.fragment.NewsContentFragment

class NewsContentActivity : BaseActivity<ActivityNewsContentBinding>() {

    companion object {
        fun actionStart(context: Context, title: String, content: String) {
            val intent = Intent(context, NewsContentActivity::class.java).apply {
                putExtra("news_title", title)
                putExtra("news_content", content)
            }
            context.startActivity(intent)
        }
    }

    override fun onCreated(savedInstanceState: Bundle?) {
        // 获取传入的新闻标题和新闻内容
        val title = intent.getStringExtra("news_title")
        val content = intent.getStringExtra("news_content")

        if (title != null && content != null) {
            val fragmentManager = supportFragmentManager
            val fragment = fragmentManager.findFragmentById(R.id.newsContentFrag) as NewsContentFragment
            // 刷新NewsContentFragment界面
            fragment.refresh(title, content)
        }
    }

}