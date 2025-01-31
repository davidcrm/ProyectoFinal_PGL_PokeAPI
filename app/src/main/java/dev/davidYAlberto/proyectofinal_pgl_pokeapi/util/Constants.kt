package dev.davidYAlberto.proyectofinal_pgl_pokeapi.util

import dev.davidYAlberto.proyectofinal_pgl_pokeapi.data.PokeAPI
import retrofit2.Retrofit

class Constants {
    companion object{
        const val BASE_URL="https://pokeapi.co/api/v2/"
        const val ENDPOINT="pokemon/"
        const val CUSTOM_BLACK=0xFF2B2626
    }

    fun providesPokeAPI(retrofit: Retrofit): PokeAPI{
        return retrofit.create(PokeAPI::class.java)
    }
}