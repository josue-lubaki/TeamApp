package ca.josue_lubaki.teamapp.data.datasource

import ca.josue_lubaki.teamapp.domain.models.UserStatus
import kotlinx.coroutines.flow.Flow

/**
 * created by Josue Lubaki
 * date : 2023-04-07
 * version : 1.0.0
 */

interface UserDataSource {
    suspend fun getAllUsers(): Flow<UserStatus>
    suspend fun getUserById(userId: Int): Flow<UserStatus>
}