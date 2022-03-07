package com.indah.sicoco

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.indah.sicoco.MyToast.toast
import com.indah.sicoco.viewModel.RegisterModel
import kotlinx.android.synthetic.main.datadiri_activity.*

class register_activity : AppCompatActivity(){
    private lateinit var viewModel: RegisterModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.datadiri_activity)

        viewModel = ViewModelProvider(this).get(RegisterModel::class.java)

        btnSelanjutnya.setOnClickListener {
            val Rnama = editnama.text.toString().trim()
            val Rnip = editnip.text.toString().trim()
            val Ropd = editopd.text.toString().trim()
            val Rjabatan = editjabatan.text.toString().trim()
            val Rjenis_kelamin = editjeniskelamin.text.toString().trim()
            val Rtmp_lahir = edittmplahir.text.toString().trim()
            val Rtgl_lahir = edittgllahir.text.toString().trim()

            if (Rnama.isEmpty()) {
                editnama.error = "name harus di isi"
                editnama.requestFocus()
                return@setOnClickListener
            }
            if (Rnip.isEmpty()) {
                editnip.error = " nip harus di isi"
                editnip.requestFocus()
                return@setOnClickListener
            }
            if (Ropd.isEmpty()) {
                editopd.error = " OPD harus di isi"
                editopd.requestFocus()
                return@setOnClickListener
            }
            if (Rjabatan.isEmpty()) {
                editjabatan.error = " Jabatan harus di isi"
                editjabatan.requestFocus()
                return@setOnClickListener
            }
            if (Rjenis_kelamin.isEmpty()) {
                editjeniskelamin.error = " Jenis Kelamin harus di isi"
                editjeniskelamin.requestFocus()
                return@setOnClickListener
            }
            if (Rtmp_lahir.isEmpty()) {
                edittmplahir.error = " Tempat Lahir harus di isi"
                edittmplahir.requestFocus()
                return@setOnClickListener
            }
            if (Rtgl_lahir.isEmpty()) {
                edittgllahir.error = " Tanggal Lahir harus di isi"
                edittgllahir.requestFocus()
                return@setOnClickListener
            }


//            viewModel.registrasi(editnama.text.toString(), editnip.text.toString(), editopd.text.toString(),
//                    editjabatan.text.toString(), editjeniskelamin.text.toString(), edittmplahir.text.toString(),edittgllahir.text.toString()).
//                    observe(this, Observer {
//                if (it ==null){
                        Log.d("sad", "onCreate: wasd $it")
                        val intent = Intent(this@register_activity, register_activity2::class.java)

            intent.putExtra("nama",editnama.text.toString())
            intent.putExtra("nip",editnip.text.toString())
            intent.putExtra("opd",editopd.text.toString())
            intent.putExtra("jabatan",editjabatan.text.toString())
            intent.putExtra("jenis_kelamin",editjeniskelamin.text.toString())
            intent.putExtra("tmp_lahir",edittmplahir.text.toString())
            intent.putExtra("tgl_lahir",edittgllahir.text.toString())

            startActivity(intent)
        }

    }
}