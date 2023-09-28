package com.apolisb42.launchmodes

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.PendingIntent.FLAG_UPDATE_CURRENT
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import com.apolisb42.launchmodes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnShowCenters.setOnClickListener {
            val city = binding.etCity.text.toString()
            val cIntent = Intent(baseContext, CentersActivity::class.java).apply {
                putExtra("city", city)
            }

            startActivity(cIntent)
        }

        binding.btnNotify.setOnClickListener {
            createNotification()
        }
    }

    private fun createNotification() {
        val nm = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        val cIntent = Intent(baseContext, CentersActivity::class.java).apply {
            putExtra("city", "New York")
        }
        val cAction = PendingIntent.getActivity(baseContext, 123, cIntent, FLAG_UPDATE_CURRENT)

        val notification = NotificationCompat.Builder(this, "Sample")
            .setContentTitle("Service centers in New York")
            .setContentText("Explore service centers in New York")
            .setContentIntent(cAction)
            .setSmallIcon(android.R.drawable.ic_dialog_alert)
            .setAutoCancel(true)
            .build()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel("Sample", "Centers", NotificationManager.IMPORTANCE_HIGH)
            nm.createNotificationChannel(channel)
        }

        nm.notify(123, notification)

    }
}