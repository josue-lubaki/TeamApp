package ca.josue_lubaki.teamapp.data.mapper

import ca.josue_lubaki.teamapp.data.models.User
import ca.josue_lubaki.teamapp.domain.models.UserEntity

/**
 * created by Josue Lubaki
 * date : 2023-04-07
 * version : 1.0.0
 */

fun User.toDomain(): UserEntity {
    return UserEntity(
        id = this.id,
        fullName = this.fullName,
        imageURL = this.imageURL,
        profession = this.profession
    )
}