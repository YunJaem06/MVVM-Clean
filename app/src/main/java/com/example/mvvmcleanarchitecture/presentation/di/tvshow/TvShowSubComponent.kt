package com.example.mvvmcleanarchitecture.presentation.di.tvshow

import com.example.mvvmcleanarchitecture.presentation.artist.ArtistActivity
import dagger.Subcomponent

@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent {

    fun inject(artistActivity: ArtistActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create():TvShowSubComponent
    }
}