package site.ylan.k02_ui

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import site.ylan.k02_ui.adapter.FruitRecyclerViewStaggeredGridAdapter
import site.ylan.k02_ui.adapter.FruitRecyclerViewVerticalAdapter
import site.ylan.k02_ui.base.BaseActivity
import site.ylan.k02_ui.databinding.ActivityRecyclerViewVerticalBinding
import site.ylan.k02_ui.model.entity.fruitList
import site.ylan.k02_ui.model.entity.initFruits
import site.ylan.k02_ui.model.entity.initFruitsWithRandomLengthString

class RecyclerViewStaggeredGridActivity : BaseActivity<ActivityRecyclerViewVerticalBinding>() {

    override fun onCreated(savedInstanceState: Bundle?) {
        // 初始化水果数据
        initFruitsWithRandomLengthString()
        // 获取控件
        val recyclerView = binding.recyclerView
        // 自定义数据适配器
        val fruitAdapter = FruitRecyclerViewStaggeredGridAdapter(fruitList)
        // 设置瀑布布局 列数 排列方向
        val layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.layoutManager = layoutManager
        // 设置适配器
        recyclerView.adapter = fruitAdapter
    }

}