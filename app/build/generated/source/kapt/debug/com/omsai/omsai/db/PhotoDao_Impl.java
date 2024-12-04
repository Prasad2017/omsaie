package com.omsai.omsai.db;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class PhotoDao_Impl implements PhotoDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Photo> __insertionAdapterOfPhoto;

  private final SharedSQLiteStatement __preparedStmtOfDeleteCompanyDocument;

  public PhotoDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPhoto = new EntityInsertionAdapter<Photo>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `Photo` (`filename`,`msg`,`filepath`,`last_row_id`,`isprinted`,`isPhoto`,`time`,`count`,`IsChecked`) VALUES (?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Photo entity) {
        if (entity.getFileName() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getFileName());
        }
        if (entity.getMsg() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getMsg());
        }
        if (entity.getFilePath() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getFilePath());
        }
        if (entity.getLast_row_id() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getLast_row_id());
        }
        final int _tmp = entity.isPrinted() ? 1 : 0;
        statement.bindLong(5, _tmp);
        final int _tmp_1 = entity.isPhoto() ? 1 : 0;
        statement.bindLong(6, _tmp_1);
        statement.bindLong(7, entity.getTime());
        statement.bindLong(8, entity.getCount());
        final int _tmp_2 = entity.getIsChecked() ? 1 : 0;
        statement.bindLong(9, _tmp_2);
      }
    };
    this.__preparedStmtOfDeleteCompanyDocument = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "Delete FROM Photo";
        return _query;
      }
    };
  }

  @Override
  public void insertAll(final List<Photo> entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfPhoto.insert(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insert(final Photo entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfPhoto.insert(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteCompanyDocument() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteCompanyDocument.acquire();
    try {
      __db.beginTransaction();
      try {
        _stmt.executeUpdateDelete();
        __db.setTransactionSuccessful();
      } finally {
        __db.endTransaction();
      }
    } finally {
      __preparedStmtOfDeleteCompanyDocument.release(_stmt);
    }
  }

  @Override
  public List<Photo> load() {
    final String _sql = "SELECT * FROM Photo";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfFileName = CursorUtil.getColumnIndexOrThrow(_cursor, "filename");
      final int _cursorIndexOfMsg = CursorUtil.getColumnIndexOrThrow(_cursor, "msg");
      final int _cursorIndexOfFilePath = CursorUtil.getColumnIndexOrThrow(_cursor, "filepath");
      final int _cursorIndexOfLastRowId = CursorUtil.getColumnIndexOrThrow(_cursor, "last_row_id");
      final int _cursorIndexOfIsPrinted = CursorUtil.getColumnIndexOrThrow(_cursor, "isprinted");
      final int _cursorIndexOfIsPhoto = CursorUtil.getColumnIndexOrThrow(_cursor, "isPhoto");
      final int _cursorIndexOfTime = CursorUtil.getColumnIndexOrThrow(_cursor, "time");
      final int _cursorIndexOfCount = CursorUtil.getColumnIndexOrThrow(_cursor, "count");
      final int _cursorIndexOfIsChecked = CursorUtil.getColumnIndexOrThrow(_cursor, "IsChecked");
      final List<Photo> _result = new ArrayList<Photo>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final Photo _item;
        final String _tmpFileName;
        if (_cursor.isNull(_cursorIndexOfFileName)) {
          _tmpFileName = null;
        } else {
          _tmpFileName = _cursor.getString(_cursorIndexOfFileName);
        }
        final String _tmpMsg;
        if (_cursor.isNull(_cursorIndexOfMsg)) {
          _tmpMsg = null;
        } else {
          _tmpMsg = _cursor.getString(_cursorIndexOfMsg);
        }
        final String _tmpFilePath;
        if (_cursor.isNull(_cursorIndexOfFilePath)) {
          _tmpFilePath = null;
        } else {
          _tmpFilePath = _cursor.getString(_cursorIndexOfFilePath);
        }
        final String _tmpLast_row_id;
        if (_cursor.isNull(_cursorIndexOfLastRowId)) {
          _tmpLast_row_id = null;
        } else {
          _tmpLast_row_id = _cursor.getString(_cursorIndexOfLastRowId);
        }
        final boolean _tmpIsPrinted;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsPrinted);
        _tmpIsPrinted = _tmp != 0;
        final boolean _tmpIsPhoto;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfIsPhoto);
        _tmpIsPhoto = _tmp_1 != 0;
        final long _tmpTime;
        _tmpTime = _cursor.getLong(_cursorIndexOfTime);
        final long _tmpCount;
        _tmpCount = _cursor.getLong(_cursorIndexOfCount);
        _item = new Photo(_tmpFileName,_tmpFilePath,_tmpIsPrinted,_tmpTime,_tmpIsPhoto,_tmpMsg,_tmpLast_row_id,_tmpCount);
        final boolean _tmpIsChecked;
        final int _tmp_2;
        _tmp_2 = _cursor.getInt(_cursorIndexOfIsChecked);
        _tmpIsChecked = _tmp_2 != 0;
        _item.setIsChecked(_tmpIsChecked);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Photo> loadNonPrinted() {
    final String _sql = "SELECT * FROM Photo where isprinted='false'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfFileName = CursorUtil.getColumnIndexOrThrow(_cursor, "filename");
      final int _cursorIndexOfMsg = CursorUtil.getColumnIndexOrThrow(_cursor, "msg");
      final int _cursorIndexOfFilePath = CursorUtil.getColumnIndexOrThrow(_cursor, "filepath");
      final int _cursorIndexOfLastRowId = CursorUtil.getColumnIndexOrThrow(_cursor, "last_row_id");
      final int _cursorIndexOfIsPrinted = CursorUtil.getColumnIndexOrThrow(_cursor, "isprinted");
      final int _cursorIndexOfIsPhoto = CursorUtil.getColumnIndexOrThrow(_cursor, "isPhoto");
      final int _cursorIndexOfTime = CursorUtil.getColumnIndexOrThrow(_cursor, "time");
      final int _cursorIndexOfCount = CursorUtil.getColumnIndexOrThrow(_cursor, "count");
      final int _cursorIndexOfIsChecked = CursorUtil.getColumnIndexOrThrow(_cursor, "IsChecked");
      final List<Photo> _result = new ArrayList<Photo>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final Photo _item;
        final String _tmpFileName;
        if (_cursor.isNull(_cursorIndexOfFileName)) {
          _tmpFileName = null;
        } else {
          _tmpFileName = _cursor.getString(_cursorIndexOfFileName);
        }
        final String _tmpMsg;
        if (_cursor.isNull(_cursorIndexOfMsg)) {
          _tmpMsg = null;
        } else {
          _tmpMsg = _cursor.getString(_cursorIndexOfMsg);
        }
        final String _tmpFilePath;
        if (_cursor.isNull(_cursorIndexOfFilePath)) {
          _tmpFilePath = null;
        } else {
          _tmpFilePath = _cursor.getString(_cursorIndexOfFilePath);
        }
        final String _tmpLast_row_id;
        if (_cursor.isNull(_cursorIndexOfLastRowId)) {
          _tmpLast_row_id = null;
        } else {
          _tmpLast_row_id = _cursor.getString(_cursorIndexOfLastRowId);
        }
        final boolean _tmpIsPrinted;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsPrinted);
        _tmpIsPrinted = _tmp != 0;
        final boolean _tmpIsPhoto;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfIsPhoto);
        _tmpIsPhoto = _tmp_1 != 0;
        final long _tmpTime;
        _tmpTime = _cursor.getLong(_cursorIndexOfTime);
        final long _tmpCount;
        _tmpCount = _cursor.getLong(_cursorIndexOfCount);
        _item = new Photo(_tmpFileName,_tmpFilePath,_tmpIsPrinted,_tmpTime,_tmpIsPhoto,_tmpMsg,_tmpLast_row_id,_tmpCount);
        final boolean _tmpIsChecked;
        final int _tmp_2;
        _tmp_2 = _cursor.getInt(_cursorIndexOfIsChecked);
        _tmpIsChecked = _tmp_2 != 0;
        _item.setIsChecked(_tmpIsChecked);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Photo loadPhotoForPrint() {
    final String _sql = "SELECT * FROM Photo where isprinted=0 limit 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfFileName = CursorUtil.getColumnIndexOrThrow(_cursor, "filename");
      final int _cursorIndexOfMsg = CursorUtil.getColumnIndexOrThrow(_cursor, "msg");
      final int _cursorIndexOfFilePath = CursorUtil.getColumnIndexOrThrow(_cursor, "filepath");
      final int _cursorIndexOfLastRowId = CursorUtil.getColumnIndexOrThrow(_cursor, "last_row_id");
      final int _cursorIndexOfIsPrinted = CursorUtil.getColumnIndexOrThrow(_cursor, "isprinted");
      final int _cursorIndexOfIsPhoto = CursorUtil.getColumnIndexOrThrow(_cursor, "isPhoto");
      final int _cursorIndexOfTime = CursorUtil.getColumnIndexOrThrow(_cursor, "time");
      final int _cursorIndexOfCount = CursorUtil.getColumnIndexOrThrow(_cursor, "count");
      final int _cursorIndexOfIsChecked = CursorUtil.getColumnIndexOrThrow(_cursor, "IsChecked");
      final Photo _result;
      if (_cursor.moveToFirst()) {
        final String _tmpFileName;
        if (_cursor.isNull(_cursorIndexOfFileName)) {
          _tmpFileName = null;
        } else {
          _tmpFileName = _cursor.getString(_cursorIndexOfFileName);
        }
        final String _tmpMsg;
        if (_cursor.isNull(_cursorIndexOfMsg)) {
          _tmpMsg = null;
        } else {
          _tmpMsg = _cursor.getString(_cursorIndexOfMsg);
        }
        final String _tmpFilePath;
        if (_cursor.isNull(_cursorIndexOfFilePath)) {
          _tmpFilePath = null;
        } else {
          _tmpFilePath = _cursor.getString(_cursorIndexOfFilePath);
        }
        final String _tmpLast_row_id;
        if (_cursor.isNull(_cursorIndexOfLastRowId)) {
          _tmpLast_row_id = null;
        } else {
          _tmpLast_row_id = _cursor.getString(_cursorIndexOfLastRowId);
        }
        final boolean _tmpIsPrinted;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsPrinted);
        _tmpIsPrinted = _tmp != 0;
        final boolean _tmpIsPhoto;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfIsPhoto);
        _tmpIsPhoto = _tmp_1 != 0;
        final long _tmpTime;
        _tmpTime = _cursor.getLong(_cursorIndexOfTime);
        final long _tmpCount;
        _tmpCount = _cursor.getLong(_cursorIndexOfCount);
        _result = new Photo(_tmpFileName,_tmpFilePath,_tmpIsPrinted,_tmpTime,_tmpIsPhoto,_tmpMsg,_tmpLast_row_id,_tmpCount);
        final boolean _tmpIsChecked;
        final int _tmp_2;
        _tmp_2 = _cursor.getInt(_cursorIndexOfIsChecked);
        _tmpIsChecked = _tmp_2 != 0;
        _result.setIsChecked(_tmpIsChecked);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Flow<List<Photo>> getAllPhotos() {
    final String _sql = "SELECT * FROM Photo ORDER BY isprinted , time DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"Photo"}, new Callable<List<Photo>>() {
      @Override
      @NonNull
      public List<Photo> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfFileName = CursorUtil.getColumnIndexOrThrow(_cursor, "filename");
          final int _cursorIndexOfMsg = CursorUtil.getColumnIndexOrThrow(_cursor, "msg");
          final int _cursorIndexOfFilePath = CursorUtil.getColumnIndexOrThrow(_cursor, "filepath");
          final int _cursorIndexOfLastRowId = CursorUtil.getColumnIndexOrThrow(_cursor, "last_row_id");
          final int _cursorIndexOfIsPrinted = CursorUtil.getColumnIndexOrThrow(_cursor, "isprinted");
          final int _cursorIndexOfIsPhoto = CursorUtil.getColumnIndexOrThrow(_cursor, "isPhoto");
          final int _cursorIndexOfTime = CursorUtil.getColumnIndexOrThrow(_cursor, "time");
          final int _cursorIndexOfCount = CursorUtil.getColumnIndexOrThrow(_cursor, "count");
          final int _cursorIndexOfIsChecked = CursorUtil.getColumnIndexOrThrow(_cursor, "IsChecked");
          final List<Photo> _result = new ArrayList<Photo>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Photo _item;
            final String _tmpFileName;
            if (_cursor.isNull(_cursorIndexOfFileName)) {
              _tmpFileName = null;
            } else {
              _tmpFileName = _cursor.getString(_cursorIndexOfFileName);
            }
            final String _tmpMsg;
            if (_cursor.isNull(_cursorIndexOfMsg)) {
              _tmpMsg = null;
            } else {
              _tmpMsg = _cursor.getString(_cursorIndexOfMsg);
            }
            final String _tmpFilePath;
            if (_cursor.isNull(_cursorIndexOfFilePath)) {
              _tmpFilePath = null;
            } else {
              _tmpFilePath = _cursor.getString(_cursorIndexOfFilePath);
            }
            final String _tmpLast_row_id;
            if (_cursor.isNull(_cursorIndexOfLastRowId)) {
              _tmpLast_row_id = null;
            } else {
              _tmpLast_row_id = _cursor.getString(_cursorIndexOfLastRowId);
            }
            final boolean _tmpIsPrinted;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsPrinted);
            _tmpIsPrinted = _tmp != 0;
            final boolean _tmpIsPhoto;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsPhoto);
            _tmpIsPhoto = _tmp_1 != 0;
            final long _tmpTime;
            _tmpTime = _cursor.getLong(_cursorIndexOfTime);
            final long _tmpCount;
            _tmpCount = _cursor.getLong(_cursorIndexOfCount);
            _item = new Photo(_tmpFileName,_tmpFilePath,_tmpIsPrinted,_tmpTime,_tmpIsPhoto,_tmpMsg,_tmpLast_row_id,_tmpCount);
            final boolean _tmpIsChecked;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfIsChecked);
            _tmpIsChecked = _tmp_2 != 0;
            _item.setIsChecked(_tmpIsChecked);
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
  public Photo getMSG(final String msg1, final String name) {
    final String _sql = "SELECT * FROM Photo where isPhoto='false' AND msg=? AND filename =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (msg1 == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, msg1);
    }
    _argIndex = 2;
    if (name == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, name);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfFileName = CursorUtil.getColumnIndexOrThrow(_cursor, "filename");
      final int _cursorIndexOfMsg = CursorUtil.getColumnIndexOrThrow(_cursor, "msg");
      final int _cursorIndexOfFilePath = CursorUtil.getColumnIndexOrThrow(_cursor, "filepath");
      final int _cursorIndexOfLastRowId = CursorUtil.getColumnIndexOrThrow(_cursor, "last_row_id");
      final int _cursorIndexOfIsPrinted = CursorUtil.getColumnIndexOrThrow(_cursor, "isprinted");
      final int _cursorIndexOfIsPhoto = CursorUtil.getColumnIndexOrThrow(_cursor, "isPhoto");
      final int _cursorIndexOfTime = CursorUtil.getColumnIndexOrThrow(_cursor, "time");
      final int _cursorIndexOfCount = CursorUtil.getColumnIndexOrThrow(_cursor, "count");
      final int _cursorIndexOfIsChecked = CursorUtil.getColumnIndexOrThrow(_cursor, "IsChecked");
      final Photo _result;
      if (_cursor.moveToFirst()) {
        final String _tmpFileName;
        if (_cursor.isNull(_cursorIndexOfFileName)) {
          _tmpFileName = null;
        } else {
          _tmpFileName = _cursor.getString(_cursorIndexOfFileName);
        }
        final String _tmpMsg;
        if (_cursor.isNull(_cursorIndexOfMsg)) {
          _tmpMsg = null;
        } else {
          _tmpMsg = _cursor.getString(_cursorIndexOfMsg);
        }
        final String _tmpFilePath;
        if (_cursor.isNull(_cursorIndexOfFilePath)) {
          _tmpFilePath = null;
        } else {
          _tmpFilePath = _cursor.getString(_cursorIndexOfFilePath);
        }
        final String _tmpLast_row_id;
        if (_cursor.isNull(_cursorIndexOfLastRowId)) {
          _tmpLast_row_id = null;
        } else {
          _tmpLast_row_id = _cursor.getString(_cursorIndexOfLastRowId);
        }
        final boolean _tmpIsPrinted;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsPrinted);
        _tmpIsPrinted = _tmp != 0;
        final boolean _tmpIsPhoto;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfIsPhoto);
        _tmpIsPhoto = _tmp_1 != 0;
        final long _tmpTime;
        _tmpTime = _cursor.getLong(_cursorIndexOfTime);
        final long _tmpCount;
        _tmpCount = _cursor.getLong(_cursorIndexOfCount);
        _result = new Photo(_tmpFileName,_tmpFilePath,_tmpIsPrinted,_tmpTime,_tmpIsPhoto,_tmpMsg,_tmpLast_row_id,_tmpCount);
        final boolean _tmpIsChecked;
        final int _tmp_2;
        _tmp_2 = _cursor.getInt(_cursorIndexOfIsChecked);
        _tmpIsChecked = _tmp_2 != 0;
        _result.setIsChecked(_tmpIsChecked);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
