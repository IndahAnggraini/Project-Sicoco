package com.indah.sicoco.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class BukuPanduanItem(
    val buku_panduan: String,
    val link_video: String
): Parcelable