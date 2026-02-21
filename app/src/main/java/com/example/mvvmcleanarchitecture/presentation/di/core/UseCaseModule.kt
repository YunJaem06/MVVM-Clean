package com.example.mvvmcleanarchitecture.presentation.di.core

import com.example.mvvmcleanarchitecture.domain.repository.ArtistRepository
import com.example.mvvmcleanarchitecture.domain.repository.MovieRepository
import com.example.mvvmcleanarchitecture.domain.repository.TvShowRepository
import com.example.mvvmcleanarchitecture.domain.usecase.GetArtistUseCase
import com.example.mvvmcleanarchitecture.domain.usecase.GetMoviesUseCase
import com.example.mvvmcleanarchitecture.domain.usecase.GetTvShowUseCase
import com.example.mvvmcleanarchitecture.domain.usecase.UpdateArtistUseCase
import com.example.mvvmcleanarchitecture.domain.usecase.UpdateMoviesUseCase
import com.example.mvvmcleanarchitecture.domain.usecase.UpdateTvShowUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideGetMovieUseCase(movieRepository: MovieRepository): GetMoviesUseCase {
        return GetMoviesUseCase(movieRepository)
    }
    @Provides
    fun provideUpdateMovieUseCase(movieRepository: MovieRepository): UpdateMoviesUseCase {
        return UpdateMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideGetTvShowUseCase(tvShowRepository: TvShowRepository): GetTvShowUseCase {
        return GetTvShowUseCase(tvShowRepository)
    }
    @Provides
    fun provideUpdateTvShowUseCase(tvShowRepository: TvShowRepository): UpdateTvShowUseCase {
        return UpdateTvShowUseCase(tvShowRepository)
    }

    @Provides
    fun provideGetArtistUseCase(artistRepository: ArtistRepository): GetArtistUseCase {
        return GetArtistUseCase(artistRepository)
    }
    @Provides
    fun provideUpdateArtistUseCase(artistRepository: ArtistRepository): UpdateArtistUseCase {
        return UpdateArtistUseCase(artistRepository)
    }

}