package ca.josue_lubaki.teamapp.data.datasourceimpl

import ca.josue_lubaki.teamapp.data.datasource.UserDataSource
import ca.josue_lubaki.teamapp.data.db.local.mockData
import ca.josue_lubaki.teamapp.data.models.User

/**
 * created by Josue Lubaki
 * date : 2023-04-07
 * version : 1.0.0
 */

class MockUserDatasource : UserDataSource {
    override fun getAllUsers(): List<User> = mockData
}