package ca.josue_lubaki.teamapp.presentation.screens.details

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
class DetailsViewModel @Inject constructor(
    private val userUseCases : UserUseCases,
    private val dispatchers : CoroutineDispatcher
) : ViewModel() {

    private val _state = MutableStateFlow<DetailsState>(DetailsState.Idle)
    val state : StateFlow<DetailsState> = _state.asStateFlow()

    private sealed class DetailsAction {
        data class GetUserById(val userId : Int) : DetailsAction()
        data class GetUserByIdSuccess(val user: UserEntity?) : DetailsAction()
        data class GetUserByIdError(val exception: Exception) : DetailsAction()
    }

    private fun dispatch(action : DetailsAction) {
        when(action) {
            is DetailsAction.GetUserById -> action.reduce()
            is DetailsAction.GetUserByIdSuccess -> action.reduce()
            is DetailsAction.GetUserByIdError -> action.reduce()
        }
    }

    private fun DetailsAction.GetUserById.reduce() {
        _state.value = DetailsState.Loading
        viewModelScope.launch(dispatchers) {
            userUseCases.getUserById(userId).collect {
                when(it) {
                    is UserStatus.Success -> dispatch(DetailsAction.GetUserByIdSuccess(it.users.firstOrNull()))
                    is UserStatus.Error -> dispatch(DetailsAction.GetUserByIdError(it.exception))
                }
            }
        }
    }

    private fun DetailsAction.GetUserByIdSuccess.reduce() {
        _state.value = DetailsState.Success(user)
    }

    private fun DetailsAction.GetUserByIdError.reduce() {
        _state.value = DetailsState.Error(exception)
    }

    fun onGetUserById(userId: Int) {
        dispatch(DetailsAction.GetUserById(userId))
    }
}