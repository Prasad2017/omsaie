package com.omsai.omsai.service;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u0000 $2\u00020\u0001:\u0001$B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0017J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\"\u0010\u0019\u001a\u00020\u001a2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001aH\u0016J\u0010\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u0015H\u0016J\b\u0010\u001f\u001a\u00020\u0017H\u0002J\u0006\u0010 \u001a\u00020\u0017J\b\u0010!\u001a\u00020\u0017H\u0002J\b\u0010\"\u001a\u00020\u0017H\u0002J\u0006\u0010#\u001a\u00020\u0017R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\b\u0018\u00010\u000eR\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006%"}, d2 = {"Lcom/omsai/omsai/service/EndlessService;", "Landroid/app/Service;", "()V", "handlerFileScan", "Landroid/os/Handler;", "handlerPrintPhoto", "getHandlerPrintPhoto", "()Landroid/os/Handler;", "runnableFileScanTask", "Ljava/lang/Runnable;", "runnablePrintTask", "getRunnablePrintTask", "()Ljava/lang/Runnable;", "wakeLock", "Landroid/os/PowerManager$WakeLock;", "Landroid/os/PowerManager;", "createNotification", "Landroid/app/Notification;", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onCreate", "", "onDestroy", "onStartCommand", "", "flags", "startId", "onTaskRemoved", "rootIntent", "pingFakeServer", "printPhotoAuto", "startService", "stopService", "sycn", "Companion", "app_debug"})
public final class EndlessService extends android.app.Service {
    private static boolean isServiceStarted = false;
    private static final int INTERVAL_SCAN = 5000;
    private static final int INTERVAL_PRINT = 2500;
    @org.jetbrains.annotations.Nullable()
    private android.os.PowerManager.WakeLock wakeLock;
    @org.jetbrains.annotations.NotNull()
    private final android.os.Handler handlerFileScan = null;
    @org.jetbrains.annotations.NotNull()
    private final android.os.Handler handlerPrintPhoto = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.Runnable runnableFileScanTask = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.Runnable runnablePrintTask = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.omsai.omsai.service.EndlessService.Companion Companion = null;
    
    public EndlessService() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.os.Handler getHandlerPrintPhoto() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Runnable getRunnablePrintTask() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public android.os.IBinder onBind(@org.jetbrains.annotations.NotNull()
    android.content.Intent intent) {
        return null;
    }
    
    @java.lang.Override()
    public int onStartCommand(@org.jetbrains.annotations.Nullable()
    android.content.Intent intent, int flags, int startId) {
        return 0;
    }
    
    @java.lang.Override()
    @android.annotation.SuppressLint(value = {"ForegroundServiceType"})
    public void onCreate() {
    }
    
    @java.lang.Override()
    public void onDestroy() {
    }
    
    @java.lang.Override()
    public void onTaskRemoved(@org.jetbrains.annotations.NotNull()
    android.content.Intent rootIntent) {
    }
    
    private final void startService() {
    }
    
    private final void stopService() {
    }
    
    private final void pingFakeServer() {
    }
    
    private final android.app.Notification createNotification() {
        return null;
    }
    
    public final void sycn() {
    }
    
    public final void printPhotoAuto() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u000e"}, d2 = {"Lcom/omsai/omsai/service/EndlessService$Companion;", "", "()V", "INTERVAL_PRINT", "", "getINTERVAL_PRINT", "()I", "INTERVAL_SCAN", "getINTERVAL_SCAN", "isServiceStarted", "", "()Z", "setServiceStarted", "(Z)V", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        public final boolean isServiceStarted() {
            return false;
        }
        
        public final void setServiceStarted(boolean p0) {
        }
        
        public final int getINTERVAL_SCAN() {
            return 0;
        }
        
        public final int getINTERVAL_PRINT() {
            return 0;
        }
    }
}