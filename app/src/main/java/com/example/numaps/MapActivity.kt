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






        /*
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
        */
    }


    override fun onListFragmentInteraction(item: FilterContent.FilterItem?) {
        Toast.makeText(this, "Filter item pressed!", Toast.LENGTH_SHORT).show()
    }
}
