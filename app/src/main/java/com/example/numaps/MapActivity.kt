package com.example.numaps

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button



class MapActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation =  (ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE)
        setContentView(R.layout.activity_map)

        val rugglesButton : Button = findViewById(R.id.rugglesButton)
        val shawarmaButton : Button = findViewById(R.id.shawarmaButton)
        val foodFilter = findViewById<Button>(R.id.foodFilter)

        var filterOn = false


        val descriptionList = listOf(getString(R.string.rugglesDescription), getString(R.string.shwaramaDescription))
        val ruggles = Location("Ruggles", "Ruggles", descriptionList[0])
        val shwarama = Location("Shwarama", "Shwarama", descriptionList[1])

        val intent = Intent(this, DataActivity::class.java)


        rugglesButton.setOnClickListener {
            intent.putExtra("Location", ruggles)
            startActivity(intent)
        }

        shawarmaButton.setOnClickListener {
            intent.putExtra("Location", shwarama)
            startActivity(intent)
        }

        foodFilter.setOnClickListener {
            if (filterOn) {
                shawarmaButton.isEnabled = false
                filterOn = false
            } else {
                shawarmaButton.isEnabled = true
                filterOn = true
            }
        }
    }
}
