package com.example.bookshelfapp.model

import kotlinx.serialization.Serializable

@Serializable
data class VolumeItem(
    val items: List<Item>,
)