package com.example.numaps

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.view.isVisible

class MapActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation =  (ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE)
        setContentView(R.layout.activity_map)

        val fragmentManager = supportFragmentManager
        val filterFragment = FilteritemFragment()
        val filterHideButton = findViewById<Button>(R.id.hideFilters)
        filterHideButton.isVisible = false

        var fragmentState = false
        val filterShowButton = findViewById<Button>(R.id.showFiltersButton)
        filterShowButton.setOnClickListener {
            if (!fragmentState) {
                val fragmentTransaction = fragmentManager.beginTransaction()
                fragmentTransaction.add(R.id.mapContainer, filterFragment)
                fragmentState = true
                fragmentTransaction.commit()
                filterShowButton.isVisible = false
                filterHideButton.isVisible = true
            }
        }

        filterHideButton.setOnClickListener {
            if (fragmentState) {
                val fragmentTransaction2 = fragmentManager.beginTransaction()
                fragmentTransaction2.remove(filterFragment)
                fragmentState = false
                fragmentTransaction2.commit()
                filterShowButton.isVisible = true
                filterHideButton.isVisible = false
            }
        }

    }
}
