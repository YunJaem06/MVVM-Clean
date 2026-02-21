package com.example.mvvmcleanarchitecture.presentation.di.core

import com.example.mvvmcleanarchitecture.data.repository.artist.datasource.ArtistCacheDataSource
import com.example.mvvmcleanarchitecture.data.repository.artist.datasourceImpl.ArtistCacheDataSourceImpl
import com.example.mvvmcleanarchitecture.data.repository.movie.datasource.MovieCacheDataSource
import com.example.mvvmcleanarchitecture.data.repository.movie.datasourceImpl.MovieCacheDataSourceImpl
import com.example.mvvmcleanarchitecture.data.repository.movie.datasourceImpl.TvShowCacheDataSourceImpl
import com.example.mvvmcleanarchitecture.data.repository.tvshow.datasource.TvShowCacheDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {
    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MovieCacheDataSource {
        return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTvShowCacheDataSource(): TvShowCacheDataSource {
        return TvShowCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistCacheDataSource(): ArtistCacheDataSource {
        return ArtistCacheDataSourceImpl()
    }
}