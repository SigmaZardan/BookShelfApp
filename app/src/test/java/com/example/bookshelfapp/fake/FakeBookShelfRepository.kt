package com.example.bookshelfapp.fake

import com.example.bookshelfapp.data.BookShelfRepository
import com.example.bookshelfapp.model.VolumeItem

class FakeBookShelfRepository : BookShelfRepository {
    override suspend fun getVolumeItem(): VolumeItem {
        return FakeDataSource.volumeItem
    }

}