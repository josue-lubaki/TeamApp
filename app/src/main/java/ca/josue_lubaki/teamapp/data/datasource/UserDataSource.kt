package ca.josue_lubaki.teamapp.data.datasource

import ca.josue_lubaki.teamapp.data.models.User

/**
 * created by Josue Lubaki
 * date : 2023-04-07
 * version : 1.0.0
 */

interface UserDataSource {
    fun getAllUsers(): List<User>
}