package com.example.mvvmcleanarchitecture.data.repository.movie

import android.util.Log
import com.example.mvvmcleanarchitecture.data.model.movie.Movie
import com.example.mvvmcleanarchitecture.data.repository.movie.datasource.ArtistCacheDataSource
import com.example.mvvmcleanarchitecture.data.repository.movie.datasource.ArtistLocalDataSource
import com.example.mvvmcleanarchitecture.data.repository.movie.datasource.ArtistRemoteDataSource
import com.example.mvvmcleanarchitecture.domain.repository.MovieRepository

class MovieRepositoryImpl(
    private val movieRemoteDataSource : ArtistRemoteDataSource,
    private val movieLocalDataSource: ArtistLocalDataSource,
    private val movieCacheDataSource: ArtistCacheDataSource
) : MovieRepository {
    override suspend fun getMovies(): List<Movie>? {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
       val newListOfMovies = getMoviesFromAPI()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMovieToDB(newListOfMovies)
        movieCacheDataSource.saveMoviesToCache(newListOfMovies)
        return newListOfMovies
    }

    suspend fun getMoviesFromAPI():List<Movie> {
        lateinit var movieList:List<Movie>
        try {
            val response = movieRemoteDataSource.getMovies()
            val body = response.body()
            if (body != null) {
                movieList = body.results
            }
        }catch (e: Exception) {
            Log.d("myTag", e.message.toString())
        }
        return movieList
    }

    suspend fun getMoviesFromDB():List<Movie> {
        lateinit var movieList:List<Movie>
        try {
            movieList = movieLocalDataSource.getMoviesFromDB()
        }catch (e: Exception) {
            Log.d("myTag", e.message.toString())
        }
        if (movieList.size > 0) {
            return movieList
        } else {
            movieList = getMoviesFromAPI()
            movieLocalDataSource.saveMovieToDB(movieList)
        }
        return movieList
    }

    suspend fun getMoviesFromCache():List<Movie> {
        lateinit var movieList:List<Movie>
        try {
            movieList = movieCacheDataSource.getMoviesFromCache()
        }catch (e: Exception) {
            Log.d("myTag", e.message.toString())
        }
        if (movieList.size > 0) {
            return movieList
        } else {
            movieList = getMoviesFromCache()
            movieCacheDataSource.saveMoviesToCache(movieList)
        }
        return movieList
    }
}