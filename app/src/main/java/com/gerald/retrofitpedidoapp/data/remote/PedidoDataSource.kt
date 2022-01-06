package com.gerald.retrofitpedidoapp.data.remote

import com.gerald.retrofitpedidoapp.data.model.Pedido
import com.gerald.retrofitpedidoapp.data.model.PedidoList
import com.gerald.retrofitpedidoapp.domain.WebService

class PedidoDataSource(private val webService: WebService) {

    suspend fun getPedido(numped: Int): Pedido = webService.getPedido(numped)

    suspend fun getAllPedidos(): PedidoList = webService.getAllPedido()

}