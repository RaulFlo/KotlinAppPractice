package com.example.android.zoomrecyclerview

import android.app.ActionBar
import android.os.Build
import android.view.Gravity
import android.view.Gravity.CENTER
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.rv_item.*
import kotlinx.android.synthetic.main.rv_item.view.*


class RecyclerAdapter(
        private var image: List<Int>,
        private var title: List<String>,
        private var rating: List<Int>
) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {


    @RequiresApi(Build.VERSION_CODES.M)
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemImage: ImageView = itemView.findViewById(R.id.iv_image)
        val itemRating: RatingBar = itemView.findViewById(R.id.card_rating_bar)
        val itemTitle: TextView = itemView.findViewById(R.id.tv_destination)


        init {
            itemView.setOnClickListener() { v: View ->
                val position: Int = adapterPosition

                //using the R.id.tv_destination to anchor position of the popup
                val popupMenu = PopupMenu(itemView.context,itemView.findViewById(R.id.tv_destination),Gravity.CENTER_VERTICAL)
                popupMenu.inflate(R.menu.popup_menu)



                popupMenu.setOnMenuItemClickListener{
                    when (it.itemId){
                        R.id.nav_share -> {
                            Toast.makeText(itemView.context, "sharePressed", Toast.LENGTH_SHORT).show()
                            true
                        }
                        R.id.nav_message -> {
                            Toast.makeText(itemView.context, "MessagePressed", Toast.LENGTH_SHORT).show()
                            true
                        }
                        R.id.nav_flag -> {
                            Toast.makeText(itemView.context, "flagPressed", Toast.LENGTH_SHORT).show()
                            true
                        }
                        else -> true
                    }
                }


                itemView.setOnLongClickListener {
                    try {
                        val popup = PopupMenu::class.java.getDeclaredField("mPopup")
                        popup.isAccessible = true
                        val menu = popup.get(popupMenu)
                        menu.javaClass
                                .getDeclaredMethod("setForceShowIcon", Boolean::class.java)
                                .invoke(menu, true)

                    }catch (e: Exception){
                        e.printStackTrace()

                    }finally {
                        popupMenu.show()
                    }
                    true
                }




            }




        }
    }


    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.rv_item, parent, false)
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








