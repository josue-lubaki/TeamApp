package ca.josue_lubaki.teamapp.data.models

import ca.josue_lubaki.teamapp.data.db.local.Profession
data class User (
    val id: Int,
    val fullName: String,
    val imageURL: String,
    val profession: Profession,
)
