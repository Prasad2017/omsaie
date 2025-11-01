package com.omsai.omsai.db;

import androidx.annotation.NonNull;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenDelegate;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation", "removal"})
public final class PhotoDatabase_Impl extends PhotoDatabase {
  private volatile PhotoDao _photoDao;

  @Override
  @NonNull
  protected RoomOpenDelegate createOpenDelegate() {
    final RoomOpenDelegate _openDelegate = new RoomOpenDelegate(3, "77165fe9c4e226f58d5833004ae54d63", "677823778d0587dfc916e01713d84b1e") {
      @Override
      public void createAllTables(@NonNull final SQLiteConnection connection) {
        SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `Photo` (`filename` TEXT NOT NULL, `msg` TEXT NOT NULL, `filepath` TEXT NOT NULL, `last_row_id` TEXT NOT NULL, `isprinted` INTEGER NOT NULL, `isPhoto` INTEGER NOT NULL, `time` INTEGER NOT NULL, `count` INTEGER NOT NULL, `IsChecked` INTEGER NOT NULL, PRIMARY KEY(`filepath`, `filename`, `msg`, `last_row_id`))");
        SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        SQLite.execSQL(connection, "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '77165fe9c4e226f58d5833004ae54d63')");
      }

      @Override
      public void dropAllTables(@NonNull final SQLiteConnection connection) {
        SQLite.execSQL(connection, "DROP TABLE IF EXISTS `Photo`");
      }

      @Override
      public void onCreate(@NonNull final SQLiteConnection connection) {
      }

      @Override
      public void onOpen(@NonNull final SQLiteConnection connection) {
        internalInitInvalidationTracker(connection);
      }

      @Override
      public void onPreMigrate(@NonNull final SQLiteConnection connection) {
        DBUtil.dropFtsSyncTriggers(connection);
      }

      @Override
      public void onPostMigrate(@NonNull final SQLiteConnection connection) {
      }

      @Override
      @NonNull
      public RoomOpenDelegate.ValidationResult onValidateSchema(
          @NonNull final SQLiteConnection connection) {
        final Map<String, TableInfo.Column> _columnsPhoto = new HashMap<String, TableInfo.Column>(9);
        _columnsPhoto.put("filename", new TableInfo.Column("filename", "TEXT", true, 2, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPhoto.put("msg", new TableInfo.Column("msg", "TEXT", true, 3, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPhoto.put("filepath", new TableInfo.Column("filepath", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPhoto.put("last_row_id", new TableInfo.Column("last_row_id", "TEXT", true, 4, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPhoto.put("isprinted", new TableInfo.Column("isprinted", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPhoto.put("isPhoto", new TableInfo.Column("isPhoto", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPhoto.put("time", new TableInfo.Column("time", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPhoto.put("count", new TableInfo.Column("count", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPhoto.put("IsChecked", new TableInfo.Column("IsChecked", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final Set<TableInfo.ForeignKey> _foreignKeysPhoto = new HashSet<TableInfo.ForeignKey>(0);
        final Set<TableInfo.Index> _indicesPhoto = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoPhoto = new TableInfo("Photo", _columnsPhoto, _foreignKeysPhoto, _indicesPhoto);
        final TableInfo _existingPhoto = TableInfo.read(connection, "Photo");
        if (!_infoPhoto.equals(_existingPhoto)) {
          return new RoomOpenDelegate.ValidationResult(false, "Photo(com.omsai.omsai.db.Photo).\n"
                  + " Expected:\n" + _infoPhoto + "\n"
                  + " Found:\n" + _existingPhoto);
        }
        return new RoomOpenDelegate.ValidationResult(true, null);
      }
    };
    return _openDelegate;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final Map<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final Map<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "Photo");
  }

  @Override
  public void clearAllTables() {
    super.performClear(false, "Photo");
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final Map<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(PhotoDao.class, PhotoDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final Set<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public PhotoDao daoPhoto() {
    if (_photoDao != null) {
      return _photoDao;
    } else {
      synchronized(this) {
        if(_photoDao == null) {
          _photoDao = new PhotoDao_Impl(this);
        }
        return _photoDao;
      }
    }
  }
}
