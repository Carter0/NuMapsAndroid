package com.example.numaps

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.io.Serializable


interface ILocation :Serializable {
    fun getTitle()
}

@Parcelize
data class Location(val title: String, val imageName: String, val description: String) : Parcelable