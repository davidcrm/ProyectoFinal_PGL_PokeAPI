package dev.davidYAlberto.proyectofinal_pgl_pokeapi.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.davidYAlberto.proyectofinal_pgl_pokeapi.data.PokeAPI
import dev.davidYAlberto.proyectofinal_pgl_pokeapi.util.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    @Singleton
    @Provides
    fun providesPokeApi(retrofit: Retrofit):PokeAPI{
        return retrofit.create(PokeAPI::class.java)
    }
}
