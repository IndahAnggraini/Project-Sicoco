package com.indah.sicoco.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.indah.sicoco.R
import com.indah.sicoco.model.JadwalModelResponseItem
import kotlinx.android.synthetic.main.item_utama.view.*

class JadwalAdapter (private val datalist : ArrayList<JadwalModelResponseItem>) :
        RecyclerView.Adapter<JadwalAdapter.JadwalHolder>(){

    //Alert Dialog
    interface OnItemClickListener{
        fun onitemClick(position: Int, data: JadwalModelResponseItem )
    }

    private var listener : OnItemClickListener? = null

    fun setOnItemClickListener(body :(Int,JadwalModelResponseItem) -> Unit){
        listener = object : OnItemClickListener {
            override fun onitemClick(position: Int, data: JadwalModelResponseItem) {
                body(position,data)
            }
        }
    }

    private lateinit var context : Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JadwalHolder {
       context = parent.context
        return JadwalHolder(LayoutInflater.from(context).inflate(R.layout.item_utama,parent,false))
    }

    override fun getItemCount(): Int = datalist.size

    override fun onBindViewHolder(holder: JadwalHolder, position: Int) {
        val data = datalist[position]
        holder.init(data)

        // alert dialog
        holder.itemView.setOnClickListener{
            listener?.onitemClick(holder.adapterPosition,data)
        }

    }

    class JadwalHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        private val judulmateri = itemView.judulmateri
        private val isitanggal = itemView.isitanggal
        private val isipukul = itemView.isipukul
        private val isitempat = itemView.isitempat
        private val isikuota = itemView.isikuota

        fun init(data : JadwalModelResponseItem){
            judulmateri.text = "Pelatihan ${data.nm_materi}"
            isitanggal.text = data.tanggal_mulai
            isipukul.text = data.pukul
            isitempat.text = data.tempat
            isikuota.text = data.jumlah_peserta
        }

    }

}