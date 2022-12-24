package com.teguhmuflih.netflixcloneapps.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.GridView
import androidx.compose.material.icons.rounded.ViewList
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
    onBack: (() -> Unit)? = null,
    onViewChange: ((isGrid: Boolean) -> Unit)? = null,
    isTransparent: Boolean = false,
    modifier: Modifier = Modifier
) {

    var isGrid by remember {
        mutableStateOf(false)
    }
    CenterAlignedTopAppBar(
        modifier = modifier,
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = if (isTransparent == true) Color.Transparent else MaterialTheme.colorScheme.surface
        ),
        title = {
            Image(
                painter = painterResource(id = imageResourceId),
                contentDescription = stringResource(
                    id = R.string.app_bar_image
                ),
                modifier = Modifier.height(35.dp)
            )
        },
        navigationIcon = {
            if (onBack != null) IconButton(onClick = { onBack() }) {
                Icon(
                    imageVector = Icons.Rounded.ArrowBack, contentDescription = "",
                    tint = if (isTransparent) Color.White else Color.Black
                )
            }
        },
        actions = {
            if (onViewChange != null) IconButton(onClick = {
                isGrid = !isGrid
                onViewChange(isGrid)
            }) {
                Icon(
                    imageVector = if (isGrid) Icons.Rounded.GridView else Icons.Rounded.ViewList,
                    contentDescription = "",
                    tint = if (isTransparent) Color.White else Color.Black
                )
            }
        })
}

@ExperimentalMaterial3Api
@Preview
@Composable
fun MovieAppBarPreview() {
    NetflixCloneAppsTheme {
        MovieAppBar(
        )
    }
}