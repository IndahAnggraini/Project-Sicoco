package com.indah.sicoco.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class JadwalModelResponseItem(
    val jumlah_peserta: String,
    val pukul: String,
    val tanggal_mulai: String,
    val tempat: String,
    val nm_materi : String
): Parcelable