package com.cantek.jamune.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.cantek.jamune.R
import com.cantek.jamune.model.Receipe
import kotlinx.android.synthetic.main.listjamu.view.*

class ReceipeMainAdapter(private val recipe: List<Receipe>): RecyclerView.Adapter<ReceipeMainAdapter.MyViewHoleder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ReceipeMainAdapter.MyViewHoleder {
        return MyViewHoleder(LayoutInflater.from(parent.context).inflate(R.layout.listjamu,parent,false))
    }

    override fun getItemCount(): Int = recipe.size

    override fun onBindViewHolder(holder: ReceipeMainAdapter.MyViewHoleder, position: Int) {

    }

    class MyViewHoleder(view:View): RecyclerView.ViewHolder(view) {
        private  val img = view.img
        private val  jdl = view.jdl
        private val  keterangan = view.keterangan

        fun bindrecipe(recipes: Receipe){
            //image pake glide gk sih ???

            jdl.text = recipes.judul
            keterangan.text = recipes.deskripsi
        }
    }


}