package com.apolisb42.launchmodes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.apolisb42.launchmodes.databinding.ActivityCentersBinding

class CentersActivity : AppCompatActivity() {
    lateinit var binding: ActivityCentersBinding

    val map = mutableMapOf<String, List<String>>().apply {
        put("New York", listOf("Center1", "Center2", "Center3"))
        put("Chicago", listOf("SC4", "SC5", "CS6"))
        put("Texas", listOf("Factory1", "Factory2", "Factory3"))
        put("California", listOf("Workshop1", "Workshop2", "Workshop3"))
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCentersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d("LaunchModes", "onCreate: CentersActivity")
        intent?.extras?.getString("city")?.let {
            val centers = map[it]

            if(centers!=null) {
                with(binding) {
                    tvSelectedCity.text = "Selected city: $it"
                    tvCenters.text = "Centers are: \n${centers.joinToString(separator = "\n")}"
                }
            } else {
                with(binding) {
                    tvSelectedCity.text = "Selected city: $it"
                    tvCenters.text = "No service centers found for selected city"
                }
            }
        }

        binding.btnContactUs.setOnClickListener {
            startActivity(Intent(baseContext, InfoActivity::class.java))
        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Log.d("LaunchModes", "onNewIntent: CentersActivity")
        intent?.extras?.getString("city")?.let {
            val centers = map[it]

            if(centers!=null) {
                with(binding) {
                    tvSelectedCity.text = "Selected city: $it"
                    tvCenters.text = "Centers are: \n${centers.joinToString(separator = "\n")}"
                }
            } else {
                with(binding) {
                    tvSelectedCity.text = "Selected city: $it"
                    tvCenters.text = "No service centers found for selected city"
                }
            }
        }
    }
}