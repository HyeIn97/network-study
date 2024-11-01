package com.example.presentation.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DetailLikeModel(
    val title: String,
    val image: String,
    val author: String,
    val link: String
) : Parcelable