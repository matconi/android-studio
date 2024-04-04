package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Tela_Perfil : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_perfil)

        getSupportActionBar()?.hide();

        val linkFormLogin = findViewById<TextView>(R.id.bt_sair)
        linkFormLogin.setOnClickListener() {
            val telaLogin = Intent(this, FormLogin::class.java)
            startActivity(telaLogin)
        }
    }
}