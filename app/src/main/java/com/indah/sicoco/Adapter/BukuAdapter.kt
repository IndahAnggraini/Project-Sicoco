//package com.indah.sicoco.Adapter
//
//import android.content.Context
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import com.indah.sicoco.R
//import com.indah.sicoco.model.BukuPanduanItem
//import kotlinx.android.synthetic.main.item_buku.view.*
//import kotlinx.android.synthetic.main.view_detail_coaching3.view.*
//
//class BukuAdapter (private val datalist : ArrayList<BukuPanduanItem>) :
//        RecyclerView.Adapter<BukuAdapter.BukuHolder>() {
//
//    private lateinit var context : Context
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BukuHolder {
//        context = parent.context
//        return BukuHolder(LayoutInflater.from(context).inflate(R.layout.item_buku
//                ,parent,false))
//    }
//
//    override fun getItemCount(): Int = datalist.size
//
//    override fun onBindViewHolder(holder: BukuHolder, position: Int) {
//        val data = datalist[position]
//        holder.init(data)
//
//        // alert dialog
////        holder.itemView.setOnClickListener{
////            listener?.onitemClick(holder.adapterPosition,data)
////        }
//
//    }
//
//    class BukuHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
//        private val pdf = itemView.pdf
//        private val link = itemView.link
//
//        fun init(data : BukuPanduanItem){
//            pdf.text = data.buku_panduan
//            link.text = data.link_video
//        }
//
//    }
//}