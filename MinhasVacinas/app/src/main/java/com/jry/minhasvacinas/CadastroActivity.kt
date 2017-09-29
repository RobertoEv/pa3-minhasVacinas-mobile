package com.jry.minhasvacinas

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_cadastro.*
import kotlinx.android.synthetic.main.activity_main.*

class CadastroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        confirmarCadastroButton.setOnClickListener {
            var confirmarCadastroIntent = Intent(this, MainActivity::class.java)
            startActivity(confirmarCadastroIntent)
        }

        cancelarCadastroButton.setOnClickListener {
            var cancelarCadastroIntent = Intent(this, MainActivity::class.java)
            startActivity(cancelarCadastroIntent)
        }
    }
}
