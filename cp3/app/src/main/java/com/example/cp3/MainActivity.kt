package com.example.cp3

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Hide system bars for edge-to-edge
        WindowCompat.setDecorFitsSystemWindows(window, false)
        WindowInsetsControllerCompat(window, window.decorView).let { controller ->
            controller.hide(WindowInsetsCompat.Type.systemBars())
            controller.systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        }

        window.decorView.setBackgroundColor(Color.WHITE)

        // Encontrar os botões no layout
        val botaoVerPokemon: Button = findViewById(R.id.button_view_pokemon)
        val botaoAdicionarPokemon: Button = findViewById(R.id.button_add_pokemon)
        val botaoDesenvolvedores: Button = findViewById(R.id.btnDesenvolvedores) // Adicione o botão

        // Configurar os listeners dos botões
        botaoVerPokemon.setOnClickListener {
            val intent = Intent(this, ListaPokemonActivity::class.java)
            startActivity(intent)
        }

        botaoAdicionarPokemon.setOnClickListener {
            // Lógica para abrir FormularioActivity
            val intent = Intent(this, FormularioActivity::class.java)
            startActivity(intent)
        }

        botaoDesenvolvedores.setOnClickListener {
            // Lógica para abrir IntegrantesActivity
            val intent = Intent(this, IntegrantesActivity::class.java)
            startActivity(intent)
        }
    }
}