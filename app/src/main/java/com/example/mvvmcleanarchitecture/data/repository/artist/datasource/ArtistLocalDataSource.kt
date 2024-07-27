package com.example.mvvmcleanarchitecture.data.repository.artist.datasource

import com.example.mvvmcleanarchitecture.data.model.artist.Artist

interface ArtistLocalDataSource {
    suspend fun getArtistsFromDB(): List<Artist>
    suspend fun saveArtistToDB(movies:List<Artist>)
    suspend fun clearAll()
}