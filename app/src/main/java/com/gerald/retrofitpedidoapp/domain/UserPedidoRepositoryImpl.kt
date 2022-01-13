package com.gerald.retrofitpedidoapp.domain

import com.gerald.retrofitpedidoapp.data.model.ListUser
import com.gerald.retrofitpedidoapp.data.model.User
import com.gerald.retrofitpedidoapp.data.remote.UserPedidoDataSource

class UserPedidoRepositoryImpl(private val datasource: UserPedidoDataSource) :
    UserPedidoRepository {


    override suspend fun getUserLogin(user: String, pass: String): User =
        datasource.getUserLogin(user, pass)

    override suspend fun getAllUsers(): ListUser = datasource.getAllUsers()
}