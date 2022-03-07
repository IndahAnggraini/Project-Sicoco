package com.indah.sicoco

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.indah.sicoco.MyToast.toast
import com.indah.sicoco.viewModel.JadwalViewModel
import com.indah.sicoco.viewModel.LoginModel
import kotlinx.android.synthetic.main.login_activity.*

class login_activity : AppCompatActivity(){
    private lateinit var viewModel: LoginModel
    //viewModel2 untk menampung data recycle, lalu di tampilkan di kelas dashboard_activity
    private lateinit var viewModel2 : JadwalViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        viewModel = ViewModelProvider(this).get(LoginModel::class.java)
        viewModel2 = ViewModelProvider(this).get(JadwalViewModel::class.java)


        buttonlogin.setOnClickListener {
            val Lusername = username.text.toString().trim()
            val Lpassword = password.text.toString().trim()

            if (Lusername.isEmpty()) {
                username.error = "Username harus di isi"
                username.requestFocus()
                return@setOnClickListener
            }
            if (Lpassword.isEmpty()) {
                password.error = " Password harus di isi"
                password.requestFocus()
                return@setOnClickListener
            }

            viewModel.login(username.text.toString(), password .text.toString()).observe(this, Observer {
                if (it !=null){

                    //disini tempat menampung data recycle
                    viewModel2.getDashboard().observe(this, Observer { jadwal ->
                        val intent = Intent(this, MainActivity2::class.java)
                        intent.putParcelableArrayListExtra("jadwal",jadwal)
                       startActivity(intent)


                    })

                }
            })
        }

        registerlayanan.setOnClickListener {
            val intent = Intent(this, register_activity::class.java)
            startActivity(intent)
        }
    }
}