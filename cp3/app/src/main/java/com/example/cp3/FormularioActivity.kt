package com.example.cp3

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class FormularioActivity : AppCompatActivity() {

    private lateinit var etNome: EditText
    private lateinit var etTipo: EditText
    private lateinit var etHabilidade: EditText
    private lateinit var etFraqueza: EditText
    private lateinit var etHp: EditText
    private lateinit var btnSalvar: Button
    private lateinit var db: MyDataBase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario_pokemon)

        // Inicializar os elementos do ConstraintLayout
        etNome = findViewById(R.id.etEditNome)
        etTipo = findViewById(R.id.etEditTipo)
        etHabilidade = findViewById(R.id.etEditHabilidade)
        etFraqueza = findViewById(R.id.etEditFraqueza)
        etHp = findViewById(R.id.etEditHp)
        btnSalvar = findViewById(R.id.btnSalvarEdicao)

        // Inicializar o banco de dados
        db = MyDataBase(this)

        // Adicionar o listener de click para o botão salvar
        btnSalvar.setOnClickListener {
            // Obter os valores dos campos de entrada
            val nome = etNome.text.toString()
            val tipo = etTipo.text.toString()
            val habilidade = etHabilidade.text.toString()
            val fraqueza = etFraqueza.text.toString()
            val hp = etHp.text.toString().toIntOrNull() ?: 0 // Obter o HP como Int, 0 se não for válido

            // Criar um novo objeto Pokemon
            val novoPokemon = Pokemon(nome = nome, tipo = tipo, habilidade = habilidade, fraqueza = fraqueza, hp = hp)

            // Salvar  Pokémon no banco de dados
            db.insertPokemon(novoPokemon)

            // Limpar os campos de entrada
            etNome.setText("")
            etTipo.setText("")
            etHabilidade.setText("")
            etFraqueza.setText("")
            etHp.setText("") // Limpe o campo de HP
        }
    }
}