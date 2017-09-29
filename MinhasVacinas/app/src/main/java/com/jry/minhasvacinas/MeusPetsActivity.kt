package com.jry.minhasvacinas

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_meus_pets.*

class MeusPetsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meus_pets)

        showPerfilId.setOnClickListener {
            var showPerfilIntent = Intent(this, PerfilActivity::class.java)
            startActivity(showPerfilIntent)
        }
    }
}
