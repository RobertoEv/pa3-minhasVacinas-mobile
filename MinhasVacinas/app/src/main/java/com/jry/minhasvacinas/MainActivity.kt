package com.jry.minhasvacinas

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loginButton.setOnClickListener {
            var loginIntent = Intent(this, MeusPetsActivity::class.java)
            startActivity(loginIntent)
        }

        cadastroButton.setOnClickListener {
            var cadastroIntent = Intent(this, CadastroActivity::class.java)
            startActivity(cadastroIntent)
        }

        esqueceuASenhaId.setOnClickListener{
            var esqueceuSenhaIntent = Intent(this, EsqueceuSenhaActivity::class.java)
            startActivity(esqueceuSenhaIntent)
        }


    }
}
