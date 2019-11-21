package com.example.numaps

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


enum class Type {
    FOOD, PARKING, CLASSES, TRANSPORTATION
}

@Parcelize
data class Location(val title: String, val imageName: String, val description: String, val type: Type) : Parcelable