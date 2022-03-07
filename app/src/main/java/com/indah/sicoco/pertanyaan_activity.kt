package com.indah.sicoco

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.indah.sicoco.model.JadwalModelResponseItem
import com.indah.sicoco.viewModel.JadwalViewModel
import kotlinx.android.synthetic.main.item_utama.*
import kotlinx.android.synthetic.main.pertanyaan_daftar.*

class pertanyaan_activity : AppCompatActivity(){
    //viewModel utk menampilkan di kelas daftar_coaching
    private lateinit var viewModel2 : JadwalViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pertanyaan_daftar)

        viewModel2 = ViewModelProvider(this).get(JadwalViewModel::class.java)

        //key "dataJadwal" harus disamakan dengan key yg dikelas dashboardactivity
        val dataJawal = intent.getParcelableExtra<JadwalModelResponseItem>("dataJadwal")

        //jika null beri tanda tanya
        judul.text = "Apakah anda yakin mendaftar pelatihan ${dataJawal?.nm_materi}?"

        ya.setOnClickListener{

            Log.d("as", "click: $dataJawal")

            //masih utk menampilkan recycle dri klik radio button YA
            viewModel2.getDashboard().observe(this, Observer { jadwal ->
                val intent = Intent(this, daftar_coaching::class.java)

                // Pada intent kita menggunakan "intent.putExtra" dan "dataJawal"
                // Karena hanya menampilkan yang diklik saja
                intent.putExtra("jadwal", dataJawal)
                startActivity(intent)
            })
        }

        tidak.setOnClickListener {
            viewModel2.getDashboard().observe(this, Observer { jadwal ->
                val intent = Intent(this, dashboardactivity::class.java)
                intent.putParcelableArrayListExtra("jadwal", jadwal)
                startActivity(intent)
            })
        }
    }
}