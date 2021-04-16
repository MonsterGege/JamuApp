package com.cantek.jamune

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cantek.jamune.adapter.NotifikasiAdapter
import com.cantek.jamune.model.Notifikasi
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_notifications.*


class Notifications : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notifications)

        val myRef: DatabaseReference = FirebaseDatabase.getInstance("https://jamune-67b20-default-rtdb.firebaseio.com/").getReference("notif")

        findViewById<ImageView>(R.id.notif_back).setOnClickListener {
            onBackPressed()
        }
        findViewById<LinearLayout>(R.id.flush_data).setOnClickListener {
            myRef.removeValue()
        }

        var dataBefore = 999

        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(data: DataSnapshot) {
                var allNotif: MutableList<Notifikasi> = mutableListOf()
                if (data.exists()) {
                    for (item in data.children) {
                        allNotif.add(
                            Notifikasi(
                                id = item.key.toString(),
                                judul = item.child("judul").value.toString(),
                                konten = item.child("deskripsi").value.toString(),
                                target = item.child("target").value.toString())
                        )
                    }
                }

                if (dataBefore < allNotif.size) {
                    sendNotification(allNotif.last().judul, allNotif.last().konten)
                }

                dataBefore = allNotif.size

                val adapter = NotifikasiAdapter(this@Notifications, allNotif)
                val viewLayout: RecyclerView.LayoutManager = LinearLayoutManager(this@Notifications)
                recycler_notif.layoutManager = viewLayout
                recycler_notif.adapter = adapter


            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
            }
        })

    }


    private fun sendNotification(title: String, desc: String) {
        val intent = Intent(this, Notifications::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val pendingIntent: PendingIntent = PendingIntent.getActivity(this, 0, intent, 0)
        var builder = NotificationCompat.Builder(this, "new")
            .setSmallIcon(R.drawable.logo)
            .setContentTitle(title)
            .setContentText(desc)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pendingIntent)
        with(NotificationManagerCompat.from(this)) {
            notify(121, builder.build())
        }
    }
}