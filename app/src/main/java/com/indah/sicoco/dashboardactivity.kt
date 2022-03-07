package com.indah.sicoco

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.indah.sicoco.Adapter.JadwalAdapter
import com.indah.sicoco.model.JadwalModelResponseItem
//import kotlinx hanya boleh satu
import kotlinx.android.synthetic.main.dashboard_activity.*


class dashboardactivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dashboard_activity)

        //setelah tampung di login, baru memakai di tampilkan dengan get, menggunakan getParcelable
        val listJadwal = intent.getParcelableArrayListExtra<JadwalModelResponseItem>("jadwal") ?:ArrayList()

        Log.d("erorr", "onCreate: ${listJadwal}")
        val adapter = JadwalAdapter(listJadwal)
        recycle.layoutManager = LinearLayoutManager(this)
        recycle.adapter = adapter



        //alertDialog dari adapter
        adapter.setOnItemClickListener { i, jadwalModelResponseItem ->
            //onitem --> diklik text view bukan button
            Log.d("onitem", "click: pos $i data $jadwalModelResponseItem ")

            val intent = Intent(this@dashboardactivity, pertanyaan_activity::class.java)

            //jadwalModelResponseItem ditampung didalam putEkstra
            intent.putExtra("dataJadwal",jadwalModelResponseItem)

            startActivity(intent)
        }

    }

    private fun showMenu() {
        val id : String = intent.getStringExtra("ID_OUTLET").toString()

    }

}