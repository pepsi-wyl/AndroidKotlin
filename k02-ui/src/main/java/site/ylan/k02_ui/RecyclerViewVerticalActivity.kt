package site.ylan.k02_ui

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import site.ylan.k02_ui.adapter.FruitRecyclerViewVerticalAdapter
import site.ylan.k02_ui.base.BaseActivity
import site.ylan.k02_ui.databinding.ActivityRecyclerViewVerticalBinding
import site.ylan.k02_ui.model.entity.fruitList
import site.ylan.k02_ui.model.entity.initFruits

class RecyclerViewVerticalActivity : BaseActivity<ActivityRecyclerViewVerticalBinding>() {

    override fun onCreated(savedInstanceState: Bundle?) {
        // 初始化水果数据
        initFruits()
        // 获取控件
        val recyclerView = binding.recyclerView
        // 自定义数据适配器
        val fruitAdapter = FruitRecyclerViewVerticalAdapter(fruitList)
        // 设置布局管理器 线性布局 纵向排列 默认
        recyclerView.layoutManager = LinearLayoutManager(this)
        // 设置适配器
        recyclerView.adapter = fruitAdapter
    }

}