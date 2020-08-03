package com.example.android.kotlinrecyclerviewexample

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xwray.groupie.ExpandableGroup
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Section
import kotlinx.android.synthetic.main.activity_groupie_recycler_view.*
import java.util.*

class GroupieRecyclerViewActivity : AppCompatActivity() {


    private val excitingSection = Section()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_groupie_recycler_view)


        val boringFancyItems =generateFancyItems(6)
        val excitingFancyItems = generateFancyItems(12)

        val groupAdapter = GroupAdapter<GroupieViewHolder>().apply {
            spanCount = 3
        }

        groupie_recycler_view.apply {
            layoutManager = GridLayoutManager(this@GroupieRecyclerViewActivity, groupAdapter.spanCount).apply {
                spanSizeLookup = groupAdapter.spanSizeLookup
            }
            adapter = groupAdapter
        }

        ExpandableGroup(ExpandableHeaderItem("Boring Group"), true).apply {
            add(Section(boringFancyItems))
            groupAdapter.add(this)
        }

        ExpandableGroup(ExpandableHeaderItem("Exciting Group"), false).apply {
            //kept ref up top called excitingSection so we can shuffle
            excitingSection.addAll(excitingFancyItems)
            add(excitingSection)
            groupAdapter.add(this)
        }



    }

    private fun generateFancyItems(count: Int): MutableList<FancyItem>{
        val rnd = Random()
        return MutableList(count){
            val color = Color.argb(255,rnd.nextInt(256),rnd.nextInt(256),
                rnd.nextInt(256))
            FancyItem(color,rnd.nextInt(100))
        }

    }
}