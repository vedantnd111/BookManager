package com.example.booksmanagementsystem.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.booksmanagementsystem.data.db.entities.Book

@Dao
interface BooksDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrReplace(item: Book)

    @Query("UPDATE book_list SET bookLearnings = :bookLearnings WHERE id = :bookId")
    fun updateLearnings(bookId: Int, bookLearnings: String?)

    @Query("SELECT * FROM `book_list` WHERE id = :bookId")
    suspend fun getBook(bookId: Int): Book

    @Query("SELECT * FROM `book_list` GROUP BY bookCategory")
    fun getAllBooks(): LiveData<List<Book>>
}
