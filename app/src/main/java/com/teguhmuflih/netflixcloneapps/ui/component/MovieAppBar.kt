package com.teguhmuflih.netflixcloneapps.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.teguhmuflih.netflixcloneapps.R
import com.teguhmuflih.netflixcloneapps.ui.theme.NetflixCloneAppsTheme

@ExperimentalMaterial3Api
@Composable
fun MovieAppBar(
    imageResourceId: Int = R.drawable.ic_netflix,
    modifier: Modifier = Modifier
) {
    CenterAlignedTopAppBar(
        modifier = modifier,
        title = {
            Image(
                painter = painterResource(id = imageResourceId),
                contentDescription = stringResource(
                    id = R.string.app_bar_image
                ),
                modifier = Modifier.height(40.dp)
            )
        })
}

@ExperimentalMaterial3Api
@Preview
@Composable
fun MovieAppBarPreview() {
    NetflixCloneAppsTheme {
        MovieAppBar()
    }
}