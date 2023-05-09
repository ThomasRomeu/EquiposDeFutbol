package com.example.clase5equipodefutbol

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class Adapter (val context: Context) : ListAdapter<Equipo, Adapter.ViewHolder>(DiffCallBack) {

    lateinit var onItemClickListener: (Equipo) -> Unit

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private val name : TextView = view.findViewById(R.id.textViewClub)
        private val champ : TextView = view.findViewById(R.id.textViewTotalCamp)
        private val logo: ImageView = view.findViewById(R.id.imageViewEscudo)
        private val imagenPais: ImageView = view.findViewById(R.id.imageViewPais)


        fun bind (equipo: Equipo) {
            name.text = equipo.name
            champ.text = equipo.campeonatos.toString() + " " + "Ligas"

            val image = when(equipo.pais){
                tipoPais.ARGENTINA -> R.drawable.argentina
                tipoPais.ALEMANIA -> R.drawable.alemania
                tipoPais.BRASIL -> R.drawable.brasil
                tipoPais.ESPAÑA -> R.drawable.espana
                tipoPais.FRANCIA -> R.drawable.francia
                tipoPais.INGLATERRA -> R.drawable.inglaterra
                tipoPais.ITALIA -> R.drawable.italia
            }

            imagenPais.setImageResource(image)

            Glide.with(context)
                .load(equipo.url)
                .into(logo)

            view.setOnClickListener {
                onItemClickListener(equipo)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {
        val view: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.itemlist, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
        val equipo = getItem(position)
        holder.bind(equipo)
    }

    companion object DiffCallBack : DiffUtil.ItemCallback<Equipo>() {
        override fun areItemsTheSame(oldItem: Equipo, newItem: Equipo): Boolean {
            return  oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Equipo, newItem: Equipo): Boolean {
            return oldItem == newItem
        }
    }
}