package com.gerald.retrofitpedidoapp.domain

import com.gerald.retrofitpedidoapp.application.AppConstants
import com.gerald.retrofitpedidoapp.data.model.Pedido
import com.gerald.retrofitpedidoapp.data.model.PedidoList
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface WebService {

    @GET("pedidos/{id}")
    suspend fun getPedido(@Path("id") id: Int): Pedido

    @GET("pedidos")
    suspend fun getAllPedido(): PedidoList
}

object RetrofitClient {

    val webService by lazy {
        Retrofit.Builder()
            .baseUrl(AppConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build().create(WebService::class.java)
    }
}