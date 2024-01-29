package com.example.bookshelfapp.ui.theme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.bookshelfapp.R
import com.example.bookshelfapp.model.Item

@Composable
fun HomeScreen(
    retryAction: () -> Unit, bookShelfUiState: BookShelfUiState, modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier.fillMaxSize()
    ) {
        when (bookShelfUiState) {
            is BookShelfUiState.Success -> BookCoverListScreen(bookShelfUiState.volumeItem.items)
            is BookShelfUiState.Error -> ErrorScreen(
                retryAction = retryAction, modifier = Modifier.fillMaxSize()
            )

            is BookShelfUiState.Loading -> LoadingScreen(modifier = Modifier.fillMaxSize())
        }

    }

}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Image(
        modifier = modifier.size(200.dp),
        painter = painterResource(R.drawable.loading_img),
        contentDescription = stringResource(R.string.loading),
    )
}

@Composable
fun ErrorScreen(retryAction: () -> Unit, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_connection_error),
            contentDescription = null
        )
        Text(text = stringResource(R.string.failed_to_load), modifier = Modifier.padding(16.dp))
        Button(onClick = {
            retryAction()
        }) {
            Text("Retry")
        }
    }
}

@Composable
fun BookCoverListScreen(books: List<Item>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(books) { book ->
            BookCoverItem(thumbnail = book.volumeInfo.imageLinks.thumbnail)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BookCoverListScreenPreview() {
    BookCoverListScreen(books = emptyList())
}


@Composable
fun BookCoverItem(thumbnail: String) {
    AsyncImage(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp),
        model = ImageRequest.Builder(context = LocalContext.current)
            .data(thumbnail.replace("http", "https")).crossfade(true).build(),
        error = painterResource(R.drawable.ic_broken_image),
        placeholder = painterResource(R.drawable.loading_img),
        contentDescription = stringResource(R.string.book_cover_image),
        contentScale = ContentScale.Crop
    )
}