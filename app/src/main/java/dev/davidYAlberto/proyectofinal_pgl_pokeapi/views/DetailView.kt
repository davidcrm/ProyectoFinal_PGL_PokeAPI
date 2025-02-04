package dev.davidYAlberto.proyectofinal_pgl_pokeapi.views


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import dev.davidYAlberto.proyectofinal_pgl_pokeapi.components.MainTopBar
import dev.davidYAlberto.proyectofinal_pgl_pokeapi.components.PokemonElevatedCard
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
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(pad)
    )
    {
        PokemonElevatedCard(pokemon = pokemon)
        MetaWebsite(url = "https://www.wikidex.net/wiki/" + pokemon.name)
    }

}