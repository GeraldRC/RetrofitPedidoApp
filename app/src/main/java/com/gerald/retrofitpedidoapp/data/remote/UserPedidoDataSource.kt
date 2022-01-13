package com.gerald.retrofitpedidoapp.data.remote

import com.gerald.retrofitpedidoapp.data.model.ListUser
import com.gerald.retrofitpedidoapp.data.model.User
import com.gerald.retrofitpedidoapp.domain.WebService

class UserPedidoDataSource(private val webService: WebService) {

    suspend fun getUserLogin(user: String , pass: String): User = webService.getUserLogin(user,pass)

    suspend fun getAllUsers() : ListUser = webService.getAllUsers()
}