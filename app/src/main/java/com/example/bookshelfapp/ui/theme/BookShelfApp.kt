package com.example.bookshelfapp.ui.theme

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bookshelfapp.R
import com.example.bookshelfapp.ui.theme.screens.BookShelfViewModel
import com.example.bookshelfapp.ui.theme.screens.HomeScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookShelfApp(modifier: Modifier = Modifier) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    val bookShelfViewModel: BookShelfViewModel = viewModel(factory = BookShelfViewModel.Factory)
    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            BookShelfTopAppBar(scrollBehavior = scrollBehavior)
        },
    ) { paddingValues ->
        HomeScreen(
            retryAction = { bookShelfViewModel.getBookVolume() },
            bookShelfUiState = bookShelfViewModel.bookShelfUiState,
            modifier = Modifier.padding(paddingValues)
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookShelfTopAppBar(scrollBehavior: TopAppBarScrollBehavior) {
    CenterAlignedTopAppBar(
        title = {
            Text(stringResource(R.string.bookshelf))
        }, scrollBehavior = scrollBehavior,
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun BookShelfTopAppBarPreview() {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    BookShelfTopAppBar(scrollBehavior = scrollBehavior)
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BookShelfAppPreview() {
    BookShelfApp()
}