package com.example.mvvmcleanarchitecture.domain.usecase

import com.example.mvvmcleanarchitecture.data.model.artist.Artist
import com.example.mvvmcleanarchitecture.domain.repository.ArtistRepository

class UpdateArtistUseCase(private val artistRepository: ArtistRepository) {

    suspend fun execute(): List<Artist>? = artistRepository.updateArtists()

}