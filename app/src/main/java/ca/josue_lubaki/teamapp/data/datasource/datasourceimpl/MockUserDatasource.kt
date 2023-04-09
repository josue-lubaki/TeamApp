package ca.josue_lubaki.teamapp.data.datasource.datasourceimpl

import ca.josue_lubaki.teamapp.data.datasource.UserDataSource
import ca.josue_lubaki.teamapp.data.db.local.mockData
import ca.josue_lubaki.teamapp.data.mapper.toDomain
import ca.josue_lubaki.teamapp.domain.models.UserStatus
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import java.lang.Thread.sleep
import javax.inject.Inject

/**
 * created by Josue Lubaki
 * date : 2023-04-07
 * version : 1.0.0
 */

class MockUserDatasource @Inject constructor(
    private val dispatchers: CoroutineDispatcher
) : UserDataSource {
    override suspend fun getAllUsers(): Flow<UserStatus> {
        return flowOf(
            UserStatus.Success(
                users = mockData.map { it.toDomain() }
            )
        ).flowOn(dispatchers)
    }

    override suspend fun getUserById(userId: Int): Flow<UserStatus> {
        return flowOf(
            UserStatus.Success(
                users = mockData.filter { it.id == userId }.map { it.toDomain() }
            )
        ).flowOn(dispatchers)
    }
}