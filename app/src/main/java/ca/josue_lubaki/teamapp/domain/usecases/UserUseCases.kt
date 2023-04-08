package ca.josue_lubaki.teamapp.domain.usecases

import ca.josue_lubaki.teamapp.domain.usecases.get_all_users.GetUsersUseCase
import ca.josue_lubaki.teamapp.domain.usecases.get_user_by_id.GetUserByIdUseCase

/**
 * created by Josue Lubaki
 * date : 2023-04-08
 * version : 1.0.0
 */

class UserUseCases(
    private val getUsersUseCase: GetUsersUseCase,
    private val getUserByIdUseCase: GetUserByIdUseCase
) {
    suspend fun getAllUsers() = getUsersUseCase()
    suspend fun getUserById(userId: Int) = getUserByIdUseCase(userId)
}