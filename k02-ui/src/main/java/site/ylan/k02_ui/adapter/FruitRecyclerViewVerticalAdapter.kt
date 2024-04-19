package site.ylan.k02_ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import site.ylan.k02_ui.R
import site.ylan.k02_ui.model.entity.Fruit

// 继承RecyclerView.Adapter 泛型FruitRecyclerViewAdapter.ViewHolder
class FruitRecyclerViewVerticalAdapter(private val fruitList: List<Fruit>) :
    RecyclerView.Adapter<FruitRecyclerViewVerticalAdapter.ViewHolder>() {

    // 内部类ViewHolder，继承自 RecyclerView.ViewHolder
    // View参数为RecyclerView子项的最外层布局
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val fruitImage: ImageView = view.findViewById(R.id.fruitImage)
        val fruitName: TextView = view.findViewById(R.id.fruitName)
    }

    // 创建ViewHolder实例
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // 加载fruit_item布局 创建一个ViewHolder实例，并把加载出来的布局传入构造函数中 将ViewHolder的实例返回
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fruit_item_vertical, parent, false)
        return ViewHolder(view)
    }

    // 告诉RecyclerView一共有多少子项
    override fun getItemCount(): Int = fruitList.size

    // 对RecyclerView子项的数据进行赋值
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // 获取当前项Fruit实例
        val fruit = fruitList[position]
        // 设置控件数据
        holder.apply {
            fruitImage.setImageResource(fruit.imageId)
            fruitName.text = fruit.name
        }
    }
}