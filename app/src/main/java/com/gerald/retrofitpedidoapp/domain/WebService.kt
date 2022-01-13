package com.gerald.retrofitpedidoapp.domain

import com.gerald.retrofitpedidoapp.application.AppConstants
import com.gerald.retrofitpedidoapp.data.model.ListUser
import com.gerald.retrofitpedidoapp.data.model.Pedido
import com.gerald.retrofitpedidoapp.data.model.User
import com.google.gson.GsonBuilder
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface WebService {

    @GET("pedidos/{numped}")
    suspend fun getPedido(
        @Path("numped") id: Int
    ): Pedido

    @GET("pedidos")
    suspend fun getAllPedido(): List<Pedido>

    @GET("users/{user}/{pass}")
    suspend fun getUserLogin(
        @Path("user") user: String,
        @Path("pass") pass: String
    ): User

    @GET("users")
    suspend fun getAllUsers(): ListUser

    @POST("pedidos")
    suspend fun savePedido(
        @Body pedido: Pedido
    ): Response<Pedido>

}

object RetrofitClient {

    val webService: WebService by lazy {
        Retrofit.Builder()
            .baseUrl(AppConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build().create(WebService::class.java)
    }
}