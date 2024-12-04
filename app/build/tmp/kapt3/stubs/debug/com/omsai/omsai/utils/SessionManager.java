package com.omsai.omsai.utils;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/omsai/omsai/utils/SessionManager;", "", "()V", "Companion", "app_debug"})
public final class SessionManager {
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SIZE_A4 = "a4";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SIZE_4x6 = "4x6";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_TOKEN = "TOKEN";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_USER_NAME = "user";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_USER_ID = "userID";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_KEY = "key";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_IS_LOGOUT = "ISLOGOUT";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_SIZE = "size";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_COUNT = "count";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_COUNT_T = "count_T";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String PREF_NAME = "mobiledev_auto_print";
    @org.jetbrains.annotations.NotNull()
    private static android.content.SharedPreferences pref;
    @org.jetbrains.annotations.NotNull()
    private static android.content.SharedPreferences.Editor editor;
    @org.jetbrains.annotations.NotNull()
    public static final com.omsai.omsai.utils.SessionManager.Companion Companion = null;
    
    public SessionManager() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u001d\u001a\u00020\u0004J\u0006\u0010\u001e\u001a\u00020\u001fJ\u0006\u0010 \u001a\u00020\u001fJ\u0006\u0010!\u001a\u00020\u0004J\u0006\u0010\"\u001a\u00020\u0004J\u0006\u0010#\u001a\u00020\u0004J\u0010\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\'\u001a\u00020(2\u0006\u0010&\u001a\u00020\u001fJ\u0006\u0010)\u001a\u00020\u0001J\u0006\u0010*\u001a\u00020\u0001J\u000e\u0010+\u001a\u00020(2\u0006\u0010,\u001a\u00020\u001fJ\u0010\u0010-\u001a\u00020%2\b\u0010.\u001a\u0004\u0018\u00010\u0004J\u0010\u0010/\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0004J\u0010\u00100\u001a\u00020%2\b\u00101\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u00a8\u00062"}, d2 = {"Lcom/omsai/omsai/utils/SessionManager$Companion;", "", "()V", "KEY_COUNT", "", "KEY_COUNT_T", "KEY_IS_LOGOUT", "KEY_KEY", "KEY_SIZE", "KEY_TOKEN", "KEY_USER_ID", "KEY_USER_NAME", "PREF_NAME", "getPREF_NAME", "()Ljava/lang/String;", "SIZE_4x6", "SIZE_A4", "editor", "Landroid/content/SharedPreferences$Editor;", "getEditor", "()Landroid/content/SharedPreferences$Editor;", "setEditor", "(Landroid/content/SharedPreferences$Editor;)V", "pref", "Landroid/content/SharedPreferences;", "getPref", "()Landroid/content/SharedPreferences;", "setPref", "(Landroid/content/SharedPreferences;)V", "getKey", "getPrintCount", "", "getPrintCountT", "getToken", "getUserID", "getUserName", "setKey", "", "id", "setPrintCount", "", "setPrintCountAdd", "setPrintCountAddT", "setPrintCountT", "cnt", "setToken", "UUID", "setUserID", "setUserName", "name", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getPREF_NAME() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.content.SharedPreferences getPref() {
            return null;
        }
        
        public final void setPref(@org.jetbrains.annotations.NotNull()
        android.content.SharedPreferences p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.content.SharedPreferences.Editor getEditor() {
            return null;
        }
        
        public final void setEditor(@org.jetbrains.annotations.NotNull()
        android.content.SharedPreferences.Editor p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getToken() {
            return null;
        }
        
        public final void setToken(@org.jetbrains.annotations.Nullable()
        java.lang.String UUID) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getUserName() {
            return null;
        }
        
        public final void setUserName(@org.jetbrains.annotations.Nullable()
        java.lang.String name) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getUserID() {
            return null;
        }
        
        public final void setUserID(@org.jetbrains.annotations.Nullable()
        java.lang.String id) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getKey() {
            return null;
        }
        
        public final void setKey(@org.jetbrains.annotations.Nullable()
        java.lang.String id) {
        }
        
        public final long getPrintCount() {
            return 0L;
        }
        
        public final boolean setPrintCount(long id) {
            return false;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.Object setPrintCountAdd() {
            return null;
        }
        
        public final long getPrintCountT() {
            return 0L;
        }
        
        public final boolean setPrintCountT(long cnt) {
            return false;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.Object setPrintCountAddT() {
            return null;
        }
    }
}