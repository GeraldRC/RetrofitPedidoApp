package com.gerald.retrofitpedidoapp.data.remote

import com.gerald.retrofitpedidoapp.data.model.Pedido
import com.gerald.retrofitpedidoapp.domain.WebService
import retrofit2.Response

class PedidoDataSource(private val webService: WebService) {

    suspend fun getPedido(numped: Int): Pedido = webService.getPedido(numped)

    suspend fun getAllPedidos(): List<Pedido> = webService.getAllPedido()

    suspend fun savePed(pedido: Pedido) : Response<Pedido> = webService.savePedido(pedido)
}