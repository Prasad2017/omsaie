package com.omsai.omsai.service.notification;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0017J\"\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u0005H\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/omsai/omsai/service/notification/NotificationListener;", "Landroid/service/notification/NotificationListenerService;", "<init>", "()V", "onNotificationPosted", "", "sbn", "Landroid/service/notification/StatusBarNotification;", "addToDB", "Lkotlinx/coroutines/Job;", "name", "", "message", "last_row_id", "onListenerConnected", "Companion", "app_release"})
@androidx.annotation.RequiresApi(api = android.os.Build.VERSION_CODES.JELLY_BEAN_MR2)
@android.annotation.SuppressLint(value = {"OverrideAbstract"})
public final class NotificationListener extends android.service.notification.NotificationListenerService {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "NotificationListener";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String WA_PACKAGE = "com.whatsapp";
    @org.jetbrains.annotations.NotNull()
    public static final com.omsai.omsai.service.notification.NotificationListener.Companion Companion = null;
    
    public NotificationListener() {
        super();
    }
    
    @java.lang.Override()
    @androidx.annotation.RequiresApi(api = android.os.Build.VERSION_CODES.KITKAT)
    public void onNotificationPosted(@org.jetbrains.annotations.NotNull()
    android.service.notification.StatusBarNotification sbn) {
    }
    
    private final kotlinx.coroutines.Job addToDB(java.lang.String name, java.lang.String message, java.lang.String last_row_id) {
        return null;
    }
    
    @java.lang.Override()
    public void onListenerConnected() {
    }
    
    @kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/omsai/omsai/service/notification/NotificationListener$Companion;", "", "<init>", "()V", "TAG", "", "WA_PACKAGE", "app_release"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}