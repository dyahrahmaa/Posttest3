package com.dyah.posttest3

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.dyah.posttest3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSubmit.setOnClickListener {
            val fullName = binding.inputFullName.text.toString()
            val username = binding.inputUsername.text.toString()
            val ageText = binding.inputAge.text.toString()
            val email = binding.inputEmail.text.toString()
            val password = binding.inputPassword.text.toString()
            val confirmPassword = binding.inputConfirmPassword.text.toString()

            val gender = if (binding.radioMale.isChecked) "Laki-laki" else "Perempuan"

            if (fullName.isEmpty() || username.isEmpty() || ageText.isEmpty() ||
                email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() || gender.isEmpty()
            ) {
                Toast.makeText(this, "Semua harus diisi, jangan kosong", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (!email.contains("@")) {
                Toast.makeText(this, "Email harus mengandung @", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val age = binding.inputAge.text.toString()

            if (ageText.isEmpty()) {
                Toast.makeText(this, "Age tidak boleh kosong", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val ageCek = if (ageText.all { it.isDigit() }) {
                ageText.toInt()
            } else {
                Toast.makeText(this, "Age harus angka, tidak boleh selain angka", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (password != confirmPassword) {
                Toast.makeText(this, "Password dan Confrim Password harus sama, tidak boleh beda", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent(this, ResultActivity::class.java).apply {
                putExtra("FULL_NAME", fullName)
                putExtra("USERNAME", username)
                putExtra("AGE", ageCek.toString())
                putExtra("EMAIL", email)
                putExtra("GENDER", gender)
            }
            startActivity(intent)
        }
    }
}