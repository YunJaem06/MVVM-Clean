package com.example.mvvmcleanarchitecture.presentation.tv

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.mvvmcleanarchitecture.domain.usecase.GetTvShowUseCase
import com.example.mvvmcleanarchitecture.domain.usecase.UpdateTvShowUseCase

class TvShowViewModel(
    private val getTvShowUseCase: GetTvShowUseCase,
    private val updateTvShowUseCase: UpdateTvShowUseCase
) : ViewModel() {

    fun getArtists() = liveData {
        val tvShowList = getTvShowUseCase.execute()
        emit(tvShowList)
    }

    fun updateArtists() = liveData {
        val tvShowList = updateTvShowUseCase.execute()
        emit(tvShowList)
    }
}