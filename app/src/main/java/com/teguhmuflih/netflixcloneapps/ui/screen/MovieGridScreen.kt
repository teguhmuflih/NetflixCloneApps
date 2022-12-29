package com.teguhmuflih.netflixcloneapps.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.teguhmuflih.netflixcloneapps.data.MovieDatasource
import com.teguhmuflih.netflixcloneapps.domain.model.movie.Movie
import com.teguhmuflih.netflixcloneapps.ui.component.MovieItem

@ExperimentalMaterial3Api
@Composable
fun MovieGridScreen(
    paddingValues: PaddingValues, movies: List<Movie>,
) {
    val movies: List<Movie> by rememberSaveable {
        mutableStateOf(MovieDatasource.getNowPlayingMovie())
    }
    //COMPOSITION -> DRAW -> VIEW
    LazyVerticalGrid(
        modifier = Modifier.padding(paddingValues),
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(movies) { movie ->
            MovieItem(
                isGrid = false,
                movie = movie,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}

@ExperimentalMaterial3Api
@Preview
@Composable
private fun PreviewMovieList() {
    MovieGridScreen(paddingValues = PaddingValues(), MovieDatasource.getNowPlayingMovie())
}