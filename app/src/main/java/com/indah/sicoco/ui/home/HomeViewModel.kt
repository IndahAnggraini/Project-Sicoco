package com.indah.sicoco.ui.home

import android.content.Intent
import android.util.Log
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.indah.sicoco.Adapter.JadwalAdapter
import com.indah.sicoco.model.JadwalModelResponseItem
import com.indah.sicoco.pertanyaan_activity
import kotlinx.android.synthetic.main.fragment_home.*

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
//        value = "This is home Fragment"

        //       setelah tampung di login, baru memakai di tampilkan dengan get, menggunakan getParcelable
//        val listJadwal = intent.getParcelableArrayListExtra<JadwalModelResponseItem>("jadwal") ?:ArrayList()
//
//        Log.d("erorr", "onCreate: ${listJadwal}")
//        val adapter = JadwalAdapter(listJadwal)
//        recycle.layoutManager = LinearLayoutManager(this)
//        recycle.adapter = adapter
//
//        //alertDialog dari adapter
//        adapter.setOnItemClickListener { i, jadwalModelResponseItem ->
//            //onitem --> diklik text view bukan button
//            Log.d("onitem", "click: pos $i data $jadwalModelResponseItem ")
//
//            val intent = Intent(this, pertanyaan_activity::class.java)
//
//            //jadwalModelResponseItem ditampung didalam putEkstra
//            intent.putExtra("dataJadwal",jadwalModelResponseItem)
//
//            startActivity(intent)
//        }
    }
    val text: LiveData<String> = _text
}