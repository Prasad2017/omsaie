package com.omsai.omsai.service;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 %2\u00020\u0001:\u0001%B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\"\u0010\u0015\u001a\u00020\u00162\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0017J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\u0010\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u0014H\u0016J\b\u0010\u001e\u001a\u00020\u001aH\u0002J\b\u0010\u001f\u001a\u00020\u001aH\u0002J\b\u0010 \u001a\u00020\u001aH\u0002J\b\u0010!\u001a\u00020\"H\u0002J\u0006\u0010#\u001a\u00020\u001aJ\u0006\u0010$\u001a\u00020\u001aR\u0014\u0010\u0004\u001a\b\u0018\u00010\u0005R\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006&"}, d2 = {"Lcom/omsai/omsai/service/EndlessService;", "Landroid/app/Service;", "<init>", "()V", "wakeLock", "Landroid/os/PowerManager$WakeLock;", "Landroid/os/PowerManager;", "handlerFileScan", "Landroid/os/Handler;", "handlerPrintPhoto", "getHandlerPrintPhoto", "()Landroid/os/Handler;", "runnableFileScanTask", "Ljava/lang/Runnable;", "runnablePrintTask", "getRunnablePrintTask", "()Ljava/lang/Runnable;", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onStartCommand", "", "flags", "startId", "onCreate", "", "onDestroy", "onTaskRemoved", "rootIntent", "startService", "stopService", "pingFakeServer", "createNotification", "Landroid/app/Notification;", "sycn", "printPhotoAuto", "Companion", "app_release"})
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
    
    @kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/omsai/omsai/service/EndlessService$Companion;", "", "<init>", "()V", "isServiceStarted", "", "()Z", "setServiceStarted", "(Z)V", "INTERVAL_SCAN", "", "getINTERVAL_SCAN", "()I", "INTERVAL_PRINT", "getINTERVAL_PRINT", "app_release"})
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