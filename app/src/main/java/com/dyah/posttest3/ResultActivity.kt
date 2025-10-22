package com.dyah.posttest3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dyah.posttest3.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fullName = intent.getStringExtra("FULL_NAME")
        val username = intent.getStringExtra("USERNAME")
        val age = intent.getStringExtra("AGE")
        val email = intent.getStringExtra("EMAIL")
        val gender = intent.getStringExtra("GENDER")

        binding.apply {
            tampilNama.text = "Full Name: $fullName"
            tampilUsername.text = "Username: $username"
            tampilUmur.text = "Age: $age"
            tampilEmail.text = "Email: $email"
            tampilGender.text = "Gender: $gender"
        }
    }
}
