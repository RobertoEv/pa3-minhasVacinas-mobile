package com.jry.minhasvacinas

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit_perfil.*

class EditPerfilActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_perfil)

        cancelarEditarPerfilButton.setOnClickListener {
            var cancelarEditarPerfilIntent = Intent(this, PerfilActivity::class.java)
            startActivity(cancelarEditarPerfilIntent)
        }
    }
}
