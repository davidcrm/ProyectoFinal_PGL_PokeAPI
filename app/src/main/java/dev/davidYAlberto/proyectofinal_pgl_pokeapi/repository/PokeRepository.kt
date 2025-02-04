package dev.davidYAlberto.proyectofinal_pgl_pokeapi.repository

import android.util.Log
import dev.davidYAlberto.proyectofinal_pgl_pokeapi.data.PokeAPI
import dev.davidYAlberto.proyectofinal_pgl_pokeapi.model.PokeDetail
import dev.davidYAlberto.proyectofinal_pgl_pokeapi.model.PokeList
import javax.inject.Inject

class PokeRepository @Inject constructor(private val pokeAPI: PokeAPI) {
    suspend fun getPokemons(): List<PokeDetail>? {
        val response = pokeAPI.getPokemons() // Peticion a Endpoint /pokemon/
        if (!response.isSuccessful) return null // Si petición no es succesful -> return null

        val pokeList = response.body()?.results ?: emptyList() // Recibimos lista de Nombres/URL
        return pokeList.map { item ->
            // Mapeamos lista para obtener id
            val urlParts = item.url.split("/") // Split
            val pokemonResponse =
                pokeAPI.getPokemon( // Petición al endpoint de un pokemon (por id)
                    Integer.parseInt(urlParts[urlParts.size - 2]) // penúltimo campo (donde está id)
                )
            /**
             * En funciones lambda siempre se devuelve última línea
             */
            pokemonResponse.body()!!
        }
    }

    suspend fun getPokemonsById(id: Int): PokeDetail? {
        val response = pokeAPI.getPokemon(id)
        if (!response.isSuccessful) return null
        val pokemon = response.body()
        return pokemon
    }
}