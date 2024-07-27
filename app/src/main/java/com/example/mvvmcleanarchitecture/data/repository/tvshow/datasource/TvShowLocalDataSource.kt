package com.example.mvvmcleanarchitecture.data.repository.tvshow.datasource

import com.example.mvvmcleanarchitecture.data.model.tvshow.TvShow

interface TvShowLocalDataSource {
    suspend fun getTvShowsFromDB(): List<TvShow>
    suspend fun saveTvShowToDB(movies:List<TvShow>)
    suspend fun clearAll()
}