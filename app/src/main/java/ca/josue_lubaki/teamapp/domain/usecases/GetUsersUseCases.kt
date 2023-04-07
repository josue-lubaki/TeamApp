package ca.josue_lubaki.teamapp.domain.usecases

import ca.josue_lubaki.teamapp.domain.repository.UserRepository

/**
 * created by Josue Lubaki
 * date : 2023-04-07
 * version : 1.0.0
 */

class GetUsersUseCases(
    private val repository: UserRepository
) {
    operator fun invoke() = repository.getAllUsers()
}