package com.example.numaps

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.numaps.dummy.FilterContent


class MapActivity : AppCompatActivity(), FilteritemFragment.OnListFragmentInteractionListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation =  (ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE)
        setContentView(R.layout.activity_map)

        //Make the fragment.
        val filterFragment = FilteritemFragment()
    }


    override fun onListFragmentInteraction(item: FilterContent.FilterItem?) {
        Toast.makeText(this, "Filter item pressed!", Toast.LENGTH_SHORT).show()
    }
}
