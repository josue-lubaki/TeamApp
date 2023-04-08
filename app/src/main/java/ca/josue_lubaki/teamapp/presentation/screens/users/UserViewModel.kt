package ca.josue_lubaki.teamapp.presentation.screens.users

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ca.josue_lubaki.teamapp.domain.models.UserEntity
import ca.josue_lubaki.teamapp.domain.models.UserStatus
import ca.josue_lubaki.teamapp.domain.usecases.UserUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * created by Josue Lubaki
 * date : 2023-04-07
 * version : 1.0.0
 */

@HiltViewModel
class UserViewModel @Inject constructor(
    private val userUseCases : UserUseCases,
    private val dispatchers : CoroutineDispatcher
) : ViewModel() {

    private val _state = MutableStateFlow<UserState>(UserState.Idle)
    val state : StateFlow<UserState> = _state.asStateFlow()

    private sealed class UserAction {
        object GetUsers : UserAction()
        data class GetUsersSuccess(val users: List<UserEntity>) : UserAction()
        data class GetUsersError(val exception: Exception) : UserAction()
    }

    private fun dispatch(action : UserAction) {
        when(action) {
            is UserAction.GetUsers -> action.reduce()
            is UserAction.GetUsersSuccess -> action.reduce()
            is UserAction.GetUsersError -> action.reduce()
        }
    }

    private fun UserAction.GetUsers.reduce() {
        _state.value = UserState.Loading
        viewModelScope.launch(dispatchers) {
            userUseCases.getAllUsers().collect {
                when(it) {
                    is UserStatus.Success -> dispatch(UserAction.GetUsersSuccess(it.users))
                    is UserStatus.Error -> dispatch(UserAction.GetUsersError(it.exception))
                }
            }
        }
    }

    private fun UserAction.GetUsersSuccess.reduce() {
        _state.value = UserState.Success(users)
    }

    private fun UserAction.GetUsersError.reduce() {
        _state.value = UserState.Error(exception)
    }

    fun onGetUsers() {
        dispatch(UserAction.GetUsers)
    }
}