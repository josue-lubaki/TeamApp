package ca.josue_lubaki.teamapp.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import ca.josue_lubaki.teamapp.presentation.screens.details.DetailScreenContainer
import ca.josue_lubaki.teamapp.presentation.screens.details.DetailsViewModel
import ca.josue_lubaki.teamapp.presentation.screens.users.UserScreenContainer
import ca.josue_lubaki.teamapp.presentation.screens.users.UserViewModel
import ca.josue_lubaki.teamapp.utils.Constants.USER_ID_ARGUMENT_KEY

/**
 * created by Josue Lubaki
 * date : 2023-04-07
 * version : 1.0.0
 */

@Composable
fun SetupGraphNavigation(
    navController: NavHostController,
    userViewModel: UserViewModel = hiltViewModel(),
    detailsViewModel: DetailsViewModel = hiltViewModel()
) {
    NavHost(
        navController = navController,
        startDestination = ScreenTarget.Users.route
    ) {
        composable(route = ScreenTarget.Users.route) {
            UserScreenContainer(
                viewModel = userViewModel,
                onSelected = { id ->
                    navController.navigate(ScreenTarget.Details.passArgs(id))
                }
            )
        }

        composable(
            route = ScreenTarget.Details.route,
            arguments = listOf(navArgument(USER_ID_ARGUMENT_KEY) { type = NavType.IntType })
        ){ navBackStackEntry ->
            val userId = navBackStackEntry.arguments?.getInt(USER_ID_ARGUMENT_KEY) ?: -1
            DetailScreenContainer(
                id = userId,
                viewModel = detailsViewModel,
                onBackPressed = { navController.navigateUp() }
            )
        }
    }
}