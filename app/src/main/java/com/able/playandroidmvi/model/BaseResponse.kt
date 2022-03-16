package com.able.playandroidmvi.model

import com.google.gson.annotations.SerializedName

data class BaseResponse<T>(
    @field:SerializedName("data") val data: T?,
    @field:SerializedName("errorCode") val errorCode: Int,
    @field:SerializedName("errorMsg") val errorMsg: String,

)
