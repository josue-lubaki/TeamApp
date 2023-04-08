package ca.josue_lubaki.teamapp.di

import ca.josue_lubaki.teamapp.data.datasource.UserDataSource
import ca.josue_lubaki.teamapp.data.datasource.datasourceimpl.MockUserDatasource
import ca.josue_lubaki.teamapp.data.repository.UserRepositoryImpl
import ca.josue_lubaki.teamapp.domain.repository.UserRepository
import ca.josue_lubaki.teamapp.domain.usecases.UserUseCases
import ca.josue_lubaki.teamapp.domain.usecases.get_all_users.GetUsersUseCase
import ca.josue_lubaki.teamapp.domain.usecases.get_user_by_id.GetUserByIdUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideCoroutineDispatcher(): CoroutineDispatcher = Dispatchers.IO

    @Singleton
    @Provides
    fun provideUserDataSource(dispatchers : CoroutineDispatcher) : UserDataSource {
        return MockUserDatasource(dispatchers = dispatchers)
    }

    @Singleton
    @Provides
    fun provideUserRepository(datasource : UserDataSource) : UserRepository {
        return UserRepositoryImpl(datasource = datasource)
    }

    @Singleton
    @Provides
    fun provideGetUsersUseCases(repository: UserRepository) : GetUsersUseCase {
        return GetUsersUseCase(repository = repository)
    }

    @Singleton
    @Provides
    fun provideGetUserByIdUseCases(repository: UserRepository) : GetUserByIdUseCase {
        return GetUserByIdUseCase(repository = repository)
    }

    @Singleton
    @Provides
    fun provideUserUseCases(
        getUsersUseCase: GetUsersUseCase,
        getUserByIdUseCase: GetUserByIdUseCase
    ) : UserUseCases {
        return UserUseCases(
            getUsersUseCase = getUsersUseCase,
            getUserByIdUseCase = getUserByIdUseCase
        )
    }
}