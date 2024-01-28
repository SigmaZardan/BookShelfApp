package com.example.bookshelfapp.model

import kotlinx.serialization.Serializable

@Serializable
data class VolumeInfo(
    val imageLinks: ImageLinks,
    )