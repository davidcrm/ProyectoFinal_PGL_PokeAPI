package dev.davidYAlberto.proyectofinal_pgl_pokeapi.views

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import dev.davidYAlberto.proyectofinal_pgl_pokeapi.components.MainTopBar
import dev.davidYAlberto.proyectofinal_pgl_pokeapi.components.PokemonCard
import dev.davidYAlberto.proyectofinal_pgl_pokeapi.util.Constants.Companion.CUSTOM_BLACK
import dev.davidYAlberto.proyectofinal_pgl_pokeapi.viewModel.PokeViewModel

@Composable
fun HomeView(viewModel: PokeViewModel, navController: NavController){
    Scaffold(
        topBar= {
            MainTopBar(title = "POKEMONS", showBackButton = false) {
            }
        }
    ){
        ContentHomeView(pad = it, viewModel = viewModel, navController = navController)
    }
}

@Composable
fun ContentHomeView (viewModel:PokeViewModel, pad: PaddingValues, navController: NavController) {
    val pokemons by viewModel.pokemons.collectAsState()
    LazyColumn(
        modifier = Modifier
            .padding(pad)
            .background(Color(CUSTOM_BLACK))

    ) {
        items(pokemons) { item ->
            PokemonCard(item) {
                navController.navigate("DetailView/${item.id}")
            }
            Text(
                text = item.name,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White,
                modifier = Modifier.padding(start = 10.dp)
            )
        }
    }
}

@Composable
fun MetaWebsite(url: String){
    val context= LocalContext.current
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    Column {
        Button(onClick={context.startActivity(intent)}, colors= ButtonDefaults.buttonColors(
            contentColor = Color.Gray,
            containerColor = Color.LightGray
        )
        ){
            Text(text="Sitio Web")
        }
    }
}