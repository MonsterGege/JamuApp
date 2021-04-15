package com.cantek.jamune.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.cantek.jamune.DetailJamu
import com.cantek.jamune.R
import com.cantek.jamune.model.Receipe
import kotlinx.android.synthetic.main.listjamu.view.*

class ReceipeMainAdapter(context: Context, private val recipe: List<Receipe>): RecyclerView.Adapter<ReceipeMainAdapter.MyViewHoleder>() {
    var konteks: Context
    init {
        konteks = context
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ReceipeMainAdapter.MyViewHoleder {
        return MyViewHoleder(LayoutInflater.from(parent.context).inflate(R.layout.listjamu,parent,false))

    }

    override fun getItemCount(): Int = recipe.size

    override fun onBindViewHolder(holder: ReceipeMainAdapter.MyViewHoleder, position: Int) {
        holder.bindrecipe(konteks ,recipe[position])
    }

    class MyViewHoleder(view:View): RecyclerView.ViewHolder(view) {
        private  val img = view.item_image
        private val  jdl = view.item_judul
        private val  keterangan = view.item_keterangan
        private val click = view.click


        fun bindrecipe(contex: Context, recipes: Receipe){

            Glide.with(contex).load(recipes.image).into(img)
            jdl.text = recipes.judul
            keterangan.text = recipes.deskripsi
            click.setOnClickListener(View.OnClickListener {
                val intent = Intent( contex, DetailJamu::class.java)
                intent.putExtra("item-key", recipes.key)
                contex.startActivity(intent)
            })

        }
    }


}