package com.example.mvvmcleanarchitecture.domain.usecase

import com.example.mvvmcleanarchitecture.data.model.movie.Movie
import com.example.mvvmcleanarchitecture.domain.repository.MovieRepository

class GetMoviesUseCase(private val movieRepository: MovieRepository) {

    suspend fun execute(): List<Movie>? = movieRepository.getMovies()
}