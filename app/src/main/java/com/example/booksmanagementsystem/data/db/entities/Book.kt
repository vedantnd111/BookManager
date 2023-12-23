package com.example.booksmanagementsystem.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "book_list")
data class Book(
    @ColumnInfo(name = "bookName") var name: String,
    @ColumnInfo(name = "bookAuthor") var author: String,
    @ColumnInfo(name = "bookDescription") var description: String,
    @ColumnInfo(name = "bookCategory") var category: String,
    @ColumnInfo(name = "bookImage") var image: String? = null,
    @ColumnInfo(name = "bookLearnings") var learnings: String? = null
) {

    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}
