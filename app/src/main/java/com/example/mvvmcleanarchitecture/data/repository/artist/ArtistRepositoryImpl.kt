package com.example.mvvmcleanarchitecture.data.repository.artist

import android.util.Log
import com.example.mvvmcleanarchitecture.data.model.artist.Artist
import com.example.mvvmcleanarchitecture.data.model.movie.Movie
import com.example.mvvmcleanarchitecture.data.repository.artist.datasource.ArtistCacheDataSource
import com.example.mvvmcleanarchitecture.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.mvvmcleanarchitecture.data.repository.artist.datasource.ArtistRemoteDataSource
import com.example.mvvmcleanarchitecture.domain.repository.ArtistRepository

class ArtistRepositoryImpl(
    private val artistRemoteDataSource : ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource
) : ArtistRepository {
    override suspend fun getArtists(): List<Artist>? {
        return getArtistsFromCache()
    }

    override suspend fun updateArtists(): List<Artist>? {
        val newListOfArtists = getArtistsFromAPI()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistToDB(newListOfArtists)
        artistCacheDataSource.saveArtistsToCache(newListOfArtists)
        return newListOfArtists
    }

    suspend fun getArtistsFromAPI():List<Artist> {
        lateinit var artistsList:List<Artist>
        try {
            val response = artistRemoteDataSource.getArtists()
            val body = response.body()
            if (body != null) {
                artistsList = body.results
            }
        }catch (e: Exception) {
            Log.d("myTag", e.message.toString())
        }
        return artistsList
    }

    suspend fun getArtistsFromDB():List<Artist> {
        lateinit var artistList:List<Artist>
        try {
            artistList = artistLocalDataSource.getArtistsFromDB()
        }catch (e: Exception) {
            Log.d("myTag", e.message.toString())
        }
        if (artistList.size > 0) {
            return artistList
        } else {
            artistList = getArtistsFromAPI()
            artistLocalDataSource.saveArtistToDB(artistList)
        }
        return artistList
    }

    suspend fun getArtistsFromCache():List<Artist> {
        lateinit var artistList:List<Artist>
        try {
            artistList = artistCacheDataSource.getArtistsFromCache()
        }catch (e: Exception) {
            Log.d("myTag", e.message.toString())
        }
        if (artistList.size > 0) {
            return artistList
        } else {
            artistList = getArtistsFromCache()
            artistCacheDataSource.saveArtistsToCache(artistList)
        }
        return artistList
    }
}