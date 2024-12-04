package com.omsai.omsai.ui.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0014\u0010\u0007\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0018\u00010\bJ\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011\u00a8\u0006\u0012"}, d2 = {"Lcom/omsai/omsai/ui/viewmodel/MyViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "getDate", "Ljava/util/Date;", "time", "", "getUsers", "Landroidx/lifecycle/LiveData;", "", "Lcom/omsai/omsai/db/Photo;", "markAllASPrint", "Lkotlinx/coroutines/Job;", "print", "", "photo", "job", "Lcom/omsai/omsai/utils/PrintingUtils$PrintJob;", "app_debug"})
public final class MyViewModel extends androidx.lifecycle.ViewModel {
    
    public MyViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final androidx.lifecycle.LiveData<java.util.List<com.omsai.omsai.db.Photo>> getUsers() {
        return null;
    }
    
    @android.annotation.SuppressLint(value = {"SimpleDateFormat"})
    @org.jetbrains.annotations.NotNull()
    public final java.util.Date getDate(long time) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job markAllASPrint() {
        return null;
    }
    
    public final void print(@org.jetbrains.annotations.NotNull()
    com.omsai.omsai.db.Photo photo, @org.jetbrains.annotations.NotNull()
    com.omsai.omsai.utils.PrintingUtils.PrintJob job) {
    }
}