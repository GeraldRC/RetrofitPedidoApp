package com.gerald.retrofitpedidoapp.domain

import com.gerald.retrofitpedidoapp.data.model.ListUser
import com.gerald.retrofitpedidoapp.data.model.User

interface UserPedidoRepository {

    suspend fun getUserLogin(user: String , pass: String): User
    suspend fun getAllUsers(): ListUser
}