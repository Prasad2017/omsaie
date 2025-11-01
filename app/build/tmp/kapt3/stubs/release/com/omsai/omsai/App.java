package com.omsai.omsai;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0017\u00a8\u0006\u0007"}, d2 = {"Lcom/omsai/omsai/App;", "Landroid/app/Application;", "<init>", "()V", "onCreate", "", "Companion", "app_release"})
public final class App extends android.app.Application {
    @org.jetbrains.annotations.Nullable()
    private static android.os.PowerManager p;
    @org.jetbrains.annotations.Nullable()
    private static android.os.PowerManager.WakeLock wake;
    @org.jetbrains.annotations.Nullable()
    private static android.content.Context ctx;
    @org.jetbrains.annotations.Nullable()
    private static java.lang.Integer colorPending;
    @org.jetbrains.annotations.Nullable()
    private static java.lang.Integer colorDone;
    @org.jetbrains.annotations.Nullable()
    private static com.omsai.omsai.db.PhotoDatabase db;
    private static boolean isValidKey = false;
    @org.jetbrains.annotations.Nullable()
    private static com.omsai.omsai.db.PhotoDao daoPhoto;
    @org.jetbrains.annotations.Nullable()
    private static com.omsai.omsai.db.Photo photo;
    @org.jetbrains.annotations.NotNull()
    public static final com.omsai.omsai.App.Companion Companion = null;
    
    public App() {
        super();
    }
    
    @java.lang.Override()
    @android.annotation.SuppressLint(value = {"InvalidWakeLockTag"})
    public void onCreate() {
    }
    
    @kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\b\u00108\u001a\u0004\u0018\u00010\u0013J\b\u00109\u001a\u0004\u0018\u00010#R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\f\u001a\b\u0018\u00010\rR\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001f\u001a\u0004\u0018\u00010\u0019X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b \u0010\u001b\"\u0004\b!\u0010\u001dR\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010\'R\u001a\u0010(\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010,\u001a\u0004\u0018\u00010-X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001c\u00102\u001a\u0004\u0018\u000103X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107\u00a8\u0006:"}, d2 = {"Lcom/omsai/omsai/App$Companion;", "", "<init>", "()V", "isActiveMode", "", "p", "Landroid/os/PowerManager;", "getP", "()Landroid/os/PowerManager;", "setP", "(Landroid/os/PowerManager;)V", "wake", "Landroid/os/PowerManager$WakeLock;", "getWake", "()Landroid/os/PowerManager$WakeLock;", "setWake", "(Landroid/os/PowerManager$WakeLock;)V", "ctx", "Landroid/content/Context;", "getCtx", "()Landroid/content/Context;", "setCtx", "(Landroid/content/Context;)V", "colorPending", "", "getColorPending", "()Ljava/lang/Integer;", "setColorPending", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "colorDone", "getColorDone", "setColorDone", "db", "Lcom/omsai/omsai/db/PhotoDatabase;", "getDb", "()Lcom/omsai/omsai/db/PhotoDatabase;", "setDb", "(Lcom/omsai/omsai/db/PhotoDatabase;)V", "isValidKey", "()Z", "setValidKey", "(Z)V", "daoPhoto", "Lcom/omsai/omsai/db/PhotoDao;", "getDaoPhoto", "()Lcom/omsai/omsai/db/PhotoDao;", "setDaoPhoto", "(Lcom/omsai/omsai/db/PhotoDao;)V", "photo", "Lcom/omsai/omsai/db/Photo;", "getPhoto", "()Lcom/omsai/omsai/db/Photo;", "setPhoto", "(Lcom/omsai/omsai/db/Photo;)V", "getContext", "getDatabase", "app_release"})
    @android.annotation.SuppressLint(value = {"StaticFieldLeak"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        public final boolean isActiveMode() {
            return false;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final android.os.PowerManager getP() {
            return null;
        }
        
        public final void setP(@org.jetbrains.annotations.Nullable()
        android.os.PowerManager p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final android.os.PowerManager.WakeLock getWake() {
            return null;
        }
        
        public final void setWake(@org.jetbrains.annotations.Nullable()
        android.os.PowerManager.WakeLock p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final android.content.Context getCtx() {
            return null;
        }
        
        public final void setCtx(@org.jetbrains.annotations.Nullable()
        android.content.Context p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Integer getColorPending() {
            return null;
        }
        
        public final void setColorPending(@org.jetbrains.annotations.Nullable()
        java.lang.Integer p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Integer getColorDone() {
            return null;
        }
        
        public final void setColorDone(@org.jetbrains.annotations.Nullable()
        java.lang.Integer p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final com.omsai.omsai.db.PhotoDatabase getDb() {
            return null;
        }
        
        public final void setDb(@org.jetbrains.annotations.Nullable()
        com.omsai.omsai.db.PhotoDatabase p0) {
        }
        
        public final boolean isValidKey() {
            return false;
        }
        
        public final void setValidKey(boolean p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final com.omsai.omsai.db.PhotoDao getDaoPhoto() {
            return null;
        }
        
        public final void setDaoPhoto(@org.jetbrains.annotations.Nullable()
        com.omsai.omsai.db.PhotoDao p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final com.omsai.omsai.db.Photo getPhoto() {
            return null;
        }
        
        public final void setPhoto(@org.jetbrains.annotations.Nullable()
        com.omsai.omsai.db.Photo p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final android.content.Context getContext() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final com.omsai.omsai.db.PhotoDatabase getDatabase() {
            return null;
        }
    }
}