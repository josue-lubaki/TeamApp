package ca.josue_lubaki.teamapp.presentation.screens.details

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
class DetailsViewModel @Inject constructor(
    useCases : GetUsersUseCases
) : ViewModel() {

    private val _users = useCases()

    fun onGetUserById(id: Int): UserEntity {
        return _users.first { it.id == id }
    }
}