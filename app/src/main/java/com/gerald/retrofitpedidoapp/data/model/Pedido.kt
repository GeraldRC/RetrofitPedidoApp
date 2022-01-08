package com.gerald.retrofitpedidoapp.data.model

data class Pedido(

    val id: Int = 0,
    val numPed: Int = 0,
    val canArt: Int = 0,
    val cantArtEnt: Int = 0,
    val detail: String = "",
    val date: String = "",
    val images: List<Image> = listOf(),
    val user: User
)

data class PedidoList(val results: List<Pedido> = listOf())
