package com.example.numaps.fragments

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.numaps.R


import com.example.numaps.dummy.FilterItem

import kotlinx.android.synthetic.main.fragment_filteritem.view.*

/**
 * [RecyclerView.Adapter] that can display a [FilterItem] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 */
class MyFilteritemRecyclerViewAdapter(_values: List<FilterItem>) : RecyclerView.Adapter<ViewHolder>() {

    var values = _values
        set(value) {
            notifyDataSetChanged()
            field = value
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
        val item = values[position]
        holder.bind(item)
    }

    //How many items are in this list.
    override fun getItemCount(): Int = values.size
}

class ViewHolder(mView: View) : RecyclerView.ViewHolder(mView) {
    private val mContentView: Button = mView.filterItem

    fun bind(filterItem: FilterItem) {
        mContentView.text = filterItem.filterName

        //call the lambda function.
        mContentView.setOnClickListener {
            filterItem.onClickListener.invoke()
        }
    }
}
