package com.cantek.jamune.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cantek.jamune.R
import com.cantek.jamune.model.Receipe
import kotlinx.android.synthetic.main.listjamu.view.*

class CategoryAdapter(context: Context,private val recipe: List<Receipe>): RecyclerView.Adapter<CategoryAdapter.MyViewHolder>() {
    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val  img = view.item_image
        private val  jdl = view.item_judul
        private val  keterangan = view.item_keterangan
        fun bindrecipe(recipes: Receipe){
            // Pakai Image Slider
            jdl.text = recipes.judul
            keterangan.text = recipes.deskripsi
        }
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoryAdapter.MyViewHolder {
        return CategoryAdapter.MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.listjamu, parent, false)
        )

    }

    override fun getItemCount(): Int = recipe.size

    override fun onBindViewHolder(holder: CategoryAdapter.MyViewHolder, position: Int) {
        holder.bindrecipe(recipe[position])
    }
}