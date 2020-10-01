package com.fideltech.mvvmhiltpractive.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "blogs")
data class BlogCacheEntity(
    @PrimaryKey(autoGenerate = false)
    var id: Int,
    val body: String,
    val category: String,
    val image: String,
    val title: String
)