package com.example.mvvmcompose.data.model.response

import android.os.Parcel
import android.os.Parcelable
import com.squareup.moshi.Json

open class BaseResponse<T>() : Parcelable {
    @Json(name = "get")
    var getResponse: String? = null

    @Json(name = "results")
    var results: Int = 0

    @Json(name = "response")
    var response: T? = null
        get() = field
        set(value) {
            field = value
        }

    constructor(parcel: Parcel) : this() {
        getResponse = parcel.readString()
        results = parcel.readInt()

    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.let {
            it.writeString(getResponse)
            it.writeInt(results)
        }

    }

    companion object CREATOR : Parcelable.Creator<BaseResponse<Parcelable>> {
        override fun createFromParcel(parcel: Parcel): BaseResponse<Parcelable> {
            return BaseResponse(parcel)
        }

        override fun newArray(size: Int): Array<BaseResponse<Parcelable>?> {
            return arrayOfNulls(size)
        }
    }

}
