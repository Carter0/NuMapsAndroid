package com.example.numaps

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.numaps.dummy.FilterContent
import com.example.numaps.dummy.FilterContent.FilterItem
import com.example.numaps.fragments.MyFilteritemRecyclerViewAdapter

/**
 * A fragment representing a list of Items.
 * Activities containing this fragment MUST implement the
 * [FilteritemFragment.OnListFragmentInteractionListener] interface.
 */
class FilteritemFragment : Fragment() {

    private var listener: OnListFragmentInteractionListener? = null

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
                adapter = MyFilteritemRecyclerViewAdapter(FilterContent.ITEMS, listener)
            }
        }
        return view
    }

    //When the fragment is first attached to the activity.
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnListFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnListFragmentInteractionListener")
        }
    }

    //When the fragment is detached from the activity.
    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson
     * [Communicating with Other Fragments](http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnListFragmentInteractionListener {
        fun onListFragmentInteraction(item: FilterItem?)
    }

    companion object {

        const val ARG_COLUMN_COUNT = "column-count"

        @JvmStatic
        fun newInstance(columnCount: Int) =
            FilteritemFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }
}
