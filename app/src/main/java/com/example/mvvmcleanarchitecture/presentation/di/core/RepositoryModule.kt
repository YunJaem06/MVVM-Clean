package com.example.mvvmcleanarchitecture.presentation.di.core

import com.example.mvvmcleanarchitecture.data.repository.artist.ArtistRepositoryImpl
import com.example.mvvmcleanarchitecture.data.repository.artist.datasource.ArtistCacheDataSource
import com.example.mvvmcleanarchitecture.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.mvvmcleanarchitecture.data.repository.artist.datasource.ArtistRemoteDataSource
import com.example.mvvmcleanarchitecture.data.repository.movie.MovieRepositoryImpl
import com.example.mvvmcleanarchitecture.data.repository.movie.datasource.MovieCacheDataSource
import com.example.mvvmcleanarchitecture.data.repository.movie.datasource.MovieLocalDataSource
import com.example.mvvmcleanarchitecture.data.repository.movie.datasource.MovieRemoteDataSource
import com.example.mvvmcleanarchitecture.data.repository.tvshow.TvShowRepositoryImpl
import com.example.mvvmcleanarchitecture.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.example.mvvmcleanarchitecture.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.example.mvvmcleanarchitecture.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.example.mvvmcleanarchitecture.domain.repository.ArtistRepository
import com.example.mvvmcleanarchitecture.domain.repository.MovieRepository
import com.example.mvvmcleanarchitecture.domain.repository.TvShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideMovieRepository(
        movieRemoteDatasource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ): MovieRepository {

        return MovieRepositoryImpl(
            movieRemoteDatasource,
            movieLocalDataSource,
            movieCacheDataSource
        )
    }

    @Provides
    @Singleton
    fun provideTvShowRepository(
        tvShowRemoteDatasource: TvShowRemoteDataSource,
        tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowCacheDataSource: TvShowCacheDataSource
    ): TvShowRepository {

        return TvShowRepositoryImpl(
            tvShowRemoteDatasource,
            tvShowLocalDataSource,
            tvShowCacheDataSource
        )
    }

    @Provides
    @Singleton
    fun provideArtistRepository(
        artistRemoteDatasource: ArtistRemoteDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource
    ): ArtistRepository {

        return ArtistRepositoryImpl(
            artistRemoteDatasource,
            artistLocalDataSource,
            artistCacheDataSource
        )
    }
}