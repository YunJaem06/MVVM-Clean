package com.example.mvvmcleanarchitecture.data.repository.movie.datasource

import com.example.mvvmcleanarchitecture.data.model.movie.Movie

interface MovieLocalDataSource {
    suspend fun getMoviesFromDB(): List<Movie>
    suspend fun saveMovieToDB(movies:List<Movie>)
    suspend fun clearAll()
}