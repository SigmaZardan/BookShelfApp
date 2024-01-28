package com.example.bookshelfapp.network

import com.example.bookshelfapp.model.VolumeItem
import retrofit2.http.GET

interface BookShelfApiService {
    @GET("volumes?q=jazz+history")
    suspend fun getVolumeItem(): VolumeItem
}