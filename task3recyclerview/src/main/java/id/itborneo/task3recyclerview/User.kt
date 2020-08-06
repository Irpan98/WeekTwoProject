package id.itborneo.task3recyclerview

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    var name: String,
    var avatar: String,
    var company: String,
    var city: String,
    var follower: String,
    var following: String
): Parcelable


