package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth

class FormCadastro : AppCompatActivity() {
    private lateinit var edit_nome: EditText
    private lateinit var edit_email: EditText
    private lateinit var edit_senha: EditText
    private lateinit var btnCadastrar: Button
    private lateinit var usuarioID: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_cadastro)
        getSupportActionBar()?.hide()

        edit_nome = findViewById(R.id.edit_nome)
        edit_email = findViewById(R.id.edit_email)
        edit_senha = findViewById(R.id.edit_password)
        btnCadastrar = findViewById(R.id.bt_cadastro)

        btnCadastrar.setOnClickListener {
            val nome = edit_nome.text.toString().trim()
            val email = edit_email.text.toString().trim()
            val senha = edit_senha.text.toString().trim()

            if (nome.isBlank() || email.isBlank() || senha.isBlank()) {
                val mensagemErro = "Campos não preenchidos, tente novamente."
                val snackBar = Snackbar.make(it, mensagemErro, Snackbar.LENGTH_LONG)
                snackBar.show()
            } else {
                cadastrarUsuario(it)
            }
        }
    }

    fun cadastrarUsuario(it: View) {
        val email = edit_email.text.toString().trim()
        val senha = edit_senha.text.toString().trim()
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, senha)
        .addOnCompleteListener { task ->
            var mensagem = "Cadastro realizado com sucesso."
            if (!task.isSuccessful) {
                salvarUsuario()
                mensagem = "Erro ao cadastrar usuário."
            }
            val snackBar = Snackbar.make(it, mensagem, Snackbar.LENGTH_LONG)
            snackBar.show()
        }
    }

    fun salvarUsuario() {
        val nome = edit_nome.text.toString().trim()

        /*val db = FirebaseFirestore.getInstance()
        val usuarios = hashMapOf(
            "nome" to nome
        )
        val usuarioID = FirebaseAuth.getInstance().currentUser?.uid

        if (usuarioID != null) {
            db.collection("usuarios")
                .add(usuarios)
                .addOnSuccessListener { documentReference ->
                    println("Documento adicionado com ID: ${documentReference.id}")
                }
                .addOnFailureListener { e ->
                    println("Documento adicionado com ID: $e")
                }
        } else {
            println("Usuário não autenticado")
        }*/
    }
}