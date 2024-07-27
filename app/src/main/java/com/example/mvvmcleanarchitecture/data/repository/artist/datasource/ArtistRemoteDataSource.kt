package com.example.mvvmcleanarchitecture.data.repository.artist.datasource

import com.example.mvvmcleanarchitecture.data.model.artist.ArtistList
import com.example.mvvmcleanarchitecture.data.model.movie.MovieList
import retrofit2.Response

interface ArtistRemoteDataSource {
    suspend fun getArtists(): Response<ArtistList>
}