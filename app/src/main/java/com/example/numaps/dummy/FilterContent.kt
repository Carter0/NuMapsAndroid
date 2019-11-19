package com.example.numaps.dummy

/**
 * A dummy item representing a piece of content.
 * The lambda on onClickListener appears to allow basically any void function to be sent as an argument.
 */
data class FilterItem(val filterName: String, val onClickListener: () -> Unit) {
    override fun toString(): String = filterName
}
