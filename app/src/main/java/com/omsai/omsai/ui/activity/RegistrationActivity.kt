package com.omsai.omsai.ui.activity

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.omsai.omsai.App
import com.omsai.omsai.databinding.RegistrationBinding
import com.omsai.omsai.db.UsersModel
import com.omsai.omsai.utils.SessionManager
import com.omsai.omsai.utils.toast
import java.util.UUID

class RegistrationPageFragment : AppCompatActivity() {
    private val NODE_ONE_DEVICE: String = "one_device"
    private val TABLE_KEY: String = "newkey"
    private val TABLE_USER: String = "new_users"
    private var mDatabase: FirebaseDatabase? = null
    private var mDatabaseRef: DatabaseReference? = null
    private var serverKeyList: ArrayList<String?> = ArrayList()
    private lateinit var binding: RegistrationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = RegistrationBinding.inflate(layoutInflater)
        val view: View = binding.root // Root view of the layout
        setContentView(view)

        mDatabase = FirebaseDatabase.getInstance()
        mDatabaseRef = mDatabase?.reference

        // Fetch server keys
        mDatabaseRef?.child(TABLE_KEY)?.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                var isValid = false
                for (key in snapshot.children) {
                    val x = key.getValue(String::class.java)
                    serverKeyList.add(x)
                    if (x == SessionManager.getKey()) isValid = true
                }

                if (isValid) {
                    // Check if user exists in the database
                    checkExistingUser()
                } else {
                    handleInvalidKey()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("db15", error.message)
                toast("Please check Network if you are facing problems, otherwise contact the developer Error - 15")
            }
        })

        // Register button click handler
        binding.buttonRegister.setOnClickListener {
            val userName = binding.editUsername.text.toString()
            val userKey = binding.editKey.text.toString()

            when {
                userKey.isEmpty() -> {
                    binding.editKey.error = "Please Enter Secret Key"
                    binding.editKey.requestFocus()
                }

                !serverKeyList.contains(userKey) -> {
                    binding.editKey.error = "Please Enter Correct Secret Key"
                    binding.editKey.requestFocus()
                }

                userName.isEmpty() -> {
                    binding.editUsername.error = "Please Enter Your Name"
                    binding.editUsername.requestFocus()
                }

                else -> {
                    // Handle one-device check
                    mDatabaseRef?.child(NODE_ONE_DEVICE)
                        ?.addListenerForSingleValueEvent(object : ValueEventListener {
                            override fun onDataChange(snapshot: DataSnapshot) {
                                val isOneDevice = snapshot.getValue(String::class.java) == "true"
                                if (isOneDevice) {
                                    removeAllUsers(userKey, userName)
                                } else {
                                    addNewUser(userKey, userName)
                                }
                            }

                            override fun onCancelled(error: DatabaseError) {
                                Log.e("db13", error.message)
                                toast("Please check Network if you are facing problems, otherwise contact the developer Error - 13")
                            }
                        })
                }
            }
        }
    }

    private fun checkExistingUser() {
        mDatabaseRef?.child(TABLE_USER)
            ?.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    var isValid2 = false
                    for (key in snapshot.children) {
                        val user = key.getValue(UsersModel::class.java)
                        if (user?.key == SessionManager.getKey() && user.uuid == SessionManager.getUserID()) {
                            isValid2 = true
                        }
                    }

                    if (isValid2) {
                        navigateToLoginActivity()
                    } else {
                        SessionManager.setUserID("")
                        binding.layOne.visibility = View.GONE
                        binding.layTwo.visibility = View.VISIBLE
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    Log.e("db20", error.message)
                    toast("Please check Network if you are facing problems, otherwise contact the developer Error - 20")
                }
            })
    }

    private fun handleInvalidKey() {
        SessionManager.setUserID("")
        binding.layOne.visibility = View.GONE
        binding.layTwo.visibility = View.VISIBLE
    }

    private fun addNewUser(userKey: String, userName: String) {
        val usersModel = UsersModel()
        usersModel.uuid = UUID.randomUUID().toString()
        usersModel.uname = userName
        usersModel.token = SessionManager.getToken()
        usersModel.key = userKey
        usersModel.device = Build.MODEL

        SessionManager.apply {
            setUserName(userName)
            setUserID(usersModel.uuid)
            setKey(userKey)
        }
        App.isValidKey = true

        val userRef = mDatabaseRef?.child(TABLE_USER)?.child(usersModel.uuid!!)
        userRef?.setValue(usersModel)?.addOnCompleteListener { task ->
            if (task.isSuccessful) {
                navigateToLoginActivity()
                toast("User added successfully")
            } else {
                toast("Failed to add user")
                Log.e("addUser", "Failed to add user", task.exception)
            }
        }
    }

    private fun removeAllUsers(serverKey: String, userName: String) {
        mDatabaseRef?.child(TABLE_USER)
            ?.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    for (key in snapshot.children) {
                        val user = key.getValue(UsersModel::class.java)
                        if (user?.key == serverKey && user.uuid != SessionManager.getUserID()) {
                            mDatabaseRef?.child(TABLE_USER)?.child(key.key!!)?.removeValue()
                        }
                    }

                    if (SessionManager.getUserID().isEmpty()) {
                        addNewUser(serverKey, userName)
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    Log.e("db12", error.message)
                    toast("Please check Network if you are facing problems, otherwise contact the developer Error - 12")
                }
            })
    }

    private fun navigateToLoginActivity() {
        finish()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}
