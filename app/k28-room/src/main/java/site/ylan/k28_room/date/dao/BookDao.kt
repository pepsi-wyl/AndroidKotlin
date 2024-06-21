package site.ylan.k28_room.date.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import site.ylan.k28_room.date.model.Book

@Dao
interface BookDao {
    @Insert
    fun insertBook(book: Book): Long

    @Query("select * from Book")
    fun loadAllBooks(): List<Book>
}