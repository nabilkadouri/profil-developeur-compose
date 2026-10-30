package com.example.exercicescompose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.exercicescompose.ui.theme.ExercicesComposeTheme

// Représente l'écran principal
@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    profile: Profile = fakeProfiles[0]
) {
    ProfileCard(
        profile = profile,
        onPortfolioClick = { /* Plus tard : suivre ce profil */ },
        onAvailabilityClick = { /* Plus tard : envoyer un message */ },
        modifier = modifier
            .fillMaxWidth()
            .padding(24.dp) // padding EXTERNE : le parent écarte la carte des bords de l'écran
    )
}

// Représente la carte (son fond coloré)
@Composable
fun ProfileCard(
    profile: Profile,
    onPortfolioClick: () -> Unit,
    onAvailabilityClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        color = Color(0xFF6750A4).copy(alpha = 0.25f),
        shape = RoundedCornerShape(8.dp),
        modifier = modifier
    ) {
        ProfileCardContent(
            profile = profile,
            onPortfolioClick = onPortfolioClick,
            onAvailabilityClick = onAvailabilityClick
        )
    }
}

// Représente le contenu global de la carte
@Composable
fun ProfileCardContent(
    profile: Profile,
    onPortfolioClick: () -> Unit,
    onAvailabilityClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ProfileFullName(fullName = profile.fullName)
        ProfileJob(job = profile.job)
        ProfileDescription(description = profile.description)
        ProfileSkills(skills = profile.skills)
        ProfileAvailability(
            isAvailable = profile.isAvailable,
            onAvailabilityClick = onAvailabilityClick
        )
        ProfilePortfolioButton(onPortfolioClick = onPortfolioClick)
    }
}


@Composable
fun ProfileFullName(fullName: String, modifier: Modifier = Modifier) {
    Text(
        text = fullName,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        modifier = modifier
    )
}

@Composable
fun ProfileJob(job: String, modifier: Modifier = Modifier) {
    Text(
        text = job,
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium,
        modifier = modifier
    )
}



@Composable
fun ProfileDescription(description: String, modifier: Modifier = Modifier) {
    Text(
        text = description,
        fontSize = 14.sp,
        textAlign = TextAlign.Center,
        modifier = modifier
    )
}

@Composable
fun ProfileSkills(skills: List<String>, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Compétences", fontWeight = FontWeight.Bold)
        skills.forEach { skill ->
            SkillItem(skill = skill)
        }
    }
}

@Composable
fun SkillItem(skill: String, modifier: Modifier = Modifier) {
    Text(
        text = "- $skill",
        fontSize = 14.sp,
        modifier = modifier
    )
}

// Zone cliquable pour disponible ou indisponible  avec semantics pour TalkBack
@Composable
fun ProfileAvailability(
    isAvailable: Boolean,
    onAvailabilityClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val text = if (isAvailable) "Disponible · Me contacter" else "Indisponible"
    Text(
        text = text,
        color = Color(0xFF6750A4),
        fontWeight = FontWeight.Medium,
        modifier = modifier
            .clickable(onClick = onAvailabilityClick)
            .semantics {
                role = Role.Button
                contentDescription = "$text. Appuyer pour envoyer un message"
            }
            .padding(8.dp)
    )
}

@Composable
fun ProfilePortfolioButton(
    onPortfolioClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onPortfolioClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF6750A4),
            contentColor = Color.White
        ),
        shape = RoundedCornerShape(8.dp),
        modifier = modifier
    ) {
        Text(text = "Voir mon portfolio", fontWeight = FontWeight.Bold)
    }
}

@Preview(showBackground = true, name = "Android junior disponible")
@Composable
fun ProfileJuniorPreview() {
    ExercicesComposeTheme {
        ProfileScreen(profile = fakeProfiles[0])
    }
}

@Preview(showBackground = true, name = "Full-stack indisponible")
@Composable
fun ProfileFullStackPreview() {
    ExercicesComposeTheme {
        ProfileScreen(profile = fakeProfiles[1])
    }
}
