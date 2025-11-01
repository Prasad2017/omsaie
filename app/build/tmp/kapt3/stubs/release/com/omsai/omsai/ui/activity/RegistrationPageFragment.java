package com.omsai.omsai.ui.activity;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J\b\u0010\u0015\u001a\u00020\u0012H\u0002J\b\u0010\u0016\u001a\u00020\u0012H\u0002J\u0018\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0005H\u0002J\u0018\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0005H\u0002J\b\u0010\u001c\u001a\u00020\u0012H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082D\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\"\u0010\f\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00050\rj\n\u0012\u0006\u0012\u0004\u0018\u00010\u0005`\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/omsai/omsai/ui/activity/RegistrationPageFragment;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "NODE_ONE_DEVICE", "", "TABLE_KEY", "TABLE_USER", "mDatabase", "Lcom/google/firebase/database/FirebaseDatabase;", "mDatabaseRef", "Lcom/google/firebase/database/DatabaseReference;", "serverKeyList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "binding", "Lcom/omsai/omsai/databinding/RegistrationBinding;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "checkExistingUser", "handleInvalidKey", "addNewUser", "userKey", "userName", "removeAllUsers", "serverKey", "navigateToLoginActivity", "app_release"})
public final class RegistrationPageFragment extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String NODE_ONE_DEVICE = "one_device";
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String TABLE_KEY = "newkey";
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String TABLE_USER = "new_users";
    @org.jetbrains.annotations.Nullable()
    private com.google.firebase.database.FirebaseDatabase mDatabase;
    @org.jetbrains.annotations.Nullable()
    private com.google.firebase.database.DatabaseReference mDatabaseRef;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<java.lang.String> serverKeyList;
    private com.omsai.omsai.databinding.RegistrationBinding binding;
    
    public RegistrationPageFragment() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void checkExistingUser() {
    }
    
    private final void handleInvalidKey() {
    }
    
    private final void addNewUser(java.lang.String userKey, java.lang.String userName) {
    }
    
    private final void removeAllUsers(java.lang.String serverKey, java.lang.String userName) {
    }
    
    private final void navigateToLoginActivity() {
    }
}