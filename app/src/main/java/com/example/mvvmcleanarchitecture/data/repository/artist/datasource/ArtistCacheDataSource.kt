package com.example.mvvmcleanarchitecture.data.repository.artist.datasource

import com.example.mvvmcleanarchitecture.data.model.artist.Artist

interface ArtistCacheDataSource {
    suspend fun getArtistsFromCache(): List<Artist>
    suspend fun saveArtistsToCache(artists:List<Artist>)
}