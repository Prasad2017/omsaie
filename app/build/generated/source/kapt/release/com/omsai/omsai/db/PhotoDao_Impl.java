package com.omsai.omsai.db;

import androidx.annotation.NonNull;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.coroutines.FlowUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteStatement;
import java.lang.Class;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.processing.Generated;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation", "removal"})
public final class PhotoDao_Impl implements PhotoDao {
  private final RoomDatabase __db;

  private final EntityInsertAdapter<Photo> __insertAdapterOfPhoto;

  public PhotoDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertAdapterOfPhoto = new EntityInsertAdapter<Photo>() {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `Photo` (`filename`,`msg`,`filepath`,`last_row_id`,`isprinted`,`isPhoto`,`time`,`count`,`IsChecked`) VALUES (?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SQLiteStatement statement, @NonNull final Photo entity) {
        if (entity.getFileName() == null) {
          statement.bindNull(1);
        } else {
          statement.bindText(1, entity.getFileName());
        }
        if (entity.getMsg() == null) {
          statement.bindNull(2);
        } else {
          statement.bindText(2, entity.getMsg());
        }
        if (entity.getFilePath() == null) {
          statement.bindNull(3);
        } else {
          statement.bindText(3, entity.getFilePath());
        }
        if (entity.getLast_row_id() == null) {
          statement.bindNull(4);
        } else {
          statement.bindText(4, entity.getLast_row_id());
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
  }

  @Override
  public void insertAll(final List<Photo> entity) {
    if (entity == null) throw new NullPointerException();
    DBUtil.performBlocking(__db, false, true, (_connection) -> {
      __insertAdapterOfPhoto.insert(_connection, entity);
      return null;
    });
  }

  @Override
  public void insert(final Photo entity) {
    if (entity == null) throw new NullPointerException();
    DBUtil.performBlocking(__db, false, true, (_connection) -> {
      __insertAdapterOfPhoto.insert(_connection, entity);
      return null;
    });
  }

  @Override
  public List<Photo> load() {
    final String _sql = "SELECT * FROM Photo";
    return DBUtil.performBlocking(__db, true, false, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        final int _columnIndexOfFileName = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "filename");
        final int _columnIndexOfMsg = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "msg");
        final int _columnIndexOfFilePath = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "filepath");
        final int _columnIndexOfLastRowId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "last_row_id");
        final int _columnIndexOfIsPrinted = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "isprinted");
        final int _columnIndexOfIsPhoto = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "isPhoto");
        final int _columnIndexOfTime = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "time");
        final int _columnIndexOfCount = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "count");
        final int _columnIndexOfIsChecked = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "IsChecked");
        final List<Photo> _result = new ArrayList<Photo>();
        while (_stmt.step()) {
          final Photo _item;
          final String _tmpFileName;
          if (_stmt.isNull(_columnIndexOfFileName)) {
            _tmpFileName = null;
          } else {
            _tmpFileName = _stmt.getText(_columnIndexOfFileName);
          }
          final String _tmpMsg;
          if (_stmt.isNull(_columnIndexOfMsg)) {
            _tmpMsg = null;
          } else {
            _tmpMsg = _stmt.getText(_columnIndexOfMsg);
          }
          final String _tmpFilePath;
          if (_stmt.isNull(_columnIndexOfFilePath)) {
            _tmpFilePath = null;
          } else {
            _tmpFilePath = _stmt.getText(_columnIndexOfFilePath);
          }
          final String _tmpLast_row_id;
          if (_stmt.isNull(_columnIndexOfLastRowId)) {
            _tmpLast_row_id = null;
          } else {
            _tmpLast_row_id = _stmt.getText(_columnIndexOfLastRowId);
          }
          final boolean _tmpIsPrinted;
          final int _tmp;
          _tmp = (int) (_stmt.getLong(_columnIndexOfIsPrinted));
          _tmpIsPrinted = _tmp != 0;
          final boolean _tmpIsPhoto;
          final int _tmp_1;
          _tmp_1 = (int) (_stmt.getLong(_columnIndexOfIsPhoto));
          _tmpIsPhoto = _tmp_1 != 0;
          final long _tmpTime;
          _tmpTime = _stmt.getLong(_columnIndexOfTime);
          final long _tmpCount;
          _tmpCount = _stmt.getLong(_columnIndexOfCount);
          _item = new Photo(_tmpFileName,_tmpFilePath,_tmpIsPrinted,_tmpTime,_tmpIsPhoto,_tmpMsg,_tmpLast_row_id,_tmpCount);
          final boolean _tmpIsChecked;
          final int _tmp_2;
          _tmp_2 = (int) (_stmt.getLong(_columnIndexOfIsChecked));
          _tmpIsChecked = _tmp_2 != 0;
          _item.setIsChecked(_tmpIsChecked);
          _result.add(_item);
        }
        return _result;
      } finally {
        _stmt.close();
      }
    });
  }

  @Override
  public List<Photo> loadNonPrinted() {
    final String _sql = "SELECT * FROM Photo where isprinted='false'";
    return DBUtil.performBlocking(__db, true, false, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        final int _columnIndexOfFileName = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "filename");
        final int _columnIndexOfMsg = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "msg");
        final int _columnIndexOfFilePath = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "filepath");
        final int _columnIndexOfLastRowId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "last_row_id");
        final int _columnIndexOfIsPrinted = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "isprinted");
        final int _columnIndexOfIsPhoto = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "isPhoto");
        final int _columnIndexOfTime = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "time");
        final int _columnIndexOfCount = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "count");
        final int _columnIndexOfIsChecked = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "IsChecked");
        final List<Photo> _result = new ArrayList<Photo>();
        while (_stmt.step()) {
          final Photo _item;
          final String _tmpFileName;
          if (_stmt.isNull(_columnIndexOfFileName)) {
            _tmpFileName = null;
          } else {
            _tmpFileName = _stmt.getText(_columnIndexOfFileName);
          }
          final String _tmpMsg;
          if (_stmt.isNull(_columnIndexOfMsg)) {
            _tmpMsg = null;
          } else {
            _tmpMsg = _stmt.getText(_columnIndexOfMsg);
          }
          final String _tmpFilePath;
          if (_stmt.isNull(_columnIndexOfFilePath)) {
            _tmpFilePath = null;
          } else {
            _tmpFilePath = _stmt.getText(_columnIndexOfFilePath);
          }
          final String _tmpLast_row_id;
          if (_stmt.isNull(_columnIndexOfLastRowId)) {
            _tmpLast_row_id = null;
          } else {
            _tmpLast_row_id = _stmt.getText(_columnIndexOfLastRowId);
          }
          final boolean _tmpIsPrinted;
          final int _tmp;
          _tmp = (int) (_stmt.getLong(_columnIndexOfIsPrinted));
          _tmpIsPrinted = _tmp != 0;
          final boolean _tmpIsPhoto;
          final int _tmp_1;
          _tmp_1 = (int) (_stmt.getLong(_columnIndexOfIsPhoto));
          _tmpIsPhoto = _tmp_1 != 0;
          final long _tmpTime;
          _tmpTime = _stmt.getLong(_columnIndexOfTime);
          final long _tmpCount;
          _tmpCount = _stmt.getLong(_columnIndexOfCount);
          _item = new Photo(_tmpFileName,_tmpFilePath,_tmpIsPrinted,_tmpTime,_tmpIsPhoto,_tmpMsg,_tmpLast_row_id,_tmpCount);
          final boolean _tmpIsChecked;
          final int _tmp_2;
          _tmp_2 = (int) (_stmt.getLong(_columnIndexOfIsChecked));
          _tmpIsChecked = _tmp_2 != 0;
          _item.setIsChecked(_tmpIsChecked);
          _result.add(_item);
        }
        return _result;
      } finally {
        _stmt.close();
      }
    });
  }

  @Override
  public Photo loadPhotoForPrint() {
    final String _sql = "SELECT * FROM Photo where isprinted=0 limit 1";
    return DBUtil.performBlocking(__db, true, false, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        final int _columnIndexOfFileName = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "filename");
        final int _columnIndexOfMsg = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "msg");
        final int _columnIndexOfFilePath = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "filepath");
        final int _columnIndexOfLastRowId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "last_row_id");
        final int _columnIndexOfIsPrinted = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "isprinted");
        final int _columnIndexOfIsPhoto = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "isPhoto");
        final int _columnIndexOfTime = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "time");
        final int _columnIndexOfCount = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "count");
        final int _columnIndexOfIsChecked = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "IsChecked");
        final Photo _result;
        if (_stmt.step()) {
          final String _tmpFileName;
          if (_stmt.isNull(_columnIndexOfFileName)) {
            _tmpFileName = null;
          } else {
            _tmpFileName = _stmt.getText(_columnIndexOfFileName);
          }
          final String _tmpMsg;
          if (_stmt.isNull(_columnIndexOfMsg)) {
            _tmpMsg = null;
          } else {
            _tmpMsg = _stmt.getText(_columnIndexOfMsg);
          }
          final String _tmpFilePath;
          if (_stmt.isNull(_columnIndexOfFilePath)) {
            _tmpFilePath = null;
          } else {
            _tmpFilePath = _stmt.getText(_columnIndexOfFilePath);
          }
          final String _tmpLast_row_id;
          if (_stmt.isNull(_columnIndexOfLastRowId)) {
            _tmpLast_row_id = null;
          } else {
            _tmpLast_row_id = _stmt.getText(_columnIndexOfLastRowId);
          }
          final boolean _tmpIsPrinted;
          final int _tmp;
          _tmp = (int) (_stmt.getLong(_columnIndexOfIsPrinted));
          _tmpIsPrinted = _tmp != 0;
          final boolean _tmpIsPhoto;
          final int _tmp_1;
          _tmp_1 = (int) (_stmt.getLong(_columnIndexOfIsPhoto));
          _tmpIsPhoto = _tmp_1 != 0;
          final long _tmpTime;
          _tmpTime = _stmt.getLong(_columnIndexOfTime);
          final long _tmpCount;
          _tmpCount = _stmt.getLong(_columnIndexOfCount);
          _result = new Photo(_tmpFileName,_tmpFilePath,_tmpIsPrinted,_tmpTime,_tmpIsPhoto,_tmpMsg,_tmpLast_row_id,_tmpCount);
          final boolean _tmpIsChecked;
          final int _tmp_2;
          _tmp_2 = (int) (_stmt.getLong(_columnIndexOfIsChecked));
          _tmpIsChecked = _tmp_2 != 0;
          _result.setIsChecked(_tmpIsChecked);
        } else {
          _result = null;
        }
        return _result;
      } finally {
        _stmt.close();
      }
    });
  }

  @Override
  public Flow<List<Photo>> getAllPhotos() {
    final String _sql = "SELECT * FROM Photo ORDER BY isprinted , time DESC";
    return FlowUtil.createFlow(__db, false, new String[] {"Photo"}, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        final int _columnIndexOfFileName = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "filename");
        final int _columnIndexOfMsg = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "msg");
        final int _columnIndexOfFilePath = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "filepath");
        final int _columnIndexOfLastRowId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "last_row_id");
        final int _columnIndexOfIsPrinted = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "isprinted");
        final int _columnIndexOfIsPhoto = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "isPhoto");
        final int _columnIndexOfTime = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "time");
        final int _columnIndexOfCount = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "count");
        final int _columnIndexOfIsChecked = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "IsChecked");
        final List<Photo> _result = new ArrayList<Photo>();
        while (_stmt.step()) {
          final Photo _item;
          final String _tmpFileName;
          if (_stmt.isNull(_columnIndexOfFileName)) {
            _tmpFileName = null;
          } else {
            _tmpFileName = _stmt.getText(_columnIndexOfFileName);
          }
          final String _tmpMsg;
          if (_stmt.isNull(_columnIndexOfMsg)) {
            _tmpMsg = null;
          } else {
            _tmpMsg = _stmt.getText(_columnIndexOfMsg);
          }
          final String _tmpFilePath;
          if (_stmt.isNull(_columnIndexOfFilePath)) {
            _tmpFilePath = null;
          } else {
            _tmpFilePath = _stmt.getText(_columnIndexOfFilePath);
          }
          final String _tmpLast_row_id;
          if (_stmt.isNull(_columnIndexOfLastRowId)) {
            _tmpLast_row_id = null;
          } else {
            _tmpLast_row_id = _stmt.getText(_columnIndexOfLastRowId);
          }
          final boolean _tmpIsPrinted;
          final int _tmp;
          _tmp = (int) (_stmt.getLong(_columnIndexOfIsPrinted));
          _tmpIsPrinted = _tmp != 0;
          final boolean _tmpIsPhoto;
          final int _tmp_1;
          _tmp_1 = (int) (_stmt.getLong(_columnIndexOfIsPhoto));
          _tmpIsPhoto = _tmp_1 != 0;
          final long _tmpTime;
          _tmpTime = _stmt.getLong(_columnIndexOfTime);
          final long _tmpCount;
          _tmpCount = _stmt.getLong(_columnIndexOfCount);
          _item = new Photo(_tmpFileName,_tmpFilePath,_tmpIsPrinted,_tmpTime,_tmpIsPhoto,_tmpMsg,_tmpLast_row_id,_tmpCount);
          final boolean _tmpIsChecked;
          final int _tmp_2;
          _tmp_2 = (int) (_stmt.getLong(_columnIndexOfIsChecked));
          _tmpIsChecked = _tmp_2 != 0;
          _item.setIsChecked(_tmpIsChecked);
          _result.add(_item);
        }
        return _result;
      } finally {
        _stmt.close();
      }
    });
  }

  @Override
  public Photo getMSG(final String msg1, final String name) {
    final String _sql = "SELECT * FROM Photo where isPhoto='false' AND msg=? AND filename =?";
    return DBUtil.performBlocking(__db, true, false, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        if (msg1 == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindText(_argIndex, msg1);
        }
        _argIndex = 2;
        if (name == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindText(_argIndex, name);
        }
        final int _columnIndexOfFileName = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "filename");
        final int _columnIndexOfMsg = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "msg");
        final int _columnIndexOfFilePath = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "filepath");
        final int _columnIndexOfLastRowId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "last_row_id");
        final int _columnIndexOfIsPrinted = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "isprinted");
        final int _columnIndexOfIsPhoto = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "isPhoto");
        final int _columnIndexOfTime = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "time");
        final int _columnIndexOfCount = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "count");
        final int _columnIndexOfIsChecked = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "IsChecked");
        final Photo _result;
        if (_stmt.step()) {
          final String _tmpFileName;
          if (_stmt.isNull(_columnIndexOfFileName)) {
            _tmpFileName = null;
          } else {
            _tmpFileName = _stmt.getText(_columnIndexOfFileName);
          }
          final String _tmpMsg;
          if (_stmt.isNull(_columnIndexOfMsg)) {
            _tmpMsg = null;
          } else {
            _tmpMsg = _stmt.getText(_columnIndexOfMsg);
          }
          final String _tmpFilePath;
          if (_stmt.isNull(_columnIndexOfFilePath)) {
            _tmpFilePath = null;
          } else {
            _tmpFilePath = _stmt.getText(_columnIndexOfFilePath);
          }
          final String _tmpLast_row_id;
          if (_stmt.isNull(_columnIndexOfLastRowId)) {
            _tmpLast_row_id = null;
          } else {
            _tmpLast_row_id = _stmt.getText(_columnIndexOfLastRowId);
          }
          final boolean _tmpIsPrinted;
          final int _tmp;
          _tmp = (int) (_stmt.getLong(_columnIndexOfIsPrinted));
          _tmpIsPrinted = _tmp != 0;
          final boolean _tmpIsPhoto;
          final int _tmp_1;
          _tmp_1 = (int) (_stmt.getLong(_columnIndexOfIsPhoto));
          _tmpIsPhoto = _tmp_1 != 0;
          final long _tmpTime;
          _tmpTime = _stmt.getLong(_columnIndexOfTime);
          final long _tmpCount;
          _tmpCount = _stmt.getLong(_columnIndexOfCount);
          _result = new Photo(_tmpFileName,_tmpFilePath,_tmpIsPrinted,_tmpTime,_tmpIsPhoto,_tmpMsg,_tmpLast_row_id,_tmpCount);
          final boolean _tmpIsChecked;
          final int _tmp_2;
          _tmp_2 = (int) (_stmt.getLong(_columnIndexOfIsChecked));
          _tmpIsChecked = _tmp_2 != 0;
          _result.setIsChecked(_tmpIsChecked);
        } else {
          _result = null;
        }
        return _result;
      } finally {
        _stmt.close();
      }
    });
  }

  @Override
  public void deleteCompanyDocument() {
    final String _sql = "Delete FROM Photo";
    DBUtil.performBlocking(__db, false, true, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        _stmt.step();
        return null;
      } finally {
        _stmt.close();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
