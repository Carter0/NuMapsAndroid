package com.example.numaps.dummy

import android.view.View
import java.util.ArrayList

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 */
//object FilterContent {
//
//    /**
//     * An array of sample (dummy) items.
//     */
//    val ITEMS: MutableList<FilterItem> = ArrayList()
//
//    private val COUNT = 25
//
//    init {
//        //Pass in the data to the filterlist.
//        val filterStrings = listOf("Food", "Parking", "Classes", "Subway")
//        createFilterItems(filterStrings).forEach { addItem(it) }
//    }
//
//    private fun addItem(item: FilterItem) {
//        ITEMS.add(item)
//    }
//
//    private fun createFilterItem(filterName: String): FilterItem {
//        return FilterItem(filterName)
//    }
//
//    private fun createFilterItems(filterNames: List<String>) : List<FilterItem> {
//        return filterNames.map { createFilterItem(it) }
//    }
//
//}

/**
 * A dummy item representing a piece of content.
 */
data class FilterItem(val filterName: String, val onClickListener: () -> Unit) {
    override fun toString(): String = filterName
}
