package com.example.mvvmcleanarchitecture.presentation.di.tvshow

import com.example.mvvmcleanarchitecture.domain.usecase.GetTvShowUseCase
import com.example.mvvmcleanarchitecture.domain.usecase.UpdateTvShowUseCase
import com.example.mvvmcleanarchitecture.presentation.tv.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {

    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowUseCase: GetTvShowUseCase,
        updateTvShowUseCase: UpdateTvShowUseCase
    ): TvShowViewModelFactory {
        return TvShowViewModelFactory(
            getTvShowUseCase,
            updateTvShowUseCase
        )
    }
}