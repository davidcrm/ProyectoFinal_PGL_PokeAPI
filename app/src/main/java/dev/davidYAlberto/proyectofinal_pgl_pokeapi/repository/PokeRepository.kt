package dev.davidYAlberto.proyectofinal_pgl_pokeapi.repository

import dev.davidYAlberto.proyectofinal_pgl_pokeapi.data.PokeAPI
import dev.davidYAlberto.proyectofinal_pgl_pokeapi.model.PokeList
import javax.inject.Inject

class PokeRepository @Inject constructor(private val pokeAPI: PokeAPI){
    suspend fun getPokemons():List<PokeList>? {
        val response = pokeAPI.getPokemons()
        if (response.isSuccessful){
            return response.body()?.results
        }
        return null
    }
}