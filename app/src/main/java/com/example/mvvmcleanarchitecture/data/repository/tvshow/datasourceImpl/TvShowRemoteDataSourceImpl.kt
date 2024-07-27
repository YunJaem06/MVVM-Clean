package com.example.mvvmcleanarchitecture.data.repository.movie.datasourceImpl

import com.example.mvvmcleanarchitecture.data.api.TMDBService
import com.example.mvvmcleanarchitecture.data.model.movie.MovieList
import com.example.mvvmcleanarchitecture.data.model.tvshow.TvShowList
import com.example.mvvmcleanarchitecture.data.repository.artist.datasource.ArtistRemoteDataSource
import com.example.mvvmcleanarchitecture.data.repository.tvshow.datasource.TvShowRemoteDataSource
import retrofit2.Response

class TvShowRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
) : TvShowRemoteDataSource {
    override suspend fun getTvShows(): Response<TvShowList> = tmdbService.getPopularTvShows(apiKey)
}