package ca.josue_lubaki.teamapp.domain.repository

import ca.josue_lubaki.teamapp.domain.models.UserEntity

/**
 * created by Josue Lubaki
 * date : 2023-04-07
 * version : 1.0.0
 */

interface UserRepository {
    fun getAllUsers(): List<UserEntity>
}