package com.xsat.hitoribocchi

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Char(
    val name: String,
    val description: String,
    val gender: String,
    val age: String,
    val photo: Int
): Parcelable
