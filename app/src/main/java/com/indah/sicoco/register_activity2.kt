package com.indah.sicoco

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.indah.sicoco.viewModel.RegisterModel
import kotlinx.android.synthetic.main.data_akun.*

class register_activity2 : AppCompatActivity(){
    private lateinit var viewModel: RegisterModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.data_akun)

        viewModel = ViewModelProvider(this).get(RegisterModel::class.java)

        btnselesai.setOnClickListener {

            // ?: "" agar tidak bernilai null
            val nama = intent.getStringExtra("nama") ?: ""
            val nip = intent.getStringExtra("nip") ?: ""
            val opd = intent.getStringExtra("opd") ?: ""
            val jabatan = intent.getStringExtra("jabatan") ?:""
            val jenis_kelamin = intent.getStringExtra("jenis_kelamin") ?:""
            val tmp_lahir = intent.getStringExtra("tmp_lahir")?:""
            val tgl_lahir = intent.getStringExtra("tgl_lahir")?:""

            Log.d("as", "onCreate: $nama $nip $opd $jabatan $jenis_kelamin $tmp_lahir $tgl_lahir")

            val Remail = email.text.toString().trim()
            val Rno_hp = nohp.text.toString().trim()
            val Rusername = username.text.toString().trim()
            val Rpassword = pass.text.toString().trim()
            val Rkonfirmasipass = konpass.text.toString().trim()


            if (Remail.isEmpty()) {
                email.error = " Email harus di isi"
                email.requestFocus()
                return@setOnClickListener
            }
            if (Rno_hp.isEmpty()) {
                nohp.error = " Email harus di isi"
                nohp.requestFocus()
                return@setOnClickListener
            }
            if (Rusername.isEmpty()) {
                username.error = " Email harus di isi"
                username.requestFocus()
                return@setOnClickListener
            }
            if (Rpassword.isEmpty()) {
                pass.error = " Email harus di isi"
                pass.requestFocus()
                return@setOnClickListener
            }
            if (Rkonfirmasipass.isEmpty()) {
                konpass.error = " Email harus di isi"
                konpass.requestFocus()
                return@setOnClickListener
            }

            // dari nama sampai tgl_lahir dijadiin yg di putEkstra karena telah disimpan, agar tidak kemungkinan-
            // null maka beri di atasnya dengan perintah ?: Kutip ini berfungsi agar tidak bernilai null dan
            // terserah mau jadi nilai apa""
            viewModel.registrasi(nama,nip, opd,
                jabatan,jenis_kelamin, tmp_lahir,
                tgl_lahir,email.text.toString(), nohp.text.toString(), username.text.toString(),
                    pass.text.toString(), konpass.text.toString()).observe(this, Observer {
                if (it ==null){

                }
                else{
//                    toast(it.message)
                    Log.d("sad", "onCreate: wasd $it")
                    val intent = Intent(this@register_activity2, registersuksesactivity::class.java)
                    startActivity(intent)
                }


            })

        }



    }
}