package com.example.mvvmcleanarchitecture.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.mvvmcleanarchitecture.R
import com.example.mvvmcleanarchitecture.databinding.ActivityHomeBinding
import com.example.mvvmcleanarchitecture.presentation.movie.MovieActivity
import com.example.mvvmcleanarchitecture.presentation.artist.ArtistActivity
import com.example.mvvmcleanarchitecture.presentation.tv.TvShowActivity

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        binding.movieButton.setOnClickListener {
            val intent = Intent(this, MovieActivity::class.java)
            startActivity(intent)
        }

        binding.artistButton.setOnClickListener {
            val intent = Intent(this, ArtistActivity::class.java)
            startActivity(intent)
        }

        binding.tvButton.setOnClickListener {
            val intent = Intent(this, TvShowActivity::class.java)
            startActivity(intent)
        }
    }
}