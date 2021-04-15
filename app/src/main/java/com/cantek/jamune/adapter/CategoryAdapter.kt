package com.cantek.jamune.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.cantek.jamune.R
import com.cantek.jamune.model.Receipe
import kotlinx.android.synthetic.main.listjamu.view.*

class CategoryAdapter(private val recipe: List<Receipe>): RecyclerView.Adapter<CategoryAdapter.MyViewHolder>() {

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var  img = view.item_image
        var  jdl = view.item_judul
        var  keterangan = view.item_keterangan
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.listjamu, parent, false)
        return MyViewHolder(view)


    }

    override fun getItemCount(): Int = recipe.size

    override fun onBindViewHolder(holder: CategoryAdapter.MyViewHolder, position: Int) {
        val jamuu = recipe[position]
        Glide.with(holder.itemView.context)
            .load(jamuu.image)
            .apply(RequestOptions().override(300,150))
            .into(holder.img)
        holder.jdl.text = jamuu.judul
        holder.keterangan.text = jamuu.deskripsi
    }
}