package com.cantek.jamune.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.cantek.jamune.DetailJamu
import com.cantek.jamune.R
import com.cantek.jamune.model.Notifikasi
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.listjamu.view.*
import kotlinx.android.synthetic.main.listnotif.view.*

class NotifikasiAdapter(context: Context, private val notif:List<Notifikasi>):
    RecyclerView.Adapter<NotifikasiAdapter.MyViewHolder>() {
    var konteks: Context
    init {
        konteks = context
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NotifikasiAdapter.MyViewHolder {
        return NotifikasiAdapter.MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.listnotif, parent, false)
        )
    }

    override fun getItemCount(): Int = notif.size

    override fun onBindViewHolder(holder: NotifikasiAdapter.MyViewHolder, position: Int) {
        holder.bindnotif(konteks, notif[position])
    }

    class MyViewHolder(view: View):RecyclerView.ViewHolder(view){
        private val judul = view.notiftitle
        private val konten = view.notifcontent
        private val click = view.click_notif
        private val trash = view.trash


        fun bindnotif(konteks: Context, notifs : Notifikasi){
            judul.text=notifs.judul
            konten.text= notifs.konten
            val myRef: DatabaseReference = FirebaseDatabase.getInstance("https://jamune-67b20-default-rtdb.firebaseio.com/").getReference("notif")

            click.setOnClickListener {
                val intent = Intent(konteks , DetailJamu::class.java)
                intent.putExtra("item-key", notifs.target)
                konteks.startActivity(intent)
            }

            trash.setOnClickListener {
                myRef.child(notifs.id).removeValue()
            }

        }
    }
}