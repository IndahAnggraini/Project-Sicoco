package com.indah.sicoco.viewModel
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.indah.sicoco.config.ApiService
import com.indah.sicoco.model.RegisterRespon
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterModel : ViewModel() {
    private val api by lazy { ApiService.create() }
    fun registrasi(nama:String, nip : String, opd:String, jabatan :String, jenis_kelamin : String,
                   tmp_lahir : String, tgl_lahir : String,
                   email : String, no_hp : String, username : String,
                   pass : String, konfirmasi_pass : String) : LiveData<RegisterRespon?> {

        val data = MutableLiveData<RegisterRespon?>()

        api.registrasi(nama,nip,opd,jabatan,jenis_kelamin,tmp_lahir,tgl_lahir,
            email,no_hp,username,pass,konfirmasi_pass)
                .enqueue(object : Callback<RegisterRespon> {
                    override fun onResponse(call: Call<RegisterRespon>, response: Response<RegisterRespon>) {

                        if (response.isSuccessful) {
                            if (response.body() != null) {
                                data.value = response.body()
                            } else {
                                data.value = null
                            }
                        } else{
                            data.value = null
                        }
                    }

                    override fun onFailure(call: Call<RegisterRespon>, t: Throwable) {
                        Log.d("asdaw", "onFailure: ${t.message}")
                        data.value = null
                    }
                })
        return data
    }
}