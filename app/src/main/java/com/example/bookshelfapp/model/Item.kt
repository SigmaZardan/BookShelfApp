package com.example.bookshelfapp.model

import kotlinx.serialization.Serializable

@Serializable
data class Item(
    val etag: String,
    val id: String,
    val kind: String,
    val selfLink: String,
    val volumeInfo: VolumeInfo
)