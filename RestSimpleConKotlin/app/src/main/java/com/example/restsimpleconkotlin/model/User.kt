package com.example.restsimpleconkotlin.model

data class User {
    val name: String,
    val lastName: String,
    val city: String,
    val thumbnail: String,
    var id: Int = 0,
}