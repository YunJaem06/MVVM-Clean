package com.example.mvvmcleanarchitecture.presentation

import android.app.Application
import com.example.mvvmcleanarchitecture.BuildConfig
import com.example.mvvmcleanarchitecture.presentation.di.Injector
import com.example.mvvmcleanarchitecture.presentation.di.artist.ArtistSubComponent
import com.example.mvvmcleanarchitecture.presentation.di.core.AppComponent
import com.example.mvvmcleanarchitecture.presentation.di.core.AppModule
import com.example.mvvmcleanarchitecture.presentation.di.core.DaggerAppComponent
import com.example.mvvmcleanarchitecture.presentation.di.core.NetModule
import com.example.mvvmcleanarchitecture.presentation.di.core.RemoteDataModule
import com.example.mvvmcleanarchitecture.presentation.di.movie.MovieSubComponent
import com.example.mvvmcleanarchitecture.presentation.di.tvshow.TvShowSubComponent

class MyApplication : Application(), Injector {

    private lateinit var appComponent: AppComponent
    
    // 버젼 올리는 작업필요
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.TMDB_API_KEY))
            .build()

    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createTvShowSubComponent(): TvShowSubComponent {
        return appComponent.tvShowSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
        return appComponent.artistSubComponent().create()
    }
}