package com.example.exercicescompose

data class Profile(
    val fullName: String,      // f minuscule
    val job: String,
    val description: String,
    val skills: List<String>,
    val isAvailable: Boolean   // "is" = oui ou non
)