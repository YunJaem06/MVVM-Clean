package com.example.mvvmcleanarchitecture.data.repository.artist.datasourceImpl

import com.example.mvvmcleanarchitecture.data.api.TMDBService
import com.example.mvvmcleanarchitecture.data.model.artist.ArtistList
import com.example.mvvmcleanarchitecture.data.model.movie.MovieList
import com.example.mvvmcleanarchitecture.data.repository.artist.datasource.ArtistRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
) : ArtistRemoteDataSource {
    override suspend fun getArtists(): Response<ArtistList> = tmdbService.getPopularArtist(apiKey)
}