package com.example.bookshelfapp.ui.theme.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.bookshelfapp.BookShelfApplication
import com.example.bookshelfapp.data.BookShelfRepository
import com.example.bookshelfapp.model.VolumeItem
import kotlinx.coroutines.launch
import java.io.IOException

class BookShelfViewModel(private val bookShelfRepository: BookShelfRepository) : ViewModel() {
    var bookShelfUiState: BookShelfUiState by mutableStateOf(BookShelfUiState.Loading)

    init {
        getBookVolume()
    }

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val application =
                    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as BookShelfApplication)
                val bookShelfRepository = application.container.bookShelfRepository
                BookShelfViewModel(bookShelfRepository)
            }
        }
    }

    fun getBookVolume() {
        viewModelScope.launch {
            bookShelfUiState = try {
                val volumeItem = bookShelfRepository.getVolumeItem()
                BookShelfUiState.Success(volumeItem)
            } catch (e: IOException) {
                BookShelfUiState.Error
            }
        }
    }
}


sealed interface BookShelfUiState {
    data class Success(val volumeItem: VolumeItem) : BookShelfUiState
    data object Error : BookShelfUiState
    data object Loading : BookShelfUiState
}