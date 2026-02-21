package com.example.mvvmcleanarchitecture.presentation.di.movie

import com.example.mvvmcleanarchitecture.presentation.artist.ArtistActivity
import com.example.mvvmcleanarchitecture.presentation.movie.MovieActivity
import dagger.Subcomponent

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {

    fun inject(movieActivity: MovieActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create():MovieSubComponent
    }
}