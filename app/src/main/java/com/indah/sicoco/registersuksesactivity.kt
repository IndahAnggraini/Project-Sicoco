package com.indah.sicoco

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.indah.sicoco.viewModel.JadwalViewModel
import kotlinx.android.synthetic.main.login_activity.*
import kotlinx.android.synthetic.main.registrasiberhasil_activity.*

class registersuksesactivity : AppCompatActivity() {

  //  lateinit var viewModel : JadwalViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registrasiberhasil_activity)

        //viewModel = ViewModelProvider(this).get(JadwalViewModel::class.java)

        btnOK.setOnClickListener {
            val intent = Intent(this, login_activity::class.java)
            startActivity(intent)
        }
    }
}