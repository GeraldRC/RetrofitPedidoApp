package com.gerald.retrofitpedidoapp.domain

import com.gerald.retrofitpedidoapp.data.model.Pedido
import com.gerald.retrofitpedidoapp.data.remote.PedidoDataSource
import retrofit2.Response

class PedidoRepositoryImpl(private val dataSource: PedidoDataSource): PedidoRepository {

    override suspend fun getPedido(numped : Int): Pedido = dataSource.getPedido(numped)

    override suspend fun getAllPedido(): List<Pedido> = dataSource.getAllPedidos()
    override suspend fun savePed(pedido: Pedido): Response<Pedido> = dataSource.savePed(pedido)
}