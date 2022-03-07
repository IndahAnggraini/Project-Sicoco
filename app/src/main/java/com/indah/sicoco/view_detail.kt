package com.indah.sicoco

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager

import com.indah.sicoco.model.BukuPanduanItem
import com.indah.sicoco.model.JadwalModelResponseItem
import kotlinx.android.synthetic.main.view_detail_coaching3.*

class view_detail: AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.view_detail_coaching3)

        //utk menampilkan buku_panduan dan link_materi
//        val listJadwal3 = intent.getParcelableArrayListExtra<BukuPanduanItem>("dataJadwal") ?:ArrayList()
//
//        if (listJadwal3 != null) {
//            pdf.text=listJadwal3.buku_panduan
//            link.text=listJadwal3.link_video
//        }

        //BUKU
        val listBuku = intent.getParcelableExtra<BukuPanduanItem>("dataBuku")
        if (listBuku != null) {

            pdf.text=listBuku.buku_panduan
            link.text=listBuku.link_video

        }



        //utk menampilkan data yg ditampung gunakan getParcalable, diambil dari variabel dikelas 'daftar_coaching'
        val listJadwal2 = intent.getParcelableExtra<JadwalModelResponseItem>("dataJadwal")


        //Tidak perlu menggunakan adapter, pada daftar_coaching.xml langsung masukkan bagian item_daftar
        //Tidak perlu pakai recycle
        if (listJadwal2 != null) {
            judulmateri3.text="Pelatihan ${listJadwal2.nm_materi}"
            isitanggal3.text=listJadwal2.tanggal_mulai
            isipukul3.text=listJadwal2.pukul
            isitempat3.text=listJadwal2.tempat
        }


    }
}
