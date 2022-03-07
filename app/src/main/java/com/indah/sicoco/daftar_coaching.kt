package com.indah.sicoco

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

import com.indah.sicoco.Adapter.JadwalAdapter
import com.indah.sicoco.model.BukuPanduanItem
import com.indah.sicoco.model.JadwalModelResponseItem
import com.indah.sicoco.viewModel.JadwalViewModel
import kotlinx.android.synthetic.main.daftar_coaching.*

import kotlinx.android.synthetic.main.view_detail_coaching3.*


class daftar_coaching : AppCompatActivity(){

    //viewModel utk menampilkan di kelas view_detail
    private lateinit var viewModel2 : JadwalViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.daftar_coaching)

        viewModel2 = ViewModelProvider(this).get(JadwalViewModel::class.java)


        //key "jadwal" di ambil dari kelas 'login_activity' dan 'dashboardactivity'
        // listjadwal2 adalah variabel baru
        val listJadwal2 = intent.getParcelableExtra<JadwalModelResponseItem>("jadwal")

        //key "dataview" baru
        val dataView = intent.getParcelableExtra<JadwalModelResponseItem>("dataview")

        //Buku
        val listBuku = intent.getParcelableExtra<BukuPanduanItem>("dataBuku")


        cardview.setOnClickListener{

            Log.d("as", "click: $dataView")

            // 'dataJadwal' diambil dari kelas 'dahsboardactivity' dan 'pertanyaan_activity'
            viewModel2.getDashboard().observe(this, Observer { dataJadwal ->
                viewModel2.getBuku().observe(this, Observer { databuku ->
                    val intent = Intent(this, view_detail::class.java)

                    // Pada intent kita menggunakan "intent.putExtra" dan "dataJawal"
                    // Karena hanya menampilkan yang diklik saja
                    intent.putExtra("dataJadwal", listJadwal2)
                    intent.putExtra("databuku",listBuku)
                    startActivity(intent)

                })

            })
        }


        //utk menampilkan data yg ditampung gunakan getParcalable
        // 'listJadwal' variabel dari kelas 'dashboardactivity'
        val listJadwal = intent.getParcelableExtra<JadwalModelResponseItem>("jadwal")

        //Tidak perlu menggunakan adapter, pada daftar_coaching.xml langsung masukkan bagian item_daftar
        //Tidak perlu pakai recycle
        if (listJadwal != null) {
            judulmateri2.text="Pelatihan ${listJadwal.nm_materi}"
            isitanggal2.text=listJadwal.tanggal_mulai
            isipukul2.text=listJadwal.pukul
            isitempat2.text=listJadwal.tempat
        }


    }
}