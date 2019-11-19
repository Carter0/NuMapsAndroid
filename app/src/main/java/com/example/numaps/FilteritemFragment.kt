package com.example.numaps

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.example.numaps.dummy.FilterItem
import com.example.numaps.fragments.MyFilteritemRecyclerViewAdapter
import kotlinx.android.synthetic.main.fragment_filteritem.view.*

/**
 * A fragment representing a list of Items.
 * Activities containing this fragment MUST implement the
 * [FilteritemFragment.OnListFragmentInteractionListener] interface.
 */
class FilteritemFragment : Fragment() {


    //This initializes the view. So the UI basically.
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_filteritem_list, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                val manager = LinearLayoutManager(context)
                manager.orientation = LinearLayoutManager.HORIZONTAL
                layoutManager = manager

                val filterItems = listOf("Food", "Parking", "Classes", "Subway").map {
                    //This is the lambda function I have made for the buttons.
                    FilterItem(it) {
                        Toast.makeText(requireContext(), "You clicked $it", Toast.LENGTH_LONG).show()
                    }
                }

                adapter = MyFilteritemRecyclerViewAdapter(filterItems)
            }
        }
        return view
    }

}
