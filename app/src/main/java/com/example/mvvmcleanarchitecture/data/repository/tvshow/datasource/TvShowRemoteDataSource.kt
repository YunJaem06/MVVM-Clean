package com.example.mvvmcleanarchitecture.data.repository.tvshow.datasource

import com.example.mvvmcleanarchitecture.data.model.tvshow.TvShowList
import retrofit2.Response

interface TvShowRemoteDataSource {
    suspend fun getTvShows(): Response<TvShowList>
}