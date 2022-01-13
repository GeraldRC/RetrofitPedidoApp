package com.gerald.retrofitpedidoapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.gerald.retrofitpedidoapp.core.Resource
import com.gerald.retrofitpedidoapp.domain.PedidoRepository
import com.gerald.retrofitpedidoapp.domain.UserPedidoRepository
import kotlinx.coroutines.Dispatchers

class LoginViewModel(private val repo: UserPedidoRepository): ViewModel() {

    fun getUsers() = liveData(Dispatchers.IO){
        emit(Resource .Loading())

        try {
            emit(Resource.Success(repo.getAllUsers()))
        }catch (e :Exception){
            emit(Resource.Failure(e))
        }
    }

    fun getUserLogin( user: String , pass: String ) = liveData(Dispatchers.IO){
        emit(Resource .Loading())

        try {
            emit(Resource.Success(repo.getUserLogin(user,pass)))
        }catch (e :Exception){
            emit(Resource.Failure(e))
        }
    }
}

class LoginViewModelFactory(private val repo: UserPedidoRepository): ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(UserPedidoRepository::class.java).newInstance(repo)
    }

}