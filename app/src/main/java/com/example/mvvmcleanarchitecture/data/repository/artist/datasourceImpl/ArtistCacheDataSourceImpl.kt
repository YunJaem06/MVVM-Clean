package com.example.mvvmcleanarchitecture.data.repository.artist.datasourceImpl

import com.example.mvvmcleanarchitecture.data.model.artist.Artist
import com.example.mvvmcleanarchitecture.data.model.movie.Movie
import com.example.mvvmcleanarchitecture.data.repository.artist.datasource.ArtistCacheDataSource

class ArtistCacheDataSourceImpl : ArtistCacheDataSource {
    private var artistList = ArrayList<Artist>()

    override suspend fun getArtistsFromCache(): List<Artist> {
        return artistList
    }

    override suspend fun saveArtistsToCache(artists: List<Artist>) {
        artistList.clear()
        artistList = ArrayList(artists)
    }
}