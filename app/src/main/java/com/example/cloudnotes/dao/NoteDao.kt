package com.example.cloudnotes.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.cloudnotes.entities.Notes
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Query("SELECT * FROM notes ORDER BY id DESC")
    fun getAllNotes(): Flow<List<Notes>>

    @Query("SELECT * FROM notes WHERE id=:id")
    fun getSpecificNote(id:Int): Notes

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNotes(note: Notes)

    @Delete
    fun deleteNote(note: Notes)

    @Query("DELETE FROM notes WHERE id=:id")
    fun deleteSpecificNote(id:Int)

    @Update
    fun updateNote(note: Notes)
}