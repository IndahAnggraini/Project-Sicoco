package com.indah.sicoco.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class DataItem_model {
    @SerializedName("id")
    @Expose
    var id = 0

    @SerializedName("id_user")
    @Expose
    private var id_user: String? = null

    @SerializedName("nama")
    @Expose
    private var nama: String? = null

    @SerializedName("nip")
    @Expose
    private var nip: String? = null

    @SerializedName("jabatan")
    @Expose
    private var jabatan: String? = null

    @SerializedName("opd")
    @Expose
    private var opd: String? = null

    @SerializedName("jenis_kelamin")
    @Expose
    private var jenis_kelamin: String? = null

    @SerializedName("tgl_lahir")
    @Expose
    private var tgl_lahir: String? = null

    @SerializedName("no_hp")
    @Expose
    private var no_hp: String? = null

    @SerializedName("email")
    @Expose
    private var email: String? = null

    fun getId_user(): String? {
        return id_user
    }

    fun setId_user(id_user: String) {
        this.id_user = id_user
    }

    fun getNama(): String? {
        return nama
    }

    fun setNama(nama: String) {
        this.nama = nama
    }

    fun getNip(): String? {
        return nip
    }

    fun setNip(nip: String) {
        this.nip = nip
    }

    fun getJabatan(): String? {
        return jabatan
    }

    fun setJabatan(jabatan: String) {
        this.jabatan = jabatan
    }

    fun getOpd(): String? {
        return opd
    }

    fun setOpd(opd: String) {
        this.opd = opd
    }

    fun getJenis_kelamin(): String? {
        return jenis_kelamin
    }

    fun setJenis_kelamin(jenis_kelamin: String) {
        this.jenis_kelamin = jenis_kelamin
    }

    fun getTgl_lahir(): String? {
        return tgl_lahir
    }

    fun setTgl_lahir(tgl_lahir: String) {
        this.tgl_lahir = tgl_lahir
    }

    fun getNo_hp(): String? {
        return no_hp
    }

    fun setNo_hp(no_hp: String) {
        this.no_hp = no_hp
    }

    fun getEmail(): String? {
        return email
    }

    fun setEmail(email: String) {
        this.email = email
    }
}