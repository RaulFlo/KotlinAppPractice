package com.example.android.kotlinrecyclerviewexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val exampleList = generateDummyList(500)

        // call the recycler view using synthetic property
        recycler_view.adapter = ExampleAdapter(exampleList)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.setHasFixedSize(true)


    }




    //creates a list  with different drawables
    private fun generateDummyList(size: Int): List<ExampleItem>{
        val list = ArrayList<ExampleItem>()

        for(i in 0 until size){
            val drawable = when (i % 3){
                0 -> R.drawable.ic_android
                1 -> R.drawable.ic_directions
                else -> R.drawable.ic_person
            }
            val item = ExampleItem(drawable, "Item $i","Line 2")
            list += item
        }
        return list
    }
}
