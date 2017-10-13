package com.betoe.minhasvacinas

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_register_pet.*

class RegisterPetActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_pet)

        registerPetCancelButton.setOnClickListener {
            finish()
        }

    }
}