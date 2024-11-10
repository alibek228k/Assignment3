package kz.alibek.assignment3

import androidx.lifecycle.LiveData
import kz.alibek.assignment3.model.User
import kz.alibek.assignment3.model.UserDao

class UserRepository(private val userDao: UserDao) {
    val allUsers: LiveData<List<User>> = userDao.getAllUsers()

    suspend fun insert(user: User) {
        userDao.insert(user)
    }

    suspend fun delete(user: User) {
        userDao.delete(user)
    }
}