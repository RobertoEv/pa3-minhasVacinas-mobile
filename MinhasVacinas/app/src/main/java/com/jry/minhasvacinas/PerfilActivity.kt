package com.jry.minhasvacinas

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_perfil.*

class PerfilActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)

        editarPerfilUsuarioId.setOnClickListener {
            var editarPerfilUsuarioIntent = Intent(this, EditPerfilActivity::class.java)
            startActivity(editarPerfilUsuarioIntent)
        }
    }
}
