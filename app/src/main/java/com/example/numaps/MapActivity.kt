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

        rugglesButton.setOnClickListener {
            val intent = Intent(this, RugglesActivity::class.java)
            startActivity(intent)
        }
    }
}
