package com.indah.sicoco.config

import com.indah.sicoco.model.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    //get t_materi
    @GET("api/getdashboard/getBuku")
    fun getBuku() :Call<ArrayList<BukuPanduanItem>>

    //post t_reg_peserta
    @POST("api/getdashboard/daftar")
    fun daftar(
        @Field("id_user") id_user: String,
        @Field("id_kelas") id_kelas: String
    ): Call<DaftarRespon>

    //get t jadwal 1
    @GET("api/getdashboard/getDashboard")
    fun getDashboard() :Call<ArrayList<JadwalModelResponseItem>>


    @FormUrlEncoded
    @POST("api/Authentication/login")

    fun login(
            @Field("username") username: String,
            @Field("password") password: String
    ): Call<LoginRespon>

    @FormUrlEncoded
    @POST("api/Authentication")

    fun registrasi(
            @Field("nama") nama: String,
            @Field("nip") nip: String,
            @Field("opd") opd: String,
            @Field("jabatan") jabatan: String,
            @Field("jenis_kelamin") jenis_kelamin: String,
            @Field("tmp_lahir") tmp_lahir: String,
            @Field("tgl_lahir") tgl_lahir: String,
            @Field("email") email: String,
            @Field("no_hp") no_hp: String,
            @Field("username") username: String,
            @Field("password") pass: String,
            @Field("konfirmasi_pass") konfirmasi_pass: String
    ): Call<RegisterRespon>



//    fun registrasi2(
////            @Field("nama") nama: String,
////            @Field("nip") nip: String,
////            @Field("opd") opd: String,
////            @Field("jabatan") jabatan: String,
////            @Field("jenis_kelamin") jenis_kelamin: String,
////            @Field("tmp_lahir") tmp_lahir: String,
////            @Field("tgl_lahir") tgl_lahir: Str  ing
//            @Field("email") email: String,
//            @Field("no_hp") no_hp: String,
//            @Field("username") username: String,
//            @Field("password") pass: String,
//            @Field("konfirmasi_pass") konfirmasi_pass: String
//    ): Call<RegisterRespon>

    companion object {
        fun create(): ApiService {
            val httpClient = OkHttpClient.Builder()
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            httpClient.addInterceptor(logging)
            val builder = Retrofit.Builder()
                    // .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .baseUrl("http://172.19.10.181/sicoco/") // http://172.18.10.61/sicoco/api/
                                        // http://sicocopkl.payakumbuhkota.go.id/
                                        // 169.254.40.164

            builder.client(httpClient.build())

            val retrofit = builder.build()
            return retrofit.create(ApiService::class.java)
        }
    }
}