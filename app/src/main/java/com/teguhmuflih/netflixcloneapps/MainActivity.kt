package com.teguhmuflih.netflixcloneapps

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.teguhmuflih.netflixcloneapps.data.MovieDatasource
import com.teguhmuflih.netflixcloneapps.domain.model.movie.Movie
import com.teguhmuflih.netflixcloneapps.ui.component.MovieAppBar
import com.teguhmuflih.netflixcloneapps.ui.screen.MovieGridScreen
import com.teguhmuflih.netflixcloneapps.ui.screen.MovieListScreen
import com.teguhmuflih.netflixcloneapps.ui.theme.NetflixCloneAppsTheme

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NetflixCloneAppsTheme {
                NetflixCloneApp()
            }
        }
    }
}


@ExperimentalMaterial3Api
@Preview
@Composable
fun NetflixCloneApp() {
    val movies: List<Movie> by rememberSaveable {
        mutableStateOf(MovieDatasource.getNowPlayingMovie())
    }

    var isGrid by remember { mutableStateOf(false) }
    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = {
            MovieAppBar(
                onViewChange = { isGrid = it }
            )
        }) { contentPadding ->
        if (isGrid) MovieGridScreen(paddingValues = contentPadding, movies = movies)
        else MovieListScreen(contentPadding, movies)
    }
}