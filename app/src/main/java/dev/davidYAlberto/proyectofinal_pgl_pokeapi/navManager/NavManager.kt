package dev.davidYAlberto.proyectofinal_pgl_pokeapi.navManager

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import dev.davidYAlberto.proyectofinal_pgl_pokeapi.viewModel.PokeViewModel
import dev.davidYAlberto.proyectofinal_pgl_pokeapi.views.DetailView
import dev.davidYAlberto.proyectofinal_pgl_pokeapi.views.HomeView

@Composable
fun NavManager(viewModel: PokeViewModel){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Home"){
        composable("Home"){
            HomeView(viewModel, navController)
        }
        composable("DetailView/{id}", arguments = listOf(
            navArgument("id"){
                type = NavType.IntType
            }
        )){
            val id = it.arguments?.getInt("id")?:0
            DetailView(viewModel, navController, id)
        }
    }
}