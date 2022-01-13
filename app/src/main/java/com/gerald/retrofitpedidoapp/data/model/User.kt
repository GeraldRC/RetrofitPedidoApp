package com.gerald.retrofitpedidoapp.data.model

data class User(

    val id: Int = 0,
    val name: String = "",
    val user: String = "",
    val pass: String = "",
    val pathPicture: String= ""
)

data class ListUser( val users: List<User> = listOf())