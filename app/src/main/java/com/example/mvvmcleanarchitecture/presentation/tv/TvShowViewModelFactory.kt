package com.example.mvvmcleanarchitecture.presentation.tv

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmcleanarchitecture.domain.usecase.GetArtistUseCase
import com.example.mvvmcleanarchitecture.domain.usecase.GetTvShowUseCase
import com.example.mvvmcleanarchitecture.domain.usecase.UpdateArtistUseCase
import com.example.mvvmcleanarchitecture.domain.usecase.UpdateTvShowUseCase

class TvShowViewModelFactory(
    private val getTvShowUseCase: GetTvShowUseCase,
    private val updateTvShowUseCase: UpdateTvShowUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TvShowViewModel(getTvShowUseCase, updateTvShowUseCase) as T
    }
}