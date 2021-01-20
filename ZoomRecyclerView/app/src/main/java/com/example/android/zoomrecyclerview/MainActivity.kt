package com.example.android.zoomrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.rv_item.*
import www.sanju.zoomrecyclerlayout.ZoomRecyclerLayout
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private var titleList = mutableListOf<String>()
    private var ratingList = mutableListOf<Int>()
    private var drawableList = mutableListOf<Int>()


    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //set to light mode
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        recyclerView = findViewById(R.id.rv_recycler)

        //add to the list
        addToList("Hawaii Beach",R.drawable.photo_one,3)
        addToList("Luxury Resort", R.drawable.photo_two, 5)
        addToList("The Cold Woods", R.drawable.photo_three, 4)

        setUpRecyclerView()


    }


    private fun addToList(title: String,image: Int, rating:Int){
        titleList.add(title)
        drawableList.add(image)
        ratingList.add(rating)

    }

    private fun setUpRecyclerView(){
        val linearLayoutManager =ZoomRecyclerLayout(this)
        linearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL

        val snapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(recyclerView)
        recyclerView.isNestedScrollingEnabled = false

        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = RecyclerAdapter(drawableList,titleList,ratingList)
    }
}