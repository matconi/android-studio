package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class TelaPerfil : AppCompatActivity() {
    private lateinit var edit_email: EditText
    private lateinit var edit_usuario: EditText
    private lateinit var bt_sair: Button
    private lateinit var db: FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_perfil)

        getSupportActionBar()?.hide();
        IniciarComponentes()
        bt_sair.setOnClickListener{
            FirebaseAuth.getInstance().signOut()
            val intent = Intent(this@TelaPerfil, FormLogin::class.java)
            startActivity(intent)
            finish()
        }
    }

    fun IniciarComponentes() {
        edit_email = findViewById(R.id.textEmailUser)
        edit_usuario = findViewById(R.id.textNomeUser)
        bt_sair = findViewById(R.id.bt_sair)
    }
}