package com.cantek.jamune.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cantek.jamune.R
import com.cantek.jamune.model.Notifikasi
import kotlinx.android.synthetic.main.listnotif.view.*

class NotifikasiAdapter(context:Context, private val notif :List<Notifikasi>):
    RecyclerView.Adapter<NotifikasiAdapter.MyViewHolder>() {

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
        holder.bindnotif(notif[position])
    }

    class MyViewHolder(view: View):RecyclerView.ViewHolder(view){
        private val judul = view.notiftitle
        private val konten = view.notifcontent

        fun bindnotif(notifs : Notifikasi){
            judul.text=notifs.judul
            konten.text= notifs.konten
        }
    }
}