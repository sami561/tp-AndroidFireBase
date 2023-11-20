package com.example.firebase

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import com.example.firebase.databinding.ActivityMainBinding
import com.example.firebase.databinding.LoginBinding
import com.example.firebase.databinding.RegisterBinding
import com.google.firebase.auth.FirebaseAuth

class login  : AppCompatActivity(){
    lateinit var auth: FirebaseAuth;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)
        val binding: LoginBinding= DataBindingUtil.setContentView(this, R.layout.login)
        var auth = FirebaseAuth.getInstance()
        binding.bLogin.setOnClickListener{
            val email=binding.emaill.text.toString();
            val password=binding.pwd.text.toString();
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
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        showToast("login Successfuly")

                    } else {
                        // If sign in fails, display a message to the user.

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