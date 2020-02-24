package com.hadi.viewpager2carousel

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_model.view.*

class ModelAdapter(
    val context: Context,
    val list: List<ModelData>

) : RecyclerView.Adapter<ModelAdapter.ModelViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModelViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_model, parent, false)
        return ModelViewHolder(view)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ModelViewHolder, position: Int) {

        Glide.with(context).load(list[position].image).into(holder.img)

        holder.name.text = list[position].name
        holder.date.text = list[position].date

    }

    class ModelViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val img = itemView.imgModel as ImageView
        val name = itemView.tvName as TextView
        val date = itemView.tvDate as TextView
    }
}