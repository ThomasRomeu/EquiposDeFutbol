package com.example.clase5equipodefutbol

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: Adapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerViewClub)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = Adapter(applicationContext)
        recyclerView.adapter = adapter

        adapter.submitList(listadoEquipos())
        adapter.onItemClickListener = { equipo ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("name", equipo.name)
            intent.putExtra("url", equipo.url)
            startActivity(intent)

        }
    }

    private fun listadoEquipos(): MutableList<Equipo>? {

        return mutableListOf(
            Equipo(
                1,
                "River",
                4,
                tipoPais.ARGENTINA,
                "https://upload.wikimedia.org/wikipedia/commons/3/3f/Logo_River_Plate.png"
            ),Equipo(
                2,
                "PSG",
                10,
                tipoPais.FRANCIA,
                "https://upload.wikimedia.org/wikipedia/commons/3/33/PSG_FC_logo.jpg"
            ),
            Equipo(
                3,
                "Tottenham",
                0,
                tipoPais.INGLATERRA,
                "https://upload.wikimedia.org/wikipedia/commons/6/6d/Tottenham_Hotspur.png"
            ),
            Equipo(
                4,
                "Boca",
                35,
                tipoPais.ARGENTINA,
                "https://upload.wikimedia.org/wikipedia/commons/a/ad/Boca-Juniors.jpg"
            ),
            Equipo(
                5,
                "Liverpool",
                19,
                tipoPais.INGLATERRA,
                "https://logos-download.com/wp-content/uploads/2017/11/Liverpool_FC_Logo_1999.png"
            ),
            Equipo(
                6,
                "Bayern Munich",
                32,
                tipoPais.ALEMANIA,
                "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1f/Logo_FC_Bayern_M%C3%BCnchen_%282002%E2%80%932017%29.svg/600px-Logo_FC_Bayern_M%C3%BCnchen_%282002%E2%80%932017%29.svg.png"
            ),
            Equipo(
                7,
                "Napoli",
                3,
                tipoPais.ITALIA,
                "https://upload.wikimedia.org/wikipedia/commons/thumb/b/ba/SSC_Napoli.svg/446px-SSC_Napoli.svg.png"
            ),
            Equipo(
                8,
                "Real Madrid",
                35,
                tipoPais.ESPAÑA,
                "https://upload.wikimedia.org/wikipedia/commons/1/10/Escudo_real_madrid_1941b.png"
            ),

        )
    }
}