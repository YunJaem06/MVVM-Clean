package com.example.mvvmcleanarchitecture.domain.repository

import com.example.mvvmcleanarchitecture.data.model.artist.Artist

interface ArtistRepository {

    suspend fun getArtists(): List<Artist>?

    suspend fun updateArtists(): List<Artist>?
}