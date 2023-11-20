package com.example.firebase

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.firebase.databinding.ActivityMainBinding
import com.example.firebase.databinding.RegisterBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth

class register: AppCompatActivity() {
    lateinit var auth: FirebaseAuth;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)

        val binding: RegisterBinding = DataBindingUtil.setContentView(this, R.layout.register)
auth= FirebaseAuth.getInstance()
        binding.bRegister.setOnClickListener {
            val email=binding.emaill.text.toString();
            val password=binding.pwd.text.toString()
            // Function to show a toast message
            fun showToast(message: String) {
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
            }
            if (email.isEmpty()) {

                showToast("Email field is empty")
                return@setOnClickListener
            }

            if (password.isEmpty()) {

                showToast("Password field is empty")
                return@setOnClickListener
            }
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        showToast("Successful login")

                    } else {

                        Toast.makeText(
                            baseContext,
                            "Authentication failed.",
                            Toast.LENGTH_SHORT,
                        ).show()

                    }
                }
        }



    }






}