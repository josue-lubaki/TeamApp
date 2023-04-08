package ca.josue_lubaki.teamapp.domain.usecases.get_all_users

import ca.josue_lubaki.teamapp.domain.models.UserStatus
import ca.josue_lubaki.teamapp.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow

/**
 * created by Josue Lubaki
 * date : 2023-04-07
 * version : 1.0.0
 */

class GetUsersUseCase(
    private val repository: UserRepository
) {
    suspend operator fun invoke() : Flow<UserStatus> = repository.getAllUsers()
}