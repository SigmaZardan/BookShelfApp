package com.example.bookshelfapp.fake

import com.example.bookshelfapp.model.ImageLinks
import com.example.bookshelfapp.model.Item
import com.example.bookshelfapp.model.VolumeInfo
import com.example.bookshelfapp.model.VolumeItem

object FakeDataSource {
    private const val thumbnailOne = "thumbnail1"
    private const val thumbnailTwo = "thumbnail2"
    val volumeItem = VolumeItem(
        items = listOf(
            Item(
                volumeInfo = VolumeInfo(
                    imageLinks = ImageLinks(
                        thumbnailOne
                    )
                )
            ), Item(
                volumeInfo = VolumeInfo(
                    imageLinks = ImageLinks(
                        thumbnailTwo
                    )
                )
            )
        )
    )
}