package com.example.cp3

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class EditPokemonActivity : AppCompatActivity() {

    private lateinit var db: MyDataBase // Use sua classe MyDataBase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editar_pokemon)

        db = MyDataBase(this)

        val pokemonId = intent.getIntExtra("POKEMON_ID", -1)

        if (pokemonId == -1) {
            Toast.makeText(this, "ID do Pokémon inválido!", Toast.LENGTH_SHORT).show()
            finish()
            return
        }

        // Encontre os EditTexts pelo ID
        val etEditNome: EditText = findViewById(R.id.etEditNome)
        val etEditTipo: EditText = findViewById(R.id.etEditTipo)
        val etEditHabilidade: EditText = findViewById(R.id.etEditHabilidade)
        val etEditFraqueza: EditText = findViewById(R.id.etEditFraqueza)
        val btnSalvar: Button = findViewById(R.id.btnSalvarEdicao)

        // Preencha os EditTexts com os dados atuais do Pokémon
        val pokemon = db.getPokemonById(pokemonId) // Implemente esta função na MyDataBase

        if (pokemon != null) {
            etEditNome.setText(pokemon.nome)
            etEditTipo.setText(pokemon.tipo)
            etEditHabilidade.setText(pokemon.habilidade)
            etEditFraqueza.setText(pokemon.fraqueza)
        } else {
            Toast.makeText(this, "Pokémon não encontrado!", Toast.LENGTH_SHORT).show()
            finish()
            return
        }

        btnSalvar.setOnClickListener {
            val novoNome = etEditNome.text.toString()
            val novoTipo = etEditTipo.text.toString()
            val novaHabilidade = etEditHabilidade.text.toString()
            val novaFraqueza = etEditFraqueza.text.toString()

            // Atualize o Pokémon no banco de dados (Implemente updatePokemon na MyDataBase)
            val pokemonAtualizado =
                Pokemon(pokemonId, novoNome, novoTipo, novaHabilidade, novaFraqueza, pokemon.hp)
            val sucesso = db.updatePokemon(pokemonAtualizado)

            if (sucesso) {
                Toast.makeText(this, "Pokémon atualizado com sucesso!", Toast.LENGTH_SHORT).show()
                finish() // Fecha a Activity após salvar
            } else {
                Toast.makeText(this, "Erro ao atualizar o Pokémon!", Toast.LENGTH_SHORT).show()
            }
        }
    }}