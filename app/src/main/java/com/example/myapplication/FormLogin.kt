package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class FormLogin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_login)
        // hide toolbar
        getSupportActionBar()?.hide();

        val linkFormCadastro = findViewById<TextView>(R.id.text_tela_cadastro)
        linkFormCadastro.setOnClickListener() {
            val telaCadastro = Intent(this, FormCadastro::class.java)
            startActivity(telaCadastro)
        }

        val linkTela_Perfil = findViewById<TextView>(R.id.bt_entrada)
        linkTela_Perfil.setOnClickListener() {
            val telaPerfil = Intent(this, Tela_Perfil::class.java)
            startActivity(telaPerfil)
        }
    }
}