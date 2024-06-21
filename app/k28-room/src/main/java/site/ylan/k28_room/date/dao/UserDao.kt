package site.ylan.k28_room.date.dao

import androidx.room.*
import site.ylan.k28_room.date.model.User

@Dao
interface UserDao {

    @Insert
    fun insertUser(user: User): Long

    @Delete
    fun deleteUser(user: User)

    @Update
    fun updateUser(newUser: User)

    @Query("select * from User")
    fun loadAllUsers(): List<User>

    @Query("select * from User where age > :age")
    fun loadUsersOlderThan(age: Int): List<User>

    @Query("delete from User where lastName = :lastName")
    fun deleteUserByLastName(lastName: String): Int

}