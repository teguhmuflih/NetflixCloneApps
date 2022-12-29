package com.teguhmuflih.netflixcloneapps

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import com.teguhmuflih.netflixcloneapps.domain.model.movie.Movie
import com.teguhmuflih.netflixcloneapps.ui.screen.MovieDetailScreen
import com.teguhmuflih.netflixcloneapps.ui.theme.NetflixCloneAppsTheme

@ExperimentalMaterial3Api
class DetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        intent.extras?.getParcelable<Movie>(EXTRA_MOVIE)?.let { movie ->
            setContent {
                NetflixCloneAppsTheme {
                    MovieDetailScreen(movie = movie) {
                        finish()
                    }
                }
            }
        }
    }

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }
}
