package com.example.cp3

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListaPokemonActivity : AppCompatActivity() {

    private lateinit var recyclerViewPokemon: RecyclerView
    private lateinit var pokemonAdapter: PokemonAdapter
    private lateinit var db: MyDataBase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_pokemon)

        // Banco de dados
        db = MyDataBase(this)

        // referência para a RecyclerView
        recyclerViewPokemon = findViewById(R.id.recyclerViewPokemon)

        // layout da RecyclerView
        recyclerViewPokemon.layoutManager = LinearLayoutManager(this)

        // ItemAnimator RecyclerView
        recyclerViewPokemon.itemAnimator = DefaultItemAnimator()

        // Adaptador da RecyclerView (com os listeners)
        pokemonAdapter = PokemonAdapter(db.getAllPokemon(),
            { pokemon -> editarPokemon(pokemon) }, // Listener para editar
            { pokemon -> excluirPokemon(pokemon) } // Listener para excluir
        )

        // Adaptador na RecyclerView
        recyclerViewPokemon.adapter = pokemonAdapter
    }

    // Função para editar um Pokémon
    private fun editarPokemon(pokemon: Pokemon) {
        // Intent para iniciar a FormularioActivity
        val intent = Intent(this, FormularioActivity::class.java)
        intent.putExtra("pokemonId", pokemon.id)
        startActivity(intent)
    }

    // Função para excluir um Pokémon
    private fun excluirPokemon(pokemon: Pokemon) {
        // Exclusão do Pokémon do banco de dados
        db.deletePokemon(pokemon.id)
        // Atualização a RecyclerView
        pokemonAdapter.updatePokemonList(db.getAllPokemon())
    }
}