package com.example.mvvmcleanarchitecture.presentation.di.core

import com.example.mvvmcleanarchitecture.data.db.ArtistDao
import com.example.mvvmcleanarchitecture.data.db.MovieDao
import com.example.mvvmcleanarchitecture.data.db.TvShowDao
import com.example.mvvmcleanarchitecture.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.mvvmcleanarchitecture.data.repository.artist.datasourceImpl.ArtistLocalDataSourceImpl
import com.example.mvvmcleanarchitecture.data.repository.movie.datasource.MovieLocalDataSource
import com.example.mvvmcleanarchitecture.data.repository.movie.datasourceImpl.MovieLocalDataSourceImpl
import com.example.mvvmcleanarchitecture.data.repository.movie.datasourceImpl.TvShowLocalDataSourceImpl
import com.example.mvvmcleanarchitecture.data.repository.tvshow.datasource.TvShowLocalDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao): MovieLocalDataSource {
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowDao: TvShowDao): TvShowLocalDataSource {
        return TvShowLocalDataSourceImpl(tvShowDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao : ArtistDao): ArtistLocalDataSource {
        return ArtistLocalDataSourceImpl(artistDao)
    }
}