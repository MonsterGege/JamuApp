package com.cantek.jamune

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import com.cantek.jamune.model.Receipe
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_detail_jamu.*

class DetailJamu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_jamu)

        val key = intent.getStringExtra("item-key")

        var allReceipe: MutableList<Receipe> = mutableListOf()
        val ref: DatabaseReference = FirebaseDatabase.getInstance("https://jamune-67b20-default-rtdb.firebaseio.com/").getReference("resep")

        ref.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

            override fun onDataChange(data: DataSnapshot) {
                if (data.exists()) {
                    for (item in data.children) {

                        if (item.key.equals(key)) {
                            val kasiat: MutableList<String> = mutableListOf()
                            for (i in item.child("kasiat").children) {
                                kasiat.add(i.value.toString())
                            }

                            val bahan: MutableList<String> = mutableListOf()
                            for (i in item.child("bahan").children) {
                                bahan.add(i.value.toString())
                            }
                        val jdl: String = item.child("judul").value as String
                        val keterangan: String = item.child("deskripsi").value as String
                        val cara: String = item.child("cara").value.toString()
                        val khasiat = kasiat.joinToString(separator = ",")
                        val bahans = bahan.joinToString(separator = ",")

                        val vid: String = item.child("video").value as String
                            detail_judul.setText(jdl)
                            detail_keterangan.setText(keterangan)
                            detail_khasiat.setText(khasiat)
                            detail_bahan.setText(bahans)
                            detail_cara.setText(cara)
                            //Video Belom bisa
                            detail_video.setVideoPath("https://www.youtube.com/watch?v="+vid)
                           val mediaController = MediaController(this@DetailJamu)
                            mediaController.setAnchorView(detail_video)
                            detail_video.setMediaController(mediaController)

                            detail_video.setOnCompletionListener { mediaPlayer ->
                                mediaPlayer.isLooping = true
                            }
                            detail_video.start()

                        }
                    }
                }


            }
        })
    }
}