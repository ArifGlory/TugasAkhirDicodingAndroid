package com.tapisdev.dicodingandroidtugas1.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Article(
    val title: Int,
    val description: Int,
    val image: Int,

    ) : Parcelable