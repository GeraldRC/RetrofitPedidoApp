package com.gerald.retrofitpedidoapp.domain

import com.gerald.retrofitpedidoapp.data.model.Pedido
import com.gerald.retrofitpedidoapp.data.model.PedidoList

interface PedidoRepository {

    suspend fun getPedido(numped: Int): Pedido
    suspend fun getAllPedido(): PedidoList
}