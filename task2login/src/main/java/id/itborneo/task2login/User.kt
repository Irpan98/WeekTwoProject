package id.itborneo.task2login

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class User (
    var username : String,
    var password: String
): Parcelable