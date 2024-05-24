package site.ylan.k12_materialdesign.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import site.ylan.k12_materialdesign.FruitActivity
import site.ylan.k12_materialdesign.R
import site.ylan.k12_materialdesign.databinding.FruitItemBinding
import site.ylan.k12_materialdesign.model.Fruit
import site.ylan.k12_materialdesign.model.FruitDate

class FruitAdapter(private val context: Context) :
    RecyclerView.Adapter<FruitAdapter.ViewHolder>() {

    private lateinit var fruitList: List<Fruit>

    @SuppressLint("NotifyDataSetChanged")
    fun setFruitList(fruitList: List<Fruit>) {
        this.fruitList = fruitList
        notifyDataSetChanged()
    }

    inner class ViewHolder(binding: FruitItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val fruitImage: ImageView = binding.fruitImage
        val fruitName: TextView = binding.fruitName
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewHolder =
            ViewHolder(FruitItemBinding.inflate(LayoutInflater.from(context), parent, false))

        viewHolder.itemView.setOnClickListener {
            val fruit = fruitList[viewHolder.bindingAdapterPosition]
            val bundle = Bundle().apply {
                putString(FruitActivity.FRUIT_NAME, fruit.name)
                putInt(FruitActivity.FRUIT_IMAGE_ID, fruit.imageId)
            }
            FruitActivity.startFruitActivity(context, bundle)
        }

        return viewHolder
    }

    override fun getItemCount(): Int = fruitList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        fruitList[position].let {
            holder.fruitName.text = it.name
            Glide.with(context)
                .load(it.imageId)
                .into(holder.fruitImage)
        }
    }

}