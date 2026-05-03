package com.synapsistech.apirickandmorty.repository

import com.synapsistech.apirickandmorty.api.PersonajesApi
import com.synapsistech.apirickandmorty.model.ListaPersonajes
import javax.inject.Inject

class PersonajesRepository @Inject constructor(
    private val personajesApi: PersonajesApi
){
    suspend fun getPersonajes() : ListaPersonajes {
        return personajesApi.getPersonajes()
    }
}