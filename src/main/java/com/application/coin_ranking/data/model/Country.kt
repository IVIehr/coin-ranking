package com.application.coin_ranking.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Country(
    val name: String,
    val code: String,
    val flag: String
) : Parcelable {

    fun compare(other: Country): Boolean {
        return name == other.name
                && code == other.code
                && flag == other.flag
    }
}
