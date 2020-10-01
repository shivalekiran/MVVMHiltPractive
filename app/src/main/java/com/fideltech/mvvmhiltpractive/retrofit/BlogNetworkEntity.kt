package com.fideltech.mvvmhiltpractive.retrofit

import com.google.gson.annotations.SerializedName

//network model
data class BlogNetworkEntity(
    @SerializedName("pk")
    var id: Int,
    val body: String,
    val category: String,
    val image: String,
    val title: String
)