package com.leonardo.aps.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.leonardo.aps.R
import com.leonardo.aps.model.CEP
import java.util.*

class AdapterCEP(private val listCEP: String, private val parent: Fragment,
) :
    RecyclerView.Adapter<AdapterCEP.CardViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CardViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_card, parent, false)

        return CardViewHolder(view)

    }

    override fun onBindViewHolder(holder: AdapterCEP.CardViewHolder, position: Int) {
        @Suppress("CAST_NEVER_SUCCEEDS")
        val pos = listCEP as List<CEP>

        holder.end.text = pos[0].cep
        holder.rua.text = pos[0].street
        holder.bairro.text = pos[0].neighborhood
        holder.cidade.text = pos[0].city
        holder.estado.text = pos[0].state

    }

    inner class CardViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var end : TextView  = view.findViewById(R.id.res_cep)
        var rua: TextView = view.findViewById(R.id.res_rua)
        var bairro: TextView = view.findViewById(R.id.res_bairro)
        var cidade: TextView = view.findViewById(R.id.res_cidade)
        var estado: TextView = view.findViewById(R.id.res_estado)
    }

    override fun getItemCount(): Int {
        return 0
    }


}
