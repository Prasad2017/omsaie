package com.omsai.omsai.utils;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0015B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\bJ\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u00a8\u0006\u0016"}, d2 = {"Lcom/omsai/omsai/utils/PrintingUtils;", "", "()V", "printPhoto2", "", "photo", "Lcom/omsai/omsai/db/Photo;", "listener", "Lcom/omsai/omsai/utils/PrintingUtils$PrintJob;", "printText", "scanFiles", "Lkotlinx/coroutines/Job;", "sendToPrint", "intent", "Landroid/content/Intent;", "showDialog", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "action", "Lcom/omsai/omsai/utils/SingleActionListener;", "PrintJob", "app_debug"})
public final class PrintingUtils {
    @org.jetbrains.annotations.NotNull()
    public static final com.omsai.omsai.utils.PrintingUtils INSTANCE = null;
    
    private PrintingUtils() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job scanFiles() {
        return null;
    }
    
    public final void printPhoto2(@org.jetbrains.annotations.NotNull()
    com.omsai.omsai.db.Photo photo, @org.jetbrains.annotations.NotNull()
    com.omsai.omsai.utils.PrintingUtils.PrintJob listener) {
    }
    
    public final void printText(@org.jetbrains.annotations.NotNull()
    com.omsai.omsai.db.Photo photo, @org.jetbrains.annotations.NotNull()
    com.omsai.omsai.utils.PrintingUtils.PrintJob listener) {
    }
    
    /**
     * Checks and if the application is not installed, then offers to download it from the Play Market
     */
    public final void sendToPrint(@org.jetbrains.annotations.NotNull()
    android.content.Intent intent, @org.jetbrains.annotations.NotNull()
    com.omsai.omsai.utils.PrintingUtils.PrintJob listener) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.app.Dialog showDialog(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    com.omsai.omsai.utils.SingleActionListener action) {
        return null;
    }
    
    /**
     * add in manifest :
     * <uses-permission android:name="ru.a402d.rawbtprinter.PERMISSION"></uses-permission>
     */
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&\u00a8\u0006\u0005"}, d2 = {"Lcom/omsai/omsai/utils/PrintingUtils$PrintJob;", "", "OnFail", "", "OnSuccessful", "app_debug"})
    public static abstract interface PrintJob {
        
        public abstract void OnSuccessful();
        
        public abstract void OnFail();
    }
}