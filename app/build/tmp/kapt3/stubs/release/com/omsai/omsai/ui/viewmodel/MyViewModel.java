package com.omsai.omsai.ui.viewmodel;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0018\u00010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0006\u0010\f\u001a\u00020\rJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0012\u00a8\u0006\u0013"}, d2 = {"Lcom/omsai/omsai/ui/viewmodel/MyViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "getUsers", "Landroidx/lifecycle/LiveData;", "", "Lcom/omsai/omsai/db/Photo;", "getDate", "Ljava/util/Date;", "time", "", "markAllASPrint", "Lkotlinx/coroutines/Job;", "print", "", "photo", "job", "Lcom/omsai/omsai/utils/PrintingUtils$PrintJob;", "app_release"})
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