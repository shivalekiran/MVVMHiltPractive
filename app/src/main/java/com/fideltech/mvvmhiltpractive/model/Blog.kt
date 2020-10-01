package com.fideltech.mvvmhiltpractive.model

//domain model
data class Blog(
    val body: String,
    val category: String,
    val image: String,
    val id: Int,
    val title: String
)