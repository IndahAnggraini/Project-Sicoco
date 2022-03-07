package com.indah.sicoco.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.indah.sicoco.R
import com.indah.sicoco.model.JadwalModelResponseItem
import kotlinx.android.synthetic.main.item_daftar.view.*

class DaftarAdapter (private val datalist : ArrayList<JadwalModelResponseItem>) :
        RecyclerView.Adapter<DaftarAdapter.DaftarHolder>() {

    class DaftarHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val judulmateri = itemView.judulmateri2
        private val isitanggal = itemView.isitanggal2
        private val isipukul = itemView.isipukul2
        private val isitempat = itemView.isitempat2

        fun init(data: JadwalModelResponseItem) {
            judulmateri.text = "Pelatihan ${data.nm_materi}"
            isitanggal.text = data.tanggal_mulai
            isipukul.text = data.pukul
            isitempat.text = data.tempat
        }

        //Alert Dialog
        interface OnItemClickListener {
            fun onitemClick(position: Int, data: JadwalModelResponseItem)
        }

        private var listener: OnItemClickListener? = null

        fun setOnItemClickListener(body: (Int, JadwalModelResponseItem) -> Unit) {
            listener = object : OnItemClickListener {
                override fun onitemClick(position: Int, data: JadwalModelResponseItem) {
                    body(position, data)
                }
            }
        }
    }

    private lateinit var context : Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DaftarHolder {
        context = parent.context
        return DaftarHolder(LayoutInflater.from(context).inflate(R.layout.item_daftar, parent, false))
    }

    override fun getItemCount(): Int = datalist.size

    interface OnItemClickListener{
        fun onitemClick(position: Int, data: JadwalModelResponseItem )
    }

    private var listener : DaftarAdapter.OnItemClickListener? = null
    fun setOnItemClickListener(body :(Int,JadwalModelResponseItem) -> Unit){
        listener = object : DaftarAdapter.OnItemClickListener {
            override fun onitemClick(position: Int, data: JadwalModelResponseItem) {
                body(position,data)
            }
        }
    }

    override fun onBindViewHolder(holder: DaftarHolder, position: Int) {
        val data = datalist[position]
        holder.init(data)

        // alert dialog
        holder.itemView.setOnClickListener{
            listener?.onitemClick(holder.adapterPosition,data)
        }
    }
}