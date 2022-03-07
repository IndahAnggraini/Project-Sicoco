package com.indah.sicoco.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.indah.sicoco.config.ApiService
import com.indah.sicoco.model.LoginRespon
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginModel : ViewModel() {
    private val api by lazy { ApiService.create() }
    fun login(username:String, password:String) : LiveData<LoginRespon?> {

        val data = MutableLiveData<LoginRespon?>()

        api.login(username,password)
                .enqueue(object : Callback<LoginRespon> {
                    override fun onResponse(call: Call<LoginRespon>, response: Response<LoginRespon>) {

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

                    override fun onFailure(call: Call<LoginRespon>, t: Throwable) {
                        Log.d("asdaw", "onFailure: ${t.message}")
                        data.value = null
                    }
                })
        return data
    }
}