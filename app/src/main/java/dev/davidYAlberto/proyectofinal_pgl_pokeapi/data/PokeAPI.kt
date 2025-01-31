package dev.davidYAlberto.proyectofinal_pgl_pokeapi.data

import dev.davidYAlberto.proyectofinal_pgl_pokeapi.model.PokeDetail
import dev.davidYAlberto.proyectofinal_pgl_pokeapi.model.PokeModel
import dev.davidYAlberto.proyectofinal_pgl_pokeapi.util.Constants.Companion.ENDPOINT
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PokeAPI {
    @GET(ENDPOINT)
    suspend fun getPokemons(): Response<PokeModel>

    @GET("${ENDPOINT}/{id}")
    suspend fun getPokemon(@Path("id") id: Int): Response<PokeDetail>
}