package com.omsai.omsai.db;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005\u00a2\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H&\u00a8\u0006\u0006"}, d2 = {"Lcom/omsai/omsai/db/PhotoDatabase;", "Landroidx/room/RoomDatabase;", "()V", "daoPhoto", "Lcom/omsai/omsai/db/PhotoDao;", "Companion", "app_debug"})
@androidx.room.Database(entities = {com.omsai.omsai.db.Photo.class}, version = 3, exportSchema = false)
public abstract class PhotoDatabase extends androidx.room.RoomDatabase {
    @org.jetbrains.annotations.Nullable()
    private static com.omsai.omsai.db.PhotoDatabase db;
    @org.jetbrains.annotations.NotNull()
    public static final com.omsai.omsai.db.PhotoDatabase.Companion Companion = null;
    
    public PhotoDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public abstract com.omsai.omsai.db.PhotoDao daoPhoto();
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/omsai/omsai/db/PhotoDatabase$Companion;", "", "()V", "db", "Lcom/omsai/omsai/db/PhotoDatabase;", "getDb", "()Lcom/omsai/omsai/db/PhotoDatabase;", "setDb", "(Lcom/omsai/omsai/db/PhotoDatabase;)V", "getDB", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.Nullable()
        public final com.omsai.omsai.db.PhotoDatabase getDb() {
            return null;
        }
        
        public final void setDb(@org.jetbrains.annotations.Nullable()
        com.omsai.omsai.db.PhotoDatabase p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.omsai.omsai.db.PhotoDatabase getDB(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
    }
}