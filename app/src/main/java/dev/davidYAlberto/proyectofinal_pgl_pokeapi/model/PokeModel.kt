package dev.davidYAlberto.proyectofinal_pgl_pokeapi.model

import com.google.gson.annotations.SerializedName

data class PokeModel(
    val count: Int,
    val results: List<PokeList>
)

data class PokeList(
    val name: String,
    val url: String
)

data class Sprite(
    @SerializedName("front_default") val frontDefault: String
)

data class PokeDetail(
    val id: Int,
    val name: String,
    val sprites: Sprite
)
