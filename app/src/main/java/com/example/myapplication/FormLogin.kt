package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth

class FormLogin : AppCompatActivity() {
    private lateinit var email_login: EditText
    private lateinit var edit_senha: EditText
    private lateinit var bt_entrada: Button
    private lateinit var progressbar: ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_login)
        // hide toolbar
        getSupportActionBar()?.hide();

        IniciarComponentes()
        val linkFormCadastro = findViewById<TextView>(R.id.text_tela_cadastro)
        linkFormCadastro.setOnClickListener() {
            val telaCadastro = Intent(this, FormCadastro::class.java)
            startActivity(telaCadastro)
        }

        bt_entrada.setOnClickListener() {
            val email = email_login.text.toString()
            val senha = edit_senha.text.toString()

            if (email.isBlank() || senha.isBlank()) {
                val mensagemErro = "Campos não preenchidos, tente novamente."
                val snackBar = Snackbar.make(it, mensagemErro, Snackbar.LENGTH_LONG)
                snackBar.show()
            } else {
                AutenticarUsuario()
            }
        }
    }

    fun AutenticarUsuario() {
        val email = email_login.text.toString()
        val senha = edit_senha.text.toString()

        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, senha).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                progressbar.visibility = View.GONE
                val user = FirebaseAuth.getInstance().currentUser

                val intent = Intent(this@FormLogin, TelaPerfil::class.java)
                startActivity(intent)
                finish()
            } else {
                task.exception?.message?.let { mensagemErro ->
                    Snackbar.make(
                        findViewById(android.R.id.content),
                        "Erro ao autenticar usuário: $mensagemErro",
                        Snackbar.LENGTH_LONG
                    ).show()
                }
            }
        }
    }

    fun IniciarComponentes() {
        email_login = findViewById(R.id.email_login)
        edit_senha = findViewById(R.id.edit_password)
        bt_entrada = findViewById(R.id.bt_entrada)
        progressbar = findViewById(R.id.progressbar)
    }
}