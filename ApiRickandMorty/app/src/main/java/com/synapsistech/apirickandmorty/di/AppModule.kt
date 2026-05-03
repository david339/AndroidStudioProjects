package com.synapsistech.apirickandmorty.di

import com.synapsistech.apirickandmorty.api.PersonajesApi
import com.synapsistech.apirickandmorty.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    //Aqui estara el provedor de la comunicacion entre retrofit y la api

    @Provides
    @Singleton
    fun provideApi(): PersonajesApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PersonajesApi::class.java)
    }
}