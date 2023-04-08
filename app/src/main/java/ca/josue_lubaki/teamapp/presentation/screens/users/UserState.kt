package ca.josue_lubaki.teamapp.presentation.screens.users

import ca.josue_lubaki.teamapp.domain.models.UserEntity

/**
 * created by Josue Lubaki
 * date : 2023-04-08
 * version : 1.0.0
 */
sealed class UserState {
    object Idle : UserState()
    object Loading : UserState()
    data class Success(val users: List<UserEntity>) : UserState()
    data class Error(val exception: Exception) : UserState()
}
