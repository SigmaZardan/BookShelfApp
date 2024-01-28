package com.example.bookshelfapp.data

import com.example.bookshelfapp.network.BookShelfApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface AppContainer {
    val bookShelfRepository: BookShelfRepository
}


class DefaultAppContainer : AppContainer {


    private val baseUrl = "https://www.googleapis.com/books/v1/"

    private val retrofit = Retrofit.Builder().addConverterFactory(
        GsonConverterFactory.create()
    ).baseUrl(baseUrl).build()


    private val retrofitService: BookShelfApiService by lazy {
        retrofit.create(BookShelfApiService::class.java)
    }


    override val bookShelfRepository: NetworkBookShelfRepository by lazy {
        NetworkBookShelfRepository(retrofitService)
    }
}