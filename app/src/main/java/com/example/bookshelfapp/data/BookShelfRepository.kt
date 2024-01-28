package com.example.bookshelfapp.data

import com.example.bookshelfapp.model.VolumeItem
import com.example.bookshelfapp.network.BookShelfApiService


interface BookShelfRepository {
    suspend fun getVolumeItem(): VolumeItem
}


class NetworkBookShelfRepository(private val bookShelfApiService: BookShelfApiService) :
    BookShelfRepository {
    override suspend fun getVolumeItem(): VolumeItem {
        return bookShelfApiService.getVolumeItem()
    }
}