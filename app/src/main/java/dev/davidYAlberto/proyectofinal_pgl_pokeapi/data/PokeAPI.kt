package dev.davidYAlberto.proyectofinal_pgl_pokeapi.data

import dev.davidYAlberto.proyectofinal_pgl_pokeapi.model.PokeModel
import dev.davidYAlberto.proyectofinal_pgl_pokeapi.util.Constants.Companion.ENDPOINT
import retrofit2.Response
import retrofit2.http.GET

interface PokeAPI {
    @GET(ENDPOINT)
    suspend fun getPokemons(): Response<PokeModel>
}