package com.example.mvvmcleanarchitecture.presentation.di.artist

import com.example.mvvmcleanarchitecture.domain.usecase.GetArtistUseCase
import com.example.mvvmcleanarchitecture.domain.usecase.UpdateArtistUseCase
import com.example.mvvmcleanarchitecture.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {

    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistsUseCase: GetArtistUseCase,
        updateArtistsUseCase: UpdateArtistUseCase
    ): ArtistViewModelFactory {
        return ArtistViewModelFactory(
            getArtistsUseCase,
            updateArtistsUseCase
        )
    }
}