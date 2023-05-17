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
    private lateinit var textViewApodo: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        textViewDetail = findViewById(R.id.textViewDetail)
        textViewApodo = findViewById(R.id.textViewApodo)
        imageView = findViewById(R.id.imageViewDetail)

        val bundle = intent.extras
        val nombre = bundle?.getString("name", "")
        val url = bundle?.getString("url") ?: ""
        val apodo = bundle?.getString("apodo", "")

        textViewDetail.text = nombre
        textViewApodo.text = apodo

        Glide.with(applicationContext)
            .load(url)
            .into(imageView)


    }
}