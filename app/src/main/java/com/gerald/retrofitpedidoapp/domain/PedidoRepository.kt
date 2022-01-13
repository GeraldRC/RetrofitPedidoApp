package com.gerald.retrofitpedidoapp.domain

import com.gerald.retrofitpedidoapp.data.model.Pedido
import retrofit2.Response

interface PedidoRepository {

    suspend fun getPedido(numped: Int): Pedido
    suspend fun getAllPedido(): List<Pedido>
    suspend fun savePed(pedido: Pedido): Response<Pedido>
}