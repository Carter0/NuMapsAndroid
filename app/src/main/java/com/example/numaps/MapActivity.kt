package com.example.numaps

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.core.view.isVisible




class MapActivity : AppCompatActivity(), OnDataPass {

    override fun onDataPass(data: String) {
        Log.d("DATA", data)
        if (data == "Food") {
            if (foodVisible) {
                shawarmaButton.isVisible = false
                foodVisible = false
            } else {
                shawarmaButton.isVisible = true
                foodVisible = true
            }
        }

        if (data == "Subway") {
            if (rugglesVisible) {
                rugglesButton.isVisible = false
                rugglesVisible = false
            } else {
                rugglesButton.isVisible = true
                rugglesVisible = true
            }
        }
    }

    private var foodVisible = true
    private var rugglesVisible = true

    private lateinit var rugglesButton : Button
    private lateinit var shawarmaButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation =  (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        setContentView(R.layout.activity_map)

        rugglesButton = findViewById(R.id.rugglesButton)
        shawarmaButton = findViewById(R.id.shawarmaButton)

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

        val intent = Intent(this, DataActivity::class.java)

        val descriptionList = listOf(getString(R.string.rugglesDescription), getString(R.string.shwaramaDescription))
        val ruggles = Location("Ruggles", "Ruggles", descriptionList[0], Type.TRANSPORTATION)
        val shwarama = Location("Shwarama", "Shwarama", descriptionList[1], Type.FOOD)

        rugglesButton.setOnClickListener {
            intent.putExtra("Location", ruggles)
            startActivity(intent)
        }

        shawarmaButton.setOnClickListener {
            intent.putExtra("Location", shwarama)
            startActivity(intent)
        }
    }
}
