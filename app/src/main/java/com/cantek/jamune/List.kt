package com.cantek.jamune

import android.app.Dialog
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cantek.jamune.adapter.CategoryAdapter
import com.cantek.jamune.adapter.ReceipeMainAdapter
import com.cantek.jamune.model.Receipe
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.fragment_list.*


class List(context: Context) : Fragment(R.layout.fragment_list) {

    private lateinit var dialogConn: Dialog

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        var allReceipe: MutableList<Receipe> = mutableListOf()
        val ref: DatabaseReference = FirebaseDatabase.getInstance("https://jamune-67b20-default-rtdb.firebaseio.com/").getReference("resep")

        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(data: DataSnapshot) {
                if (data.exists()) {
                    for (item in data.children) {

                        val kasiat: MutableList<String> = mutableListOf()
                        for (i in item.child("kasiat").children) {
                            kasiat.add(i.value.toString())
                        }

                        val bahan: MutableList<String> = mutableListOf()
                        for (i in item.child("bahan").children) {
                            bahan.add(i.value.toString())
                        }

                        allReceipe.add(Receipe(
                            key = item.key.toString(),
                            judul = item.child("judul").value.toString(),
                            bahan = bahan,
                            cara = item.child("cara").value.toString(),
                            deskripsi = item.child("deskripsi").value.toString(),
                            image = item.child("image").value.toString(),
                            kasiat = kasiat,
                            video = item.child("video").value.toString()
                        ))

//                        val res: String = item.child("judul").value as String
                    }
                }

                val adapter = context?.let { CategoryAdapter(it, allReceipe) }
                val layout: RecyclerView.LayoutManager = LinearLayoutManager(context)
                main_recycler.layoutManager = layout
                main_recycler.adapter = adapter


            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                println("Guagall")
                failedConn()
            }
        })
    }

    private fun failedConn() {
        dialogConn.setContentView(R.layout.cutom_dialog_notconnection)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            dialogConn.window!!.setBackgroundDrawable(context!!.getDrawable(R.drawable.round_white))
        }
        dialogConn.window!!.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        val dialogCancel: Button = dialogConn.findViewById(R.id.main_cancel)
        dialogCancel.setOnClickListener{
            dialogConn.dismiss()
        }
    }
}