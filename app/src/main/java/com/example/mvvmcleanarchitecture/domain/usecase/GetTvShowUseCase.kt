package com.example.mvvmcleanarchitecture.domain.usecase

import com.example.mvvmcleanarchitecture.data.model.tvshow.TvShow
import com.example.mvvmcleanarchitecture.domain.repository.TvShowRepository

class GetTvShowUseCase(private val tvShowRepository: TvShowRepository) {

    suspend fun execute(): List<TvShow>? = tvShowRepository.getTvShows()

}