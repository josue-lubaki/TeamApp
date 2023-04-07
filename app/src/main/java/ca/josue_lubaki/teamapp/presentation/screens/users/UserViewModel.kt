package ca.josue_lubaki.teamapp.presentation.screens.users

import androidx.lifecycle.ViewModel
import ca.josue_lubaki.teamapp.domain.models.UserEntity
import ca.josue_lubaki.teamapp.domain.usecases.GetUsersUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * created by Josue Lubaki
 * date : 2023-04-07
 * version : 1.0.0
 */

@HiltViewModel
class UserViewModel @Inject constructor(
    useCases : GetUsersUseCases
) : ViewModel() {

    private val _users = useCases()
    val users : List<UserEntity> = _users
}