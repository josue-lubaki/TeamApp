package ca.josue_lubaki.teamapp.domain.models

import ca.josue_lubaki.teamapp.data.db.local.Profession

/**
 * created by Josue Lubaki
 * date : 2023-04-07
 * version : 1.0.0
 */

data class UserEntity (
    val id: Int,
    val fullName: String,
    val imageURL: String,
    val profession: Profession,
)

fun UserEntity?.orPlaceholder() : UserEntity {
    return this
        ?: UserEntity(
            id = -1,
            fullName = "",
            imageURL = "",
            profession = Profession.DEVELOPER_ANDROID
        )
}