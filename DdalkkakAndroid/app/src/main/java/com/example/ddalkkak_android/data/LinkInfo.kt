package com.example.ddalkkak_android.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class LinkInfo(
    @PrimaryKey(autoGenerate = false) val linkId: Int,
    val user: String,
    val username: String?,
    val title: String?,
    val originalUrl: String?,
    val thumbUrl: String?,
    val slackCreatedAt: String,
    val isLike: Boolean = false
) {
    constructor() : this(0,"","","","","","")
}