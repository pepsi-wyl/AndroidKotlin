package site.ylan.k02_ui.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import site.ylan.k02_ui.R
import site.ylan.k02_ui.model.entity.Fruit

class FruitListViewAdapter(activity: Activity, private val resourceId: Int, data: List<Fruit>) :
    ArrayAdapter<Fruit>(activity, resourceId, data) {

    // ViewHolder内部类
    inner class ViewHolder(val fruitImage: ImageView, val fruitName: TextView)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val view:View
        val viewHolder:ViewHolder

        if (convertView == null){
            // 加载布局
            view = LayoutInflater.from(context).inflate(resourceId,parent,false)

            // 获取控件并设置进ViewHolder中
            viewHolder = ViewHolder(view.findViewById<ImageView>(R.id.fruitImage), view.findViewById<TextView>(R.id.fruitName))

            // 打包viewHolder
            view.tag = viewHolder

        } else{
            view = convertView
            // 取出viewHolder
            viewHolder = view.tag as ViewHolder
        }

        // 获取当前项Fruit实例
        val fruit = getItem(position)

        // 设置控件数据
        fruit?.apply {
            viewHolder.fruitImage.setImageResource(imageId)
            viewHolder.fruitName.text = name
        }

        return view
    }

}