package dev.davidYAlberto.proyectofinal_pgl_pokeapi.views

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import dev.davidYAlberto.proyectofinal_pgl_pokeapi.viewModel.PokeViewModel

@Composable
fun HomeView(viewModel: PokeViewModel){
    val pokemons by viewModel.pokemons.collectAsState()
    LazyColumn {
        items(pokemons) {item ->
            Text(text=item.name)
        }
    }
}