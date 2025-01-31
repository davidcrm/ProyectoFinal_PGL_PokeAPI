package dev.davidYAlberto.proyectofinal_pgl_pokeapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dagger.hilt.android.AndroidEntryPoint
import dev.davidYAlberto.proyectofinal_pgl_pokeapi.ui.theme.ProyectoFinal_PGL_PokeAPITheme
import dev.davidYAlberto.proyectofinal_pgl_pokeapi.viewModel.PokeViewModel
import dev.davidYAlberto.proyectofinal_pgl_pokeapi.views.HomeView

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val viewModel:PokeViewModel by viewModels()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProyectoFinal_PGL_PokeAPITheme {
                    HomeView(viewModel = viewModel )
            }
        }
    }
}