package ca.josue_lubaki.teamapp.di

import ca.josue_lubaki.teamapp.data.datasource.UserDataSource
import ca.josue_lubaki.teamapp.data.datasourceimpl.MockUserDatasource
import ca.josue_lubaki.teamapp.data.repository.UserRepositoryImpl
import ca.josue_lubaki.teamapp.domain.repository.UserRepository
import ca.josue_lubaki.teamapp.domain.usecases.GetUsersUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideUserDataSource() : UserDataSource {
        return MockUserDatasource()
    }

    @Singleton
    @Provides
    fun provideUserRepository(datasource : UserDataSource) : UserRepository {
        return UserRepositoryImpl(datasource = datasource)
    }

    @Singleton
    @Provides
    fun provideGetUsersUseCases(repository: UserRepository) : GetUsersUseCases {
        return GetUsersUseCases(repository = repository)
    }
}