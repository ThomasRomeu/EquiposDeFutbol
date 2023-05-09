package com.example.clase5equipodefutbol

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {
    private lateinit var textViewDetail: TextView
    private lateinit var imageView: ImageView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        textViewDetail = findViewById(R.id.textViewDetail)
        imageView = findViewById(R.id.imageViewDetail)

        val bundle = intent.extras
        val nombre = bundle?.getString("name", "")
        val url = bundle?.getString("url") ?: ""

        textViewDetail.text = nombre
        Glide.with(applicationContext)
            .load(url)
            .into(imageView)


    }
}