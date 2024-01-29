package com.example.bookshelfapp

import com.example.bookshelfapp.data.NetworkBookShelfRepository
import com.example.bookshelfapp.fake.FakeBookShelfApiService
import com.example.bookshelfapp.fake.FakeDataSource
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Test

class BookShelfRepositoryTest {
    @Test
    fun bookShelfRepository_getVolumeItem_verifyVolumeItem() {
        runTest {
            val repository = NetworkBookShelfRepository(
                bookShelfApiService = FakeBookShelfApiService()
            )
            assertEquals(repository.getVolumeItem(), FakeDataSource.volumeItem)
        }
    }
}