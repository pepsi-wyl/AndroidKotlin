package site.ylan.k02_ui

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import site.ylan.k02_ui.adapter.FruitRecyclerViewHorizontalAdapter
import site.ylan.k02_ui.adapter.FruitRecyclerViewVerticalAdapter
import site.ylan.k02_ui.base.BaseActivity
import site.ylan.k02_ui.databinding.ActivityRecyclerViewVerticalBinding
import site.ylan.k02_ui.model.entity.fruitList
import site.ylan.k02_ui.model.entity.initFruits

class RecyclerViewHorizontalActivity : BaseActivity<ActivityRecyclerViewVerticalBinding>() {

    override fun onCreated(savedInstanceState: Bundle?) {
        // 初始化水果数据
        initFruits()
        // 获取控件
        val recyclerView = binding.recyclerView
        // 自定义数据适配器
        val fruitAdapter = FruitRecyclerViewHorizontalAdapter(fruitList)
        // 设置布局管理器 线性布局 横行排列
        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        recyclerView.layoutManager = linearLayoutManager
        // 设置适配器
        recyclerView.adapter = fruitAdapter
    }

}