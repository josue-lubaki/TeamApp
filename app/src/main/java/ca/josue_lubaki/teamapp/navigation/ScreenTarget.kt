package ca.josue_lubaki.teamapp.navigation

import ca.josue_lubaki.teamapp.utils.Constants.USER_ID_ARGUMENT_KEY

sealed class ScreenTarget(
    val route: String
) {
    object Users : ScreenTarget("users")
    object Details : ScreenTarget("details/{$USER_ID_ARGUMENT_KEY}"){
        fun passArgs(userId: Int) = "details/$userId"
    }
}

