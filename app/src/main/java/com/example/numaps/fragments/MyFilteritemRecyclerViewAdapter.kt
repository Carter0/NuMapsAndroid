package com.example.numaps.fragments

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.numaps.R


import com.example.numaps.FilteritemFragment.OnListFragmentInteractionListener
import com.example.numaps.dummy.FilterContent.FilterItem

import kotlinx.android.synthetic.main.fragment_filteritem.view.*

/**
 * [RecyclerView.Adapter] that can display a [FilterItem] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 * TODO: Replace the implementation with code for your data type.
 */
class MyFilteritemRecyclerViewAdapter(
    private val mValues: List<FilterItem>,
    private val mListener: OnListFragmentInteractionListener?
) : RecyclerView.Adapter<MyFilteritemRecyclerViewAdapter.ViewHolder>() {

    private val mOnClickListener: View.OnClickListener

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as FilterItem
            // Notify the active callbacks interface (the activity, if the fragment is attached to
            // one) that an item has been selected.
            mListener?.onListFragmentInteraction(item)
        }
    }

    //This is run whenever an item in the recyclerview needs to be "recreated".
    //Also run on start.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_filteritem, parent, false)
        return ViewHolder(view)
    }

    //Puts the contents of each filteritem in the viewholder.
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]
        holder.mContentView.text = item.filterName

        with(holder.mView) {
            tag = item
            setOnClickListener(mOnClickListener)
        }
    }

    //How many items are in this list.
    override fun getItemCount(): Int = mValues.size


    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mContentView: TextView = mView.filterItem

        override fun toString(): String {
            return super.toString() + " '" + mContentView.text + "'"
        }
    }
}
