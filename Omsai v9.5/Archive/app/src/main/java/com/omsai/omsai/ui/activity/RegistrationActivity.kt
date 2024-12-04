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
    private var NODE_ONE_DEVICE: String = "one_device"
    private var TABLE_KEY: String = "newkey"
    private var TABLE_USER: String = "new_users"
    private var mDatabase: FirebaseDatabase? = null
    private var mDatabaseRef: DatabaseReference? = null
    private var serverKeyList: ArrayList<String?> = ArrayList()
    private lateinit var binding: RegistrationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = RegistrationBinding.inflate(layoutInflater)
        val view: View = binding.getRoot() //Root xml or viewGroup will be a part of converted view over here
        setContentView(view)
        mDatabase = FirebaseDatabase.getInstance()//https://om-sai-95109-default-rtdb.firebaseio.com/
        mDatabaseRef = mDatabase?.reference

        mDatabaseRef?.child(TABLE_KEY)?.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                var isValid = false
                for (key in snapshot.children) {
                    val x = key.getValue(String::class.java)
                    serverKeyList.add(x)
                    if (x == SessionManager.getKey()) isValid = true
                }

                if (isValid) {
                    mDatabaseRef?.child(TABLE_USER)
                        ?.addListenerForSingleValueEvent(object : ValueEventListener {
                            override fun onDataChange(snapshot: DataSnapshot) {
                                var isValid2 = false
                                for (key in snapshot.children) {
                                    val x = key.getValue(UsersModel::class.java)
                                    if (x?.key == SessionManager.getKey() && x.uuid == SessionManager.getUserID()) isValid2 =
                                        true
                                }

                                if (isValid2) navigateToLoginActivity()
                                else {
                                    SessionManager.setUserID("")
                                    binding.layOne.visibility = View.GONE
                                    binding.layTwo.visibility = View.VISIBLE
                                }

                            }

                            override fun onCancelled(error: DatabaseError) {
                                Log.e("db20", error.message)
                                toast("Please check Network if you facing problem still then contact with developer Error - 20")
                            }
                        })
                } else {
                    SessionManager.setUserID("")

                    binding.layOne.visibility = View.GONE
                    binding.layTwo.visibility = View.VISIBLE
                }

            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("db15", error.message)
                toast("Please check Network if you facing problem still then contact with developer Error - 15")
            }
        })

        binding.buttonRegister.setOnClickListener {
            val userName = binding.editUsername.text.toString()
            val user_key = binding.editKey.text.toString()
            when {
                user_key.isEmpty() -> {
                    binding.editKey.error = "Please Enter Secrete Key"
                    binding.editKey.requestFocus()
                }

                !serverKeyList.contains(user_key) -> {
                    binding.editKey.error = "Please Enter Correct Secrete Key"
                    binding.editKey.requestFocus()
                }

                userName.isEmpty() -> {
                    binding.editUsername.error = "Please Enter Your Name"
                    binding.editUsername.requestFocus()
                }

                else -> {

                    mDatabaseRef?.child(NODE_ONE_DEVICE)
                        ?.addValueEventListener(object : ValueEventListener {
                            override fun onDataChange(snapshot: DataSnapshot) {
                                val isOneDevice = snapshot.value as String
                                if (isOneDevice == "true") removeAllUsers(user_key, userName)
                                else addNewUser(user_key, userName)
                            }

                            override fun onCancelled(error: DatabaseError) {
                                Log.e("db13", error.message)
                                toast("Please check Network if you facing problem still then contact with developer Error - 13")
                            }
                        })

                }
            }
        }

    }

    fun addNewUser(user_key: String, userName: String) {
        val usersModel = UsersModel()
        usersModel.uuid = UUID.randomUUID().toString()
        usersModel.uname = userName
        usersModel.token = SessionManager.getToken()
        usersModel.key = user_key
        usersModel.device = Build.MODEL
        SessionManager.setUserName(userName)
        SessionManager.setUserID(usersModel.uuid)
        SessionManager.setKey(user_key)
        App.isValidKey = true

        mDatabaseRef?.child(TABLE_USER)?.child(
            usersModel.uuid
                ?: ""
        )?.setValue(usersModel)
        navigateToLoginActivity()
    }

    fun removeAllUsers(serverKey: String, userName: String) {
        mDatabaseRef?.child(TABLE_USER)?.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                for (key in snapshot.children) {
                    val x = key.getValue(UsersModel::class.java)
                    if (x?.key == serverKey && x.uuid != SessionManager.getUserID()) mDatabaseRef?.child(
                        TABLE_USER
                    )?.child(key.key!!)?.removeValue()
                }
                if (SessionManager.getUserID().isEmpty()) addNewUser(serverKey, userName)
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("db12", error.message)
                toast("Please check Network if you facing problem still then contact with developer Error - 12")
            }
        })
    }

    private fun navigateToLoginActivity() {
        finish()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}