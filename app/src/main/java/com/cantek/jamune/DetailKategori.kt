package com.cantek.jamune

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cantek.jamune.adapter.CategoryAdapter
import com.cantek.jamune.adapter.ReceipeMainAdapter
import com.cantek.jamune.model.Receipe
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.fragment_list.*

class DetailKategori : AppCompatActivity() {

    companion object{
        const val EXTRA_DATA = ""
    }
    private lateinit var rvJamu : RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_kategori)


        rvJamu = findViewById(R.id.recycler)
        val get = intent.getStringExtra(EXTRA_DATA)?.toLowerCase()
        //supportActionBar?.title=get


        var CatRecipe: MutableList<Receipe> = mutableListOf()
        val ref: DatabaseReference = FirebaseDatabase.getInstance("https://jamune-67b20-default-rtdb.firebaseio.com/").getReference("resep")

        ref.addValueEventListener(object :ValueEventListener{
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
                        if (get in bahan || get in khasiat) {
                            CatRecipe.add(
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

                    rvJamu.layoutManager = LinearLayoutManager(this@DetailKategori)
                    val categoryAdapter = CategoryAdapter(this@DetailKategori,CatRecipe)
                    rvJamu.adapter = categoryAdapter

                        }
                    }

            override fun onCancelled(error: DatabaseError) {
                Log.w("error=","Error bund")
            }
        })

    }
}