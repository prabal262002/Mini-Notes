package com.example.cloudnotes.dao;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.cloudnotes.entities.Notes;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlinx.coroutines.flow.Flow;

@SuppressWarnings({"unchecked", "deprecation"})
public final class NoteDao_Impl implements NoteDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Notes> __insertionAdapterOfNotes;

  private final EntityDeletionOrUpdateAdapter<Notes> __deletionAdapterOfNotes;

  private final EntityDeletionOrUpdateAdapter<Notes> __updateAdapterOfNotes;

  private final SharedSQLiteStatement __preparedStmtOfDeleteSpecificNote;

  public NoteDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfNotes = new EntityInsertionAdapter<Notes>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Notes` (`id`,`title`,`sub_title`,`date_time`,`note_text`,`img_Path`,`web_Link`,`Color`) VALUES (?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Notes value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getTitle() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTitle());
        }
        if (value.getSubTitle() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getSubTitle());
        }
        if (value.getDateTime() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getDateTime());
        }
        if (value.getNoteText() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getNoteText());
        }
        if (value.getImgPath() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getImgPath());
        }
        if (value.getWebLink() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getWebLink());
        }
        if (value.getColor() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getColor());
        }
      }
    };
    this.__deletionAdapterOfNotes = new EntityDeletionOrUpdateAdapter<Notes>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Notes` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Notes value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
      }
    };
    this.__updateAdapterOfNotes = new EntityDeletionOrUpdateAdapter<Notes>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Notes` SET `id` = ?,`title` = ?,`sub_title` = ?,`date_time` = ?,`note_text` = ?,`img_Path` = ?,`web_Link` = ?,`Color` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Notes value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getTitle() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTitle());
        }
        if (value.getSubTitle() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getSubTitle());
        }
        if (value.getDateTime() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getDateTime());
        }
        if (value.getNoteText() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getNoteText());
        }
        if (value.getImgPath() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getImgPath());
        }
        if (value.getWebLink() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getWebLink());
        }
        if (value.getColor() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getColor());
        }
        if (value.getId() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindLong(9, value.getId());
        }
      }
    };
    this.__preparedStmtOfDeleteSpecificNote = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM notes WHERE id=?";
        return _query;
      }
    };
  }

  @Override
  public void insertNotes(final Notes note) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfNotes.insert(note);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteNote(final Notes note) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfNotes.handle(note);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateNote(final Notes note) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfNotes.handle(note);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteSpecificNote(final int id) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteSpecificNote.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, id);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteSpecificNote.release(_stmt);
    }
  }

  @Override
  public Flow<List<Notes>> getAllNotes() {
    final String _sql = "SELECT * FROM notes ORDER BY id DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"notes"}, new Callable<List<Notes>>() {
      @Override
      public List<Notes> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfSubTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "sub_title");
          final int _cursorIndexOfDateTime = CursorUtil.getColumnIndexOrThrow(_cursor, "date_time");
          final int _cursorIndexOfNoteText = CursorUtil.getColumnIndexOrThrow(_cursor, "note_text");
          final int _cursorIndexOfImgPath = CursorUtil.getColumnIndexOrThrow(_cursor, "img_Path");
          final int _cursorIndexOfWebLink = CursorUtil.getColumnIndexOrThrow(_cursor, "web_Link");
          final int _cursorIndexOfColor = CursorUtil.getColumnIndexOrThrow(_cursor, "Color");
          final List<Notes> _result = new ArrayList<Notes>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Notes _item;
            _item = new Notes();
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            _item.setId(_tmpId);
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            _item.setTitle(_tmpTitle);
            final String _tmpSubTitle;
            if (_cursor.isNull(_cursorIndexOfSubTitle)) {
              _tmpSubTitle = null;
            } else {
              _tmpSubTitle = _cursor.getString(_cursorIndexOfSubTitle);
            }
            _item.setSubTitle(_tmpSubTitle);
            final String _tmpDateTime;
            if (_cursor.isNull(_cursorIndexOfDateTime)) {
              _tmpDateTime = null;
            } else {
              _tmpDateTime = _cursor.getString(_cursorIndexOfDateTime);
            }
            _item.setDateTime(_tmpDateTime);
            final String _tmpNoteText;
            if (_cursor.isNull(_cursorIndexOfNoteText)) {
              _tmpNoteText = null;
            } else {
              _tmpNoteText = _cursor.getString(_cursorIndexOfNoteText);
            }
            _item.setNoteText(_tmpNoteText);
            final String _tmpImgPath;
            if (_cursor.isNull(_cursorIndexOfImgPath)) {
              _tmpImgPath = null;
            } else {
              _tmpImgPath = _cursor.getString(_cursorIndexOfImgPath);
            }
            _item.setImgPath(_tmpImgPath);
            final String _tmpWebLink;
            if (_cursor.isNull(_cursorIndexOfWebLink)) {
              _tmpWebLink = null;
            } else {
              _tmpWebLink = _cursor.getString(_cursorIndexOfWebLink);
            }
            _item.setWebLink(_tmpWebLink);
            final String _tmpColor;
            if (_cursor.isNull(_cursorIndexOfColor)) {
              _tmpColor = null;
            } else {
              _tmpColor = _cursor.getString(_cursorIndexOfColor);
            }
            _item.setColor(_tmpColor);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Notes getSpecificNote(final int id) {
    final String _sql = "SELECT * FROM notes WHERE id=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
      final int _cursorIndexOfSubTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "sub_title");
      final int _cursorIndexOfDateTime = CursorUtil.getColumnIndexOrThrow(_cursor, "date_time");
      final int _cursorIndexOfNoteText = CursorUtil.getColumnIndexOrThrow(_cursor, "note_text");
      final int _cursorIndexOfImgPath = CursorUtil.getColumnIndexOrThrow(_cursor, "img_Path");
      final int _cursorIndexOfWebLink = CursorUtil.getColumnIndexOrThrow(_cursor, "web_Link");
      final int _cursorIndexOfColor = CursorUtil.getColumnIndexOrThrow(_cursor, "Color");
      final Notes _result;
      if(_cursor.moveToFirst()) {
        _result = new Notes();
        final Integer _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getInt(_cursorIndexOfId);
        }
        _result.setId(_tmpId);
        final String _tmpTitle;
        if (_cursor.isNull(_cursorIndexOfTitle)) {
          _tmpTitle = null;
        } else {
          _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        }
        _result.setTitle(_tmpTitle);
        final String _tmpSubTitle;
        if (_cursor.isNull(_cursorIndexOfSubTitle)) {
          _tmpSubTitle = null;
        } else {
          _tmpSubTitle = _cursor.getString(_cursorIndexOfSubTitle);
        }
        _result.setSubTitle(_tmpSubTitle);
        final String _tmpDateTime;
        if (_cursor.isNull(_cursorIndexOfDateTime)) {
          _tmpDateTime = null;
        } else {
          _tmpDateTime = _cursor.getString(_cursorIndexOfDateTime);
        }
        _result.setDateTime(_tmpDateTime);
        final String _tmpNoteText;
        if (_cursor.isNull(_cursorIndexOfNoteText)) {
          _tmpNoteText = null;
        } else {
          _tmpNoteText = _cursor.getString(_cursorIndexOfNoteText);
        }
        _result.setNoteText(_tmpNoteText);
        final String _tmpImgPath;
        if (_cursor.isNull(_cursorIndexOfImgPath)) {
          _tmpImgPath = null;
        } else {
          _tmpImgPath = _cursor.getString(_cursorIndexOfImgPath);
        }
        _result.setImgPath(_tmpImgPath);
        final String _tmpWebLink;
        if (_cursor.isNull(_cursorIndexOfWebLink)) {
          _tmpWebLink = null;
        } else {
          _tmpWebLink = _cursor.getString(_cursorIndexOfWebLink);
        }
        _result.setWebLink(_tmpWebLink);
        final String _tmpColor;
        if (_cursor.isNull(_cursorIndexOfColor)) {
          _tmpColor = null;
        } else {
          _tmpColor = _cursor.getString(_cursorIndexOfColor);
        }
        _result.setColor(_tmpColor);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
