package dev.davidYAlberto.proyectofinal_pgl_pokeapi.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import dev.davidYAlberto.proyectofinal_pgl_pokeapi.components.MainImage
import dev.davidYAlberto.proyectofinal_pgl_pokeapi.components.MainTopBar
import dev.davidYAlberto.proyectofinal_pgl_pokeapi.components.PokemonCard
import dev.davidYAlberto.proyectofinal_pgl_pokeapi.util.Constants.Companion.CUSTOM_BLACK
import dev.davidYAlberto.proyectofinal_pgl_pokeapi.viewModel.PokeViewModel

@Composable
fun DetailView(viewModel: PokeViewModel, navController: NavController, id: Int){
    LaunchedEffect(Unit){
        viewModel.getPokemonById(id)
    }
    Scaffold(
        topBar= {
            MainTopBar(title = viewModel.state.name, showBackButton = true) {
                navController.popBackStack()
            }
        }
    ){
        ContentDetailView(pad = it, viewModel = viewModel, id)
    }


}

@Composable
fun ContentDetailView(pad: PaddingValues, viewModel: PokeViewModel, id:Int){
    val pokemon = viewModel.state
    Column(modifier = Modifier
        .padding(pad)
    )
    {
        MainImage(image = pokemon.sprite)
        Text(
            text = pokemon.name,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(start = 10.dp)
        )

    }

}