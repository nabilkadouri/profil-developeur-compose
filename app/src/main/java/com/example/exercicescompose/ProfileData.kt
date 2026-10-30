package com.example.exercicescompose

val fakeProfiles = listOf(
    Profile(
        fullName = "Léa Martin",
        job = "Développeuse Android",
        description = "Passionnée par les applis mobiles, j'aime créer des interfaces simples et agréables.",
        skills = listOf("Kotlin", "Jetpack Compose", "Git"),
        isAvailable = true
    ),
    Profile(
        fullName = "Tom Bernard",
        job = "Designer UX/UI",
        description = "Je dessine des écrans clairs et je teste mes idées auprès des utilisateurs.",
        skills = listOf("Figma", "Prototypage", "Accessibilité"),
        isAvailable = false
    )
)