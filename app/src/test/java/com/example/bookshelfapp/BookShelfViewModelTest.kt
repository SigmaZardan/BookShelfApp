package com.example.bookshelfapp

import com.example.bookshelfapp.fake.FakeBookShelfRepository
import com.example.bookshelfapp.fake.FakeDataSource
import com.example.bookshelfapp.rules.TestDispatcherRule
import com.example.bookshelfapp.ui.theme.screens.BookShelfUiState
import com.example.bookshelfapp.ui.theme.screens.BookShelfViewModel
import junit.framework.TestCase.assertEquals
import org.junit.Rule
import org.junit.Test

class BookShelfViewModelTest {
    @get:Rule
    val testDispatcher = TestDispatcherRule()

    @Test
    fun bookShelfViewModel_getBookVolume_verifyVolumeList() {
        val bookShelfViewModel = BookShelfViewModel(
            bookShelfRepository = FakeBookShelfRepository()
        )
        assertEquals(
            bookShelfViewModel.bookShelfUiState,
            BookShelfUiState.Success(FakeDataSource.volumeItem)
        )
    }
}