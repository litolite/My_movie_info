package com.deathtospies.mymovieinfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import com.deathtospies.mymovieinfo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), FragmentMoviesDetailsClickListener {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            val transaction = supportFragmentManager.beginTransaction()
            val moviesList = FragmentMoviesList.newInstance()
            transaction
                .addToBackStack(null)
                .add(R.id.fragment_container, moviesList, "moviesList")
                .commit()

        }
    }

    override fun OnMovieClicked() {
        findViewById<FrameLayout>(R.id.fragment_container)

            val transaction = supportFragmentManager.beginTransaction()
            val moviesDetails = FragmentMoviesDetails.newInstance()
            transaction
                .addToBackStack(null)
                .replace(R.id.fragment_container, moviesDetails, "movieDetails")
                .commit()

    }


}