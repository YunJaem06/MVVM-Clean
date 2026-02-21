package com.example.mvvmcleanarchitecture.presentation.di

import com.example.mvvmcleanarchitecture.presentation.di.artist.ArtistSubComponent
import com.example.mvvmcleanarchitecture.presentation.di.movie.MovieSubComponent
import com.example.mvvmcleanarchitecture.presentation.di.tvshow.TvShowSubComponent

interface Injector {
    fun createMovieSubComponent(): MovieSubComponent
    fun createTvShowSubComponent(): TvShowSubComponent
    fun createArtistSubComponent(): ArtistSubComponent
}