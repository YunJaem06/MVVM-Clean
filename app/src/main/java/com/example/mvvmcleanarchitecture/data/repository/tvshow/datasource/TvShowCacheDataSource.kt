package com.example.mvvmcleanarchitecture.data.repository.tvshow.datasource

import com.example.mvvmcleanarchitecture.data.model.tvshow.TvShow

interface TvShowCacheDataSource {
    suspend fun getTvShowsFromCache(): List<TvShow>
    suspend fun saveTvShowsToCache(movies:List<TvShow>)
}