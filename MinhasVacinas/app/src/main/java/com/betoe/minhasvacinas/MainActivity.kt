package com.betoe.minhasvacinas

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var data = intent.extras
        Toast.makeText(this, data.get("email").toString(), Toast.LENGTH_SHORT).show()

        registerPetButton.setOnClickListener {
            startActivity(Intent(this, RegisterPetActivity::class.java))
        }

    }
}