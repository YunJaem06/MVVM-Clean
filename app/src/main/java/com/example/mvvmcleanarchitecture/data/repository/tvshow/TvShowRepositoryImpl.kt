package com.example.mvvmcleanarchitecture.data.repository.tvshow

import android.util.Log
import com.example.mvvmcleanarchitecture.data.model.movie.Movie
import com.example.mvvmcleanarchitecture.data.model.tvshow.TvShow
import com.example.mvvmcleanarchitecture.data.repository.artist.datasource.ArtistCacheDataSource
import com.example.mvvmcleanarchitecture.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.mvvmcleanarchitecture.data.repository.artist.datasource.ArtistRemoteDataSource
import com.example.mvvmcleanarchitecture.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.example.mvvmcleanarchitecture.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.example.mvvmcleanarchitecture.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.example.mvvmcleanarchitecture.domain.repository.MovieRepository
import com.example.mvvmcleanarchitecture.domain.repository.TvShowRepository

class TvShowRepositoryImpl(
    private val tvShowRemoteDataSource : TvShowRemoteDataSource,
    private val tvShowLocalDataSource: TvShowLocalDataSource,
    private val tvShowCacheDataSource: TvShowCacheDataSource
) : TvShowRepository {

    override suspend fun getTvShows(): List<TvShow>? {
        return getTvShowsFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow>? {
        val newListOfTvShows = getTvShowsFromAPI()
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.saveTvShowToDB(newListOfTvShows)
        tvShowCacheDataSource.saveTvShowsToCache(newListOfTvShows)
        return newListOfTvShows
    }

    suspend fun getTvShowsFromAPI():List<TvShow> {
        lateinit var tvShowList:List<TvShow>
        try {
            val response = tvShowRemoteDataSource.getTvShows()
            val body = response.body()
            if (body != null) {
                tvShowList = body.results
            }
        }catch (e: Exception) {
            Log.d("myTag", e.message.toString())
        }
        return tvShowList
    }

    suspend fun getTvShowsFromDB():List<TvShow> {
        lateinit var tvShowList:List<TvShow>
        try {
            tvShowList = tvShowLocalDataSource.getTvShowsFromDB()
        }catch (e: Exception) {
            Log.d("myTag", e.message.toString())
        }
        if (tvShowList.size > 0) {
            return tvShowList
        } else {
            tvShowList = getTvShowsFromAPI()
            tvShowLocalDataSource.saveTvShowToDB(tvShowList)
        }
        return tvShowList
    }

    suspend fun getTvShowsFromCache():List<TvShow> {
        lateinit var tvShowList:List<TvShow>
        try {
            tvShowList = tvShowCacheDataSource.getTvShowsFromCache()
        }catch (e: Exception) {
            Log.d("myTag", e.message.toString())
        }
        if (tvShowList.size > 0) {
            return tvShowList
        } else {
            tvShowList = getTvShowsFromCache()
            tvShowCacheDataSource.saveTvShowsToCache(tvShowList)
        }
        return tvShowList
    }


}