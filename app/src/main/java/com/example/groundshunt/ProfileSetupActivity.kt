package com.yourpackage.groundshunt

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.example.groundshunt.R
// import com.example.groundshunt.R is removed for package consistency

class ProfileSetupActivity : AppCompatActivity() {

    private lateinit var cardPlayer: CardView
    private lateinit var cardOwner: CardView
    private lateinit var btnComplete: Button
    private lateinit var inputName: EditText
    private lateinit var inputPhone: EditText

    private var selectedRole: String = "PLAYER"

    private val accentBorderDrawable = R.drawable.input_dropdown_bg
    private val darkBgDrawable = R.drawable.input_dark_bg

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_setup)


        cardPlayer = findViewById(R.id.card_player)
        cardOwner = findViewById(R.id.card_owner)
        btnComplete = findViewById(R.id.btn_complete_profile)
        inputName = findViewById(R.id.input_full_name)
        inputPhone = findViewById(R.id.input_phone_number)


        updateRoleSelectionUI(cardPlayer)


        cardPlayer.setOnClickListener {
            selectedRole = "PLAYER"
            updateRoleSelectionUI(cardPlayer)
        }
        cardOwner.setOnClickListener {
            selectedRole = "OWNER"
            updateRoleSelectionUI(cardOwner)
        }

        btnComplete.setOnClickListener {
            if (validateForm()) {
                saveProfileData() // ⬅️ This now saves the data
                navigateToMainActivity()
            }
        }
    }

    private fun updateRoleSelectionUI(activeCard: CardView) {
        cardPlayer.setBackgroundResource(darkBgDrawable)
        cardOwner.setBackgroundResource(darkBgDrawable)

        if (activeCard == cardPlayer) {
            cardPlayer.setBackgroundResource(accentBorderDrawable)
        } else {
            cardOwner.setBackgroundResource(accentBorderDrawable)
        }
    }

    private fun validateForm(): Boolean {
        if (inputName.text.isBlank()) {
            inputName.error = "Full Name is required"
            return false
        }
        if (inputPhone.text.length < 10) {
            inputPhone.error = "Enter a valid Phone Number"
            return false
        }
        return true
    }

    private fun saveProfileData() {
        val name = inputName.text.toString()
        val phone = inputPhone.text.toString()

        val sharedPref = getSharedPreferences("GroundsHunt_Prefs", Context.MODE_PRIVATE)

        // 2. Write the data
        with(sharedPref.edit()) {
            putString("USER_NAME", name)
            putString("USER_ROLE", selectedRole)
            putString("USER_PHONE", phone)
            apply() // Apply saves the changes asynchronously
        }

        Toast.makeText(this, "Profile Saved: $name ($selectedRole)", Toast.LENGTH_SHORT).show()
    }

    private fun navigateToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)



        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish()
    }
}
