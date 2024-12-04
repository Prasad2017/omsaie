package com.omsai.omsai.db;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\'J\u0014\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005H\'J\u001a\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\'J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0007H\'J\u0016\u0010\u000e\u001a\u00020\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\'J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\'J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\'J\b\u0010\u0011\u001a\u00020\u0007H\'\u00a8\u0006\u0012"}, d2 = {"Lcom/omsai/omsai/db/PhotoDao;", "", "deleteCompanyDocument", "", "getAllPhotos", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/omsai/omsai/db/Photo;", "getMSG", "msg1", "", "name", "insert", "entity", "insertAll", "load", "loadNonPrinted", "loadPhotoForPrint", "app_debug"})
@androidx.room.Dao()
public abstract interface PhotoDao {
    
    @androidx.room.Insert(onConflict = 1)
    public abstract void insertAll(@org.jetbrains.annotations.NotNull()
    java.util.List<com.omsai.omsai.db.Photo> entity);
    
    @androidx.room.Insert(onConflict = 1)
    public abstract void insert(@org.jetbrains.annotations.NotNull()
    com.omsai.omsai.db.Photo entity);
    
    @androidx.room.Query(value = "SELECT * FROM Photo")
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<com.omsai.omsai.db.Photo> load();
    
    @androidx.room.Query(value = "SELECT * FROM Photo where isprinted=\'false\'")
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<com.omsai.omsai.db.Photo> loadNonPrinted();
    
    @androidx.room.Query(value = "SELECT * FROM Photo where isprinted=0 limit 1")
    @org.jetbrains.annotations.NotNull()
    public abstract com.omsai.omsai.db.Photo loadPhotoForPrint();
    
    @androidx.room.Query(value = "Delete FROM Photo")
    public abstract void deleteCompanyDocument();
    
    @androidx.room.Query(value = "SELECT * FROM Photo ORDER BY isprinted , time DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.omsai.omsai.db.Photo>> getAllPhotos();
    
    @androidx.room.Query(value = "SELECT * FROM Photo where isPhoto=\'false\' AND msg=:msg1 AND filename =:name")
    @org.jetbrains.annotations.Nullable()
    public abstract com.omsai.omsai.db.Photo getMSG(@org.jetbrains.annotations.NotNull()
    java.lang.String msg1, @org.jetbrains.annotations.NotNull()
    java.lang.String name);
}