package ca.josue_lubaki.teamapp.data.repository

import ca.josue_lubaki.teamapp.data.datasource.UserDataSource
import ca.josue_lubaki.teamapp.data.mapper.toDomain
import ca.josue_lubaki.teamapp.domain.models.UserEntity
import ca.josue_lubaki.teamapp.domain.repository.UserRepository
import javax.inject.Inject

/**
 * created by Josue Lubaki
 * date : 2023-04-07
 * version : 1.0.0
 */

class UserRepositoryImpl @Inject constructor(
    private val datasource: UserDataSource
) : UserRepository {
    override fun getAllUsers(): List<UserEntity> {
        return datasource.getAllUsers().map { it.toDomain() }
    }
}