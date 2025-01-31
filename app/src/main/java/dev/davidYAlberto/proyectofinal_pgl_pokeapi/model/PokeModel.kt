package dev.davidYAlberto.proyectofinal_pgl_pokeapi.model

data class PokeModel(
    val count: Int,
    val results: List<PokeList>
)
data class PokeList(
    val id: Int,
    val name: String,
    val sprite: String
)
