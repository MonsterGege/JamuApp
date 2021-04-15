package com.cantek.jamune

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import kotlinx.android.synthetic.main.fragment_category.*

class Category : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_category,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val jahe = view.findViewById<CardView>(R.id.jahe)
        val kunyit = view.findViewById<CardView>(R.id.kunyit)
        val kencur = view.findViewById<CardView>(R.id.kencur)
        val temulawak = view.findViewById<CardView>(R.id.temulawak)
        val masukangin = view.findViewById<TextView>(R.id.five)
        val pegal = view.findViewById<TextView>(R.id.six)
        val stamina = view.findViewById<TextView>(R.id.seven)
        val dayatahan = view.findViewById<TextView>(R.id.eight)
        jahe.setOnClickListener {
            val data = "jahe"
            val intent = Intent(requireContext(),DetailKategori::class.java)
            intent.putExtra(DetailKategori.EXTRA_DATA,data)
            startActivity(intent)
        }
        kunyit.setOnClickListener {
            val data = "kunyit"
            val intent = Intent(requireContext(),DetailKategori::class.java)
            intent.putExtra(DetailKategori.EXTRA_DATA,data)
            startActivity(intent)
        }
        kencur.setOnClickListener {
            val data = "kencur"
            val intent = Intent(requireContext(),DetailKategori::class.java)
            intent.putExtra(DetailKategori.EXTRA_DATA,data)
            startActivity(intent)
        }
        temulawak.setOnClickListener {
            val data = "Temulawak"
            val intent = Intent(requireContext(),DetailKategori::class.java)
            intent.putExtra(DetailKategori.EXTRA_DATA,data)
            startActivity(intent)
        }
        masukangin.setOnClickListener {
            val data = "Masuk angin"
            val intent = Intent(requireContext(),DetailKategori::class.java)
            intent.putExtra(DetailKategori.EXTRA_DATA,data)
            startActivity(intent)
        }
        pegal.setOnClickListener {
            val data = "Pegal-pegal"
            val intent = Intent(requireContext(),DetailKategori::class.java)
            intent.putExtra(DetailKategori.EXTRA_DATA,data)
            startActivity(intent)
        }
        stamina.setOnClickListener {
            val data = "Stamina"
            val intent = Intent(requireContext(),DetailKategori::class.java)
            intent.putExtra(DetailKategori.EXTRA_DATA,data)
            startActivity(intent)
        }
        dayatahan.setOnClickListener {
            val data = "Daya tahan tubuh"
            val intent = Intent(requireContext(),DetailKategori::class.java)
            intent.putExtra(DetailKategori.EXTRA_DATA,data)
            startActivity(intent)
        }





    }


}