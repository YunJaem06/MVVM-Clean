package com.example.mvvmcleanarchitecture.presentation.di.core

import com.example.mvvmcleanarchitecture.data.api.TMDBService
import com.example.mvvmcleanarchitecture.data.repository.artist.datasource.ArtistRemoteDataSource
import com.example.mvvmcleanarchitecture.data.repository.artist.datasourceImpl.ArtistRemoteDataSourceImpl
import com.example.mvvmcleanarchitecture.data.repository.movie.datasource.MovieRemoteDataSource
import com.example.mvvmcleanarchitecture.data.repository.movie.datasourceImpl.MovieRemoteDataSourceImpl
import com.example.mvvmcleanarchitecture.data.repository.movie.datasourceImpl.TvShowRemoteDataSourceImpl
import com.example.mvvmcleanarchitecture.data.repository.tvshow.datasource.TvShowRemoteDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService): MovieRemoteDataSource {
        return MovieRemoteDataSourceImpl(
            tmdbService, apiKey
        )
    }

    @Singleton
    @Provides
    fun provideTvRemoteDataSource(tmdbService: TMDBService): TvShowRemoteDataSource {
        return TvShowRemoteDataSourceImpl(
            tmdbService, apiKey
        )
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService): ArtistRemoteDataSource {
        return ArtistRemoteDataSourceImpl(
            tmdbService, apiKey
        )
    }
}