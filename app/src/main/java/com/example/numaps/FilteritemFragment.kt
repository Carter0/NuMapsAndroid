package com.example.numaps

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.numaps.dummy.FilterItem
import com.example.numaps.fragments.MyFilteritemRecyclerViewAdapter


/**
 * A fragment representing a list of Items.
 * Activities containing this fragment MUST implement the
 * [FilteritemFragment.OnListFragmentInteractionListener] interface.
 */
class FilteritemFragment : Fragment() {


    private var dataPasser: OnDataPass? = null


    //This initializes the view. So the UI basically.
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_filteritem_list, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = LinearLayoutManager(context)
                val filterItems = listOf("Food", "Subway").map { FilterItem(it) { passData(it) } }
                adapter = MyFilteritemRecyclerViewAdapter(filterItems)
            }
        }
        return view
    }



    override fun onAttach(context: Context) {
        super.onAttach(context)
        dataPasser = context as OnDataPass
    }

    fun passData(data: String) {
        dataPasser?.onDataPass(data)
    }


}


interface OnDataPass {
    fun onDataPass(data: String)
}
