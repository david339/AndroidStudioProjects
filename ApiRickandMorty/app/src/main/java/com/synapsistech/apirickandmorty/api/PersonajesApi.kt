package com.synapsistech.apirickandmorty.api

import com.synapsistech.apirickandmorty.model.ListaPersonajes
import retrofit2.http.GET

interface PersonajesApi {

    //Aqui se comunicara con retrofit para la consulta de los personajes

    @GET("character")
    suspend fun getPersonajes(): ListaPersonajes

}