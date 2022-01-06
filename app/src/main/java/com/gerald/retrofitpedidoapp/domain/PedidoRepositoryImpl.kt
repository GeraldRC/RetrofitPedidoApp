package com.gerald.retrofitpedidoapp.domain

import com.gerald.retrofitpedidoapp.data.model.Pedido
import com.gerald.retrofitpedidoapp.data.model.PedidoList
import com.gerald.retrofitpedidoapp.data.remote.PedidoDataSource

class PedidoRepositoryImpl(private val dataSource: PedidoDataSource): PedidoRepository {

    override suspend fun getPedido(numped : Int): Pedido = dataSource.getPedido(numped)

    override suspend fun getAllPedido(): PedidoList = dataSource.getAllPedidos()
}