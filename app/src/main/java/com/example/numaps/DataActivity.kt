package com.example.numaps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.content.Intent
import android.net.Uri
import android.util.Log


class DataActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data)

        Log.d("ONCREATE", "got into on create")


        val titleText : TextView = findViewById(R.id.titleText)
        val descriptionText : TextView = findViewById(R.id.dataDescription)
        val dataImage : ImageView = findViewById(R.id.dataImage)
        val googleButton = findViewById<Button>(R.id.googeMapsButton)


        val i = intent
        val locationObj = i.getParcelableExtra<Location>("Location")


        titleText.setText(locationObj.title)
        descriptionText.setText(locationObj.description)
        //dataImage.setImageResource(R.string.ruggles)


        googleButton.setOnClickListener {
            // TODO : location enable, replace latitude and longitude with actual
            val gmmIntentUri = Uri.parse("geo:latitude,longitude?q=" + locationObj.title)
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)
        }
    }



}
