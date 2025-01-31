package dev.davidYAlberto.proyectofinal_pgl_pokeapi.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import dev.davidYAlberto.proyectofinal_pgl_pokeapi.model.PokeDetail

@Composable
fun PokemonCard(pokemon: PokeDetail, onClick: ()->Unit){
    Card (
        shape= RoundedCornerShape(5.dp),
        modifier= Modifier
            .padding(10.dp)
            .shadow(40.dp)
            .clickable { onClick() }
    ) {
        Column {
            MainImage (image=pokemon.sprites.frontDefault)
        }

    }
}
@Composable
fun MainImage(image:String){
    val image = rememberAsyncImagePainter(model = image) // Peticion async de coil
    Image (painter=image,
        contentDescription=null,
        contentScale= ContentScale.Crop,
        modifier= Modifier
            .fillMaxWidth()
            .height(250.dp)
    )

}
