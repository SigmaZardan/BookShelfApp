package com.example.bookshelfapp.fake

import com.example.bookshelfapp.model.VolumeItem
import com.example.bookshelfapp.network.BookShelfApiService

class FakeBookShelfApiService : BookShelfApiService {
    override suspend fun getVolumeItem(): VolumeItem {
        return FakeDataSource.volumeItem
    }
}