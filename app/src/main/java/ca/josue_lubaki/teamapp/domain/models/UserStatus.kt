package ca.josue_lubaki.teamapp.domain.models

import java.lang.Exception

sealed class UserStatus {
    data class Success(val users: List<UserEntity>) : UserStatus()
    data class Error(val exception: Exception) : UserStatus()
}
