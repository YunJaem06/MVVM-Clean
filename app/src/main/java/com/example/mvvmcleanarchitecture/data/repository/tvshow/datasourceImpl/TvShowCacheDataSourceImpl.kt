package com.example.mvvmcleanarchitecture.data.repository.movie.datasourceImpl

import com.example.mvvmcleanarchitecture.data.model.movie.Movie
import com.example.mvvmcleanarchitecture.data.model.tvshow.TvShow
import com.example.mvvmcleanarchitecture.data.repository.artist.datasource.ArtistCacheDataSource
import com.example.mvvmcleanarchitecture.data.repository.tvshow.datasource.TvShowCacheDataSource

class TvShowCacheDataSourceImpl : TvShowCacheDataSource {
    private var tvShowList = ArrayList<TvShow>()

    override suspend fun getTvShowsFromCache(): List<TvShow> {
        return tvShowList
    }

    override suspend fun saveTvShowsToCache(tvShows: List<TvShow>) {
        tvShowList.clear()
        tvShowList = ArrayList(tvShows)
    }
}