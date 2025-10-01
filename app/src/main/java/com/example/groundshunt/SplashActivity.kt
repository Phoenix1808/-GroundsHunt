package com.example.groundshunt

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import android.widget.TextView
import android.view.animation.AnimationUtils

import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        val logo = findViewById<ImageView>(R.id.logo)
        val appName = findViewById<TextView>(R.id.appName)
        val tagline = findViewById<TextView>(R.id.tagline)


        val fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        val scaleUp = AnimationUtils.loadAnimation(this, R.anim.scale_up)
        val slideUp = AnimationUtils.loadAnimation(this, R.anim.slide_up)


        logo.startAnimation(scaleUp)
        appName.startAnimation(fadeIn)
        tagline.startAnimation(slideUp)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, com.yourpackage.groundshunt.SignUpActivity::class.java))
            finish()
        }, 3000)
    }
}
