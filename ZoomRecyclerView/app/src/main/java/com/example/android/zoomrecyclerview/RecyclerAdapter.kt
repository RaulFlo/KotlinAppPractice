package com.example.android.zoomrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(
    private var image: List<Int>,
    private var title: List<String>,
    private var rating: List<Int>
    ) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val itemImage: ImageView = itemView.findViewById(R.id.iv_image)
        val itemRating: RatingBar = itemView.findViewById(R.id.card_rating_bar)
        val itemTitle: TextView = itemView.findViewById(R.id.tv_destination)

        init {
            itemView.setOnClickListener { v: View ->
                val position:Int = adapterPosition
                Toast.makeText(itemView.context,title[position], Toast.LENGTH_SHORT).show()
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.rv_item,parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        holder.itemImage.setImageResource(image[position])
        holder.itemTitle.text = title[position]
        holder.itemRating.rating = rating[position].toFloat()


    }

    override fun getItemCount(): Int {
        return title.size
    }
}