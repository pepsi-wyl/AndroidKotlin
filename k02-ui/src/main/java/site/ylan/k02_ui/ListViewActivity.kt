package site.ylan.k02_ui

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import site.ylan.k02_ui.adapter.FruitListViewAdapter
import site.ylan.k02_ui.base.BaseActivity
import site.ylan.k02_ui.databinding.ActivityListViewBinding
import site.ylan.k02_ui.model.entity.fruitList
import site.ylan.k02_ui.model.entity.initFruits

class ListViewActivity : BaseActivity<ActivityListViewBinding>(), AdapterView.OnItemClickListener {

    // ListView控件
    private lateinit var listView: ListView

    // 数据适配器
    private lateinit var arrayAdapter: ArrayAdapter<String>
    private lateinit var fruitAdapter: FruitListViewAdapter

    override fun onCreated(savedInstanceState: Bundle?) {
        // 获取控件
        listView = binding.listView

//        // 数据适配器  Activity的实例、ListView子项布局的id、数据源
//        arrayAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data)
//        // 设置适配器
//        listView.adapter = arrayAdapter

        // 初始化水果数据
        initFruits()
        // 自定义数据适配器
        fruitAdapter = FruitListViewAdapter(this, R.layout.fruit_item_listview, fruitList)
        // 设置适配器
        listView.adapter = fruitAdapter

        // 注册点击事件
        listView.onItemClickListener = this
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        // position 判断点击的哪个子项
        val fruit = fruitList[position]
        // 弹窗
        Toast.makeText(this, fruit.name, Toast.LENGTH_SHORT).show()
    }
}