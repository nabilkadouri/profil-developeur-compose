package com.example.exercicescompose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.exercicescompose.ui.theme.ExercicesComposeTheme

@Composable
fun AudioPlayerScreen(modifier: Modifier = Modifier) {
    AudioPlayerCard(
        title = "Imagine",
        artist = "John Lennon",
        isPlaying = false,
        onPlayClick = {
            println("Lecture !")
        },
        modifier = modifier
            .fillMaxWidth()
            .padding(24.dp)
    )
}

@Composable
fun AudioPlayerCard(
    title: String,
    artist: String,
    isPlaying: Boolean,
    onPlayClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        color = MaterialTheme.colorScheme.primaryContainer,
        shape = RoundedCornerShape(16.dp),
        modifier = modifier
    ) {
        AudioPlayerCardContent(
            title = title,
            artist = artist,
            isPlaying = isPlaying,
            onPlayClick = onPlayClick
        )
    }
}

@Composable
fun AudioPlayerCardContent(
    title: String,
    artist: String,
    isPlaying: Boolean,
    onPlayClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier
        .fillMaxWidth()
        .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AudioPlayerTitle(
            title = title,
        )
        AudioPlayerArtist(
            artist = artist,
        )
        AudioPlayerButton(
            isPlaying = isPlaying,
            onPlayClick = onPlayClick,
            modifier = Modifier
        )
    }
}

@Composable
fun AudioPlayerTitle(title : String, modifier: Modifier  = Modifier) {
    Text(
        text = title,
        fontSize = 22.sp,
        fontWeight = FontWeight.Bold,
        modifier = modifier
    )
}


@Composable
fun AudioPlayerArtist(artist: String, modifier: Modifier = Modifier) {
    Text(
        text = artist,
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium,
        modifier = modifier
    )

}

@Composable
fun AudioPlayerButton(isPlaying: Boolean, onPlayClick: () -> Unit, modifier: Modifier = Modifier) {
    FilledIconButton (onClick = onPlayClick, modifier = modifier) {
        Icon(
            painter = painterResource(
                if (isPlaying) R.drawable.ic_pause else R.drawable.ic_play
            ),
            contentDescription = if (isPlaying) "Pause" else "Lecture"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AudioPlayerScreenPreview() {
    ExercicesComposeTheme {
        AudioPlayerScreen()
    }
}