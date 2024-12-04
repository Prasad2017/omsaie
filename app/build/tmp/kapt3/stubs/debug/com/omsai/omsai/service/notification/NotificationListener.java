package com.omsai.omsai.service.notification;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0005\u00a2\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0017\u00a8\u0006\u000f"}, d2 = {"Lcom/omsai/omsai/service/notification/NotificationListener;", "Landroid/service/notification/NotificationListenerService;", "()V", "addToDB", "Lkotlinx/coroutines/Job;", "name", "", "message", "last_row_id", "onListenerConnected", "", "onNotificationPosted", "sbn", "Landroid/service/notification/StatusBarNotification;", "Companion", "app_debug"})
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/omsai/omsai/service/notification/NotificationListener$Companion;", "", "()V", "TAG", "", "WA_PACKAGE", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}