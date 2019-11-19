package com.example.numaps

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MapActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation =  (ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE)
        setContentView(R.layout.activity_map)

        val fragmentManager = supportFragmentManager
        val filterFragment = FilteritemFragment()



        var fragmentState = false
        val filterShowButton = findViewById<Button>(R.id.showFiltersButton)
        filterShowButton.setOnClickListener {
            if (!fragmentState) {
                val fragmentTransaction = fragmentManager.beginTransaction()
                fragmentTransaction.add(R.id.mapContainer, filterFragment)
                fragmentState = true
                fragmentTransaction.commit()
            }
        }

        val filterHideButton = findViewById<Button>(R.id.hideFilters)
        filterHideButton.setOnClickListener {
            if (fragmentState) {
                val fragmentTransaction2 = fragmentManager.beginTransaction()
                fragmentTransaction2.remove(filterFragment)
                fragmentState = false
                fragmentTransaction2.commit()
            }
        }

    }
}
