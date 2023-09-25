package com.example.cloudnotes.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\'J\u0014\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000b0\nH\'J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\'J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'\u00a8\u0006\u000f"}, d2 = {"Lcom/example/cloudnotes/dao/NoteDao;", "", "deleteNote", "", "note", "Lcom/example/cloudnotes/entities/Notes;", "deleteSpecificNote", "id", "", "getAllNotes", "Lkotlinx/coroutines/flow/Flow;", "", "getSpecificNote", "insertNotes", "updateNote", "app_debug"})
@androidx.room.Dao
public abstract interface NoteDao {
    
    @androidx.room.Query(value = "SELECT * FROM notes ORDER BY id DESC")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.cloudnotes.entities.Notes>> getAllNotes();
    
    @androidx.room.Query(value = "SELECT * FROM notes WHERE id=:id")
    @org.jetbrains.annotations.NotNull
    public abstract com.example.cloudnotes.entities.Notes getSpecificNote(int id);
    
    @androidx.room.Insert(onConflict = 1)
    public abstract void insertNotes(@org.jetbrains.annotations.NotNull
    com.example.cloudnotes.entities.Notes note);
    
    @androidx.room.Delete
    public abstract void deleteNote(@org.jetbrains.annotations.NotNull
    com.example.cloudnotes.entities.Notes note);
    
    @androidx.room.Query(value = "DELETE FROM notes WHERE id=:id")
    public abstract void deleteSpecificNote(int id);
    
    @androidx.room.Update
    public abstract void updateNote(@org.jetbrains.annotations.NotNull
    com.example.cloudnotes.entities.Notes note);
}