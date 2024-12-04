package com.omsai.omsai.db;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u001e\b\u0007\u0018\u00002\u00020\u0001BS\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\b\u00a2\u0006\u0002\u0010\rJ\u0006\u0010%\u001a\u00020\u0003R\u001a\u0010\u000e\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\f\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0018\"\u0004\b\u001c\u0010\u001aR\u001e\u0010\t\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0010\"\u0004\b\u001d\u0010\u0012R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0010\"\u0004\b\u001e\u0010\u0012R\u001e\u0010\u000b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0018\"\u0004\b \u0010\u001aR\u001e\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0018\"\u0004\b\"\u0010\u001aR\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0014\"\u0004\b$\u0010\u0016\u00a8\u0006&"}, d2 = {"Lcom/omsai/omsai/db/Photo;", "", "fileName", "", "filePath", "isPrinted", "", "time", "", "isPhoto", "msg", "last_row_id", "count", "(Ljava/lang/String;Ljava/lang/String;ZJZLjava/lang/String;Ljava/lang/String;J)V", "IsChecked", "getIsChecked", "()Z", "setIsChecked", "(Z)V", "getCount", "()J", "setCount", "(J)V", "getFileName", "()Ljava/lang/String;", "setFileName", "(Ljava/lang/String;)V", "getFilePath", "setFilePath", "setPhoto", "setPrinted", "getLast_row_id", "setLast_row_id", "getMsg", "setMsg", "getTime", "setTime", "humanDate", "app_debug"})
@androidx.room.Entity(tableName = "Photo", primaryKeys = {"filepath", "filename", "msg", "last_row_id"})
public final class Photo {
    @androidx.room.ColumnInfo(name = "filename")
    @org.jetbrains.annotations.NotNull()
    private java.lang.String fileName = "";
    @androidx.room.ColumnInfo(name = "msg")
    @org.jetbrains.annotations.NotNull()
    private java.lang.String msg = "";
    @androidx.room.ColumnInfo(name = "filepath")
    @org.jetbrains.annotations.NotNull()
    private java.lang.String filePath = "";
    @androidx.room.ColumnInfo(name = "last_row_id")
    @org.jetbrains.annotations.NotNull()
    private java.lang.String last_row_id = "";
    @androidx.room.ColumnInfo(name = "isprinted")
    private boolean isPrinted = false;
    @androidx.room.ColumnInfo(name = "isPhoto")
    private boolean isPhoto = true;
    @androidx.room.ColumnInfo(name = "time")
    private long time = 0L;
    @androidx.room.ColumnInfo(name = "count")
    private long count = 0L;
    private boolean IsChecked = false;
    
    public Photo(@org.jetbrains.annotations.Nullable()
    java.lang.String fileName, @org.jetbrains.annotations.NotNull()
    java.lang.String filePath, boolean isPrinted, long time, boolean isPhoto, @org.jetbrains.annotations.NotNull()
    java.lang.String msg, @org.jetbrains.annotations.NotNull()
    java.lang.String last_row_id, long count) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFileName() {
        return null;
    }
    
    public final void setFileName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMsg() {
        return null;
    }
    
    public final void setMsg(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFilePath() {
        return null;
    }
    
    public final void setFilePath(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getLast_row_id() {
        return null;
    }
    
    public final void setLast_row_id(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final boolean isPrinted() {
        return false;
    }
    
    public final void setPrinted(boolean p0) {
    }
    
    public final boolean isPhoto() {
        return false;
    }
    
    public final void setPhoto(boolean p0) {
    }
    
    public final long getTime() {
        return 0L;
    }
    
    public final void setTime(long p0) {
    }
    
    public final long getCount() {
        return 0L;
    }
    
    public final void setCount(long p0) {
    }
    
    public final boolean getIsChecked() {
        return false;
    }
    
    public final void setIsChecked(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String humanDate() {
        return null;
    }
}