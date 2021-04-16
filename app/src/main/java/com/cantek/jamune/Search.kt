package com.cantek.jamune

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cantek.jamune.adapter.CategoryAdapter
import com.cantek.jamune.model.Receipe
import com.google.firebase.database.*

class Search : AppCompatActivity() {

    private lateinit var rvSearch : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        rvSearch = findViewById(R.id.recyclersearch)
        val queryy = intent.getStringExtra("key-query")
        val hasil : TextView = findViewById(R.id.hasil)
        val empty : TextView = findViewById(R.id.tidakada)
        empty.text = ""
        hasil.text = queryy
        val query = queryy?.toLowerCase()

        val SearchRecipe: MutableList<Receipe> = mutableListOf()
        val ref: DatabaseReference = FirebaseDatabase.getInstance("https://jamune-67b20-default-rtdb.firebaseio.com/").getReference("resep")

        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(data: DataSnapshot) {
                if (data.exists()){
                    for (item in data.children){
                        val khasiat: MutableList<String> = mutableListOf()
                        for (i in item.child("kasiat").children){
                            khasiat.add(i.value.toString().toLowerCase())
                        }
                        val bahan: MutableList<String> = mutableListOf()
                        for (i in item.child("bahan").children) {
                            bahan.add(i.value.toString().toLowerCase())
                        }
                        if (query in bahan || query in khasiat || query == item.child("judul").value.toString().toLowerCase() ) {
                            SearchRecipe.add(
                                Receipe(
                                    key = item.key.toString(),
                                    judul = item.child("judul").value.toString(),
                                    bahan = bahan,
                                    cara = item.child("cara").value.toString(),
                                    deskripsi = item.child("deskripsi").value.toString(),
                                    image = item.child("image").value.toString(),
                                    kasiat = khasiat,
                                    video = item.child("video").value.toString()
                                )
                            )
                        }

                    }

                    rvSearch.layoutManager = LinearLayoutManager(this@Search)
                    val categoryAdapter = CategoryAdapter(this@Search,SearchRecipe)
                    rvSearch.adapter = categoryAdapter

                }

            }

            override fun onCancelled(error: DatabaseError) {
                Log.w("error=","Error bund")
            }
        })

    }
}