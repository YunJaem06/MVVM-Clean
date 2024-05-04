package com.example.mvvmcleanarchitecture.domain.repository

import com.example.mvvmcleanarchitecture.data.model.tvshow.TvShow

interface TvShowRepository {

    suspend fun getTvShows(): List<TvShow>?

    suspend fun updateTvShows(): List<TvShow>?
}