package com.jry.minhasvacinas

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_esqueceu_senha.*

class EsqueceuSenhaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_esqueceu_senha)

        recuperarSenhaButtonId.setOnClickListener {
            var recuperarSenhaIntent = Intent(this, MainActivity::class.java)
            startActivity(recuperarSenhaIntent)
        }

        esqueceuASenhaCancelId.setOnClickListener {
            var esqueceuSenhaCancelIntent = Intent(this, MainActivity::class.java)
            startActivity(esqueceuSenhaCancelIntent)
        }
    }
}
