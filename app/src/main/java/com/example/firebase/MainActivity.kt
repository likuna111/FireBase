package com.example.firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var emailLogin : EditText
    private lateinit var passwordLogin : EditText
    private lateinit var buttonLogin : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        emailLogin = findViewById(R.id.emailLogin)
        passwordLogin = findViewById(R.id.passwordLogin)
        buttonLogin = findViewById(R.id.buttonLogin)

        buttonLogin.setOnClickListener {

            val email = emailLogin.text.toString()
            val password = passwordLogin.text.toString()

            if(email.isEmpty() || password.isEmpty() ) {

                Toast.makeText(this, "ცარრიელია" , Toast.LENGTH_SHORT).show()
                return@setOnClickListener

            }

            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener{ task->
                    if (task.isSuccessful){
                        Toast.makeText(this, "ოპერაცია წარმატებულია",Toast.LENGTH_SHORT).show()
                        finish()
                    }else{
                        Toast.makeText(this,"არასწორია!",Toast.LENGTH_SHORT).show()
                    }

                }

        }




    }
}