package com.example.android.kotlinrecyclerviewexample

import com.xwray.groupie.ExpandableGroup
import com.xwray.groupie.ExpandableItem
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_expandable_header.*

class ExpandableHeaderItem(private val title: String) : Item(), ExpandableItem {

    private lateinit var expandableGroup: ExpandableGroup

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.item_expandable_header_title.text = title
        viewHolder.item_expandable_header_icon.setImageResource(getRotatedIconResId())

        viewHolder.item_expandable_header_root.setOnClickListener {
            expandableGroup.onToggleExpanded()
            viewHolder.item_expandable_header_icon.setImageResource(getRotatedIconResId())
        }
    }

    override fun getLayout() = R.layout.item_expandable_header

    override fun setExpandableGroup(onToggleListener: ExpandableGroup) {
        expandableGroup = onToggleListener
    }

    private fun getRotatedIconResId() =
        if (expandableGroup.isExpanded)
            R.drawable.ic_baseline_keyboard_arrow_up_24
        else
            R.drawable.ic_baseline_keyboard_arrow_down_24
}