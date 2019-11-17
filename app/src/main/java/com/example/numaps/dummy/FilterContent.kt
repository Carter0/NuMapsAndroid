package com.example.numaps.dummy

import android.util.Log
import java.util.ArrayList
import java.util.HashMap

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 */
object FilterContent {

    /**
     * An array of sample (dummy) items.
     */
    val ITEMS: MutableList<FilterItem> = ArrayList()

    init {
        ITEMS.add(createFilterItem("bruh"))
        Log.d("YEET", "my info, init of FilterContent ran")
    }

    private val COUNT = 25

    private fun addItem(item: FilterItem) {
        ITEMS.add(item)
    }

    private fun createFilterItem(filterName: String): FilterItem {
        return FilterItem(filterName)
    }

    fun createFilterItems(filterNames: List<String>) {
        filterNames.map { createFilterItem(it) }
    }

    /**
     * A dummy item representing a piece of content.
     */
    data class FilterItem(val filterName: String) {
        override fun toString(): String = filterName
    }
}
