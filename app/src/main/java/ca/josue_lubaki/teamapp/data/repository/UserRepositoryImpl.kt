package ca.josue_lubaki.teamapp.data.repository

import ca.josue_lubaki.teamapp.data.datasource.UserDataSource
import ca.josue_lubaki.teamapp.domain.models.UserStatus
import ca.josue_lubaki.teamapp.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

/**
 * created by Josue Lubaki
 * date : 2023-04-07
 * version : 1.0.0
 */

class UserRepositoryImpl @Inject constructor(
    private val datasource: UserDataSource
) : UserRepository {
    override suspend fun getAllUsers(): Flow<UserStatus> {
        return try {
            datasource.getAllUsers()
        } catch (e: Exception) {
            flowOf(UserStatus.Error(e))
        }
    }

    override suspend fun getUserById(userId: Int): Flow<UserStatus> {
        return try {
            datasource.getUserById(userId)
        } catch (e: Exception) {
            flowOf(UserStatus.Error(e))
        }
    }
}