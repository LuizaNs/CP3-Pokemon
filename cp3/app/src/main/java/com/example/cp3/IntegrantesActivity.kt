package com.example.cp3

import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class IntegrantesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_integrantes)

        val tvNomesDesenvolvedores = findViewById<TextView>(R.id.tvNomesDesenvolvedores)

        // Configure o texto do TextView com os nomes dos desenvolvedores
        tvNomesDesenvolvedores.text = "Pamella S.Engholm-551600\nLuiza Nunes de Jesus-99768"

        // Adicione a formatação de cor (opcional)
        val nomes = SpannableStringBuilder(tvNomesDesenvolvedores.text)
        nomes.setSpan(ForegroundColorSpan(resources.getColor(R.color.black)), 0, nomes.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        tvNomesDesenvolvedores.text = nomes
    }
}