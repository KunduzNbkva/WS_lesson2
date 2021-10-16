package com.example.ws_lesson2

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    lateinit var userEmailView: EditText
    lateinit var userPhoneView: EditText
    lateinit var userPasswordView: EditText
    lateinit var userREPasswordView: EditText
    lateinit var startView: Button

    lateinit var userEmail: String
    lateinit var userPhone: String
    lateinit var userPassword: String
    lateinit var userRePassword: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        startView.setOnClickListener { signUp() }
    }

    private fun initViews() {
        userEmailView = findViewById(R.id.editTextTextPersonEmail)
        userPhoneView = findViewById(R.id.editTextTextPersonPhone)
        userPasswordView = findViewById(R.id.editTextTextPersonPassword)
        userREPasswordView = findViewById(R.id.editTextTextPersonREPassword)
        startView = findViewById(R.id.btn_signup)
    }


    private fun signUp() {
        userEmail = userEmailView.text.toString()
        userPhone = userPhoneView.text.toString()
        userPassword = userPasswordView.text.toString()
        userRePassword = userREPasswordView.text.toString()
        checkForNull()
    }

    private fun checkForNull() {
        when (String()) {
            userEmail -> checkData(userEmail, getString(R.string.email))
            userPhone -> checkData(userPhone, getString(R.string.phone))
            userPassword -> checkData(userPassword, getString(R.string.password))
            userRePassword -> checkData(userRePassword, getString(R.string.re_password))
            else -> comparePasswords()
        }
    }

    private fun comparePasswords() {
        if (userRePassword != userPassword) {
            Snackbar.make(startView, "Your password is incorrect!", Snackbar.LENGTH_LONG).show()
        } else {
            buildAlertDialog()
            Handler(Looper.getMainLooper()).postDelayed({
                val intent = Intent(this@MainActivity, SecondActivity::class.java)
                intent.putExtra("email", userEmail)
                startActivity(intent)
                },
                1000
            )
        }
    }


    private fun checkData(data: String, outputText: String) {
        if (data.isBlank()) Toast.makeText(
            this,
            "Please set your $outputText!",
            Toast.LENGTH_SHORT
        )
            .show()
    }

    private fun buildAlertDialog() {
        AlertDialog.Builder(this)
            .setTitle("Congratulations!")
            .setMessage("You successfully signed up!")
            .create()
            .show()
    }
}
