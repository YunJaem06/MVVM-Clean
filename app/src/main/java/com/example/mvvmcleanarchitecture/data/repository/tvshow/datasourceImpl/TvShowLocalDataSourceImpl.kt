package com.example.mvvmcleanarchitecture.data.repository.movie.datasourceImpl

import com.example.mvvmcleanarchitecture.data.db.MovieDao
import com.example.mvvmcleanarchitecture.data.db.TvShowDao
import com.example.mvvmcleanarchitecture.data.model.movie.Movie
import com.example.mvvmcleanarchitecture.data.model.tvshow.TvShow
import com.example.mvvmcleanarchitecture.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.mvvmcleanarchitecture.data.repository.tvshow.datasource.TvShowLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvShowLocalDataSourceImpl(private val tvShowDao: TvShowDao) : TvShowLocalDataSource {

    override suspend fun getTvShowsFromDB(): List<TvShow> {
        return tvShowDao.getTvShows()
    }

    override suspend fun saveTvShowToDB(tvShows: List<TvShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.saveTvShows(tvShows)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.deleteAllTvShows()
        }
    }
}