package dev.davidYAlberto.proyectofinal_pgl_pokeapi.viewModel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.davidYAlberto.proyectofinal_pgl_pokeapi.model.PokeDetail
import dev.davidYAlberto.proyectofinal_pgl_pokeapi.model.PokeList
import dev.davidYAlberto.proyectofinal_pgl_pokeapi.repository.PokeRepository
import dev.davidYAlberto.proyectofinal_pgl_pokeapi.state.PokeState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class PokeViewModel @Inject constructor(private val repo: PokeRepository): ViewModel() {

    private val _pokemons = MutableStateFlow<List<PokeDetail>>(emptyList())
    val pokemons = _pokemons.asStateFlow()
    var state by mutableStateOf(PokeState())
        private set
    init {
        fetchPokemons()
    }

    private fun fetchPokemons(){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                val result = repo.getPokemons()
               _pokemons.value = result ?: emptyList()
            }
        }
    }

    fun getPokemonById(id: Int) {
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                val result = repo.getPokemonsById(id)
                state=state.copy(
                    name = result?.name ?: "",
                    sprite = result?.sprites?.frontDefault ?: ""
                )
            }

        }
    }
}