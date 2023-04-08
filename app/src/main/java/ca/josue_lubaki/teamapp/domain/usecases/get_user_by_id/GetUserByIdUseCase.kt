package ca.josue_lubaki.teamapp.domain.usecases.get_user_by_id

import ca.josue_lubaki.teamapp.domain.repository.UserRepository

/**
 * created by Josue Lubaki
 * date : 2023-04-08
 * version : 1.0.0
 */

class GetUserByIdUseCase(
    private val repository: UserRepository
) {
    suspend operator fun invoke(userId: Int) = repository.getUserById(userId)
}