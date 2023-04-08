package ca.josue_lubaki.teamapp.presentation.screens.details

import ca.josue_lubaki.teamapp.domain.models.UserEntity

/**
 * created by Josue Lubaki
 * date : 2023-04-08
 * version : 1.0.0
 */
sealed class DetailsState {
    object Idle : DetailsState()
    object Loading : DetailsState()
    data class Success(val user: UserEntity?) : DetailsState()
    data class Error(val exception: Exception) : DetailsState()
}
