package com.example.mvvmcleanarchitecture.data.db

import android.graphics.Movie
import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mvvmcleanarchitecture.data.db.ArtistDao
import com.example.mvvmcleanarchitecture.data.db.MovieDao
import com.example.mvvmcleanarchitecture.data.db.TvShowDao
import com.example.mvvmcleanarchitecture.data.model.artist.Artist
import com.example.mvvmcleanarchitecture.data.model.tvshow.TvShow

@Database(entities = [Movie::class, TvShow::class, Artist::class],
version = 1,
exportSchema = false)
abstract class TMDBDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao
    abstract fun tvDao(): TvShowDao
    abstract fun artistDao(): ArtistDao
}