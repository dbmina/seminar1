package org.techtown.hw1

import com.google.gson.annotations.SerializedName

data class SampleResponseData(
    val data: Data,
    @SerializedName("message")
    val message: String,
    val status: Int,
    val success: Boolean
) {
    data class Data(
        val email: String,
        val password: String,
        val userName: String
    )
}