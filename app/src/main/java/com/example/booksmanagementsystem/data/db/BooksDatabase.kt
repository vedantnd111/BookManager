package com.example.booksmanagementsystem.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.booksmanagementsystem.data.db.entities.Book

@Database(entities = [Book::class], version = 4)
abstract class BooksDatabase: RoomDatabase() {

    abstract fun bookDao():BooksDao

    companion object {

        @Volatile
        private var instance: BooksDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also { instance = it }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(context, BooksDatabase::class.java, "books.db").build()
    }
}
