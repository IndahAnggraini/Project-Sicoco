package com.indah.sicoco.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.indah.sicoco.config.ApiService
import com.indah.sicoco.model.BukuPanduanItem
import com.indah.sicoco.model.DaftarRespon
import com.indah.sicoco.model.JadwalModelResponseItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class JadwalViewModel :ViewModel() {

    private val api by lazy { ApiService.create() }

    //Tambah 1 function disini setelah buat api di VSCode
    fun daftar(id_kelas:String, id_user:String) : LiveData<DaftarRespon?>{
        val data = MutableLiveData<DaftarRespon?>()

        api.daftar(id_kelas,id_user)
            .enqueue(object : Callback<DaftarRespon> {
                override fun onResponse(call: Call<DaftarRespon>, response: Response<DaftarRespon>) {

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

                override fun onFailure(call: Call< DaftarRespon>, t: Throwable) {
                    Log.d("asdaw", "onFailure: ${t.message}")
                    data.value = null
                }
            })
        return data
    }


    fun getDashboard() : LiveData<ArrayList<JadwalModelResponseItem>?>{
        val data = MutableLiveData<ArrayList<JadwalModelResponseItem>?>()

        api.getDashboard().enqueue(object : Callback<ArrayList<JadwalModelResponseItem>>{
            override fun onFailure(call: Call<ArrayList<JadwalModelResponseItem>>, t: Throwable) {
                data.value =null
                Log.d("getjadwal", "onFailure: ${t.message}")
            }

            override fun onResponse(call: Call<ArrayList<JadwalModelResponseItem>>, response: Response<ArrayList<JadwalModelResponseItem>>) {
              if(response.isSuccessful){
                  data.value = response.body()
              }else{
                  data.value= null
              }
            }

        })

        return data
    }

    fun getBuku() : LiveData<ArrayList<BukuPanduanItem>?>{
        val data = MutableLiveData<ArrayList<BukuPanduanItem>?>()

        api.getBuku().enqueue(object : Callback<ArrayList<BukuPanduanItem>>{
            override fun onFailure(call: Call<ArrayList<BukuPanduanItem>>, t: Throwable) {
                data.value =null
                Log.d("getjadwal", "onFailure: ${t.message}")
            }

            override fun onResponse(call: Call<ArrayList<BukuPanduanItem>>, response: Response<ArrayList<BukuPanduanItem>>) {
                if(response.isSuccessful){
                    data.value = response.body()
                }else{
                    data.value= null
                }
            }

        })

        return data
    }
}