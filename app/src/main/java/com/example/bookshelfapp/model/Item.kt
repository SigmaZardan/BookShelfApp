package com.example.bookshelfapp.model

import kotlinx.serialization.Serializable

@Serializable
data class Item(
    val volumeInfo: VolumeInfo
)