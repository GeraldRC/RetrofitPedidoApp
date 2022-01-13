package com.gerald.retrofitpedidoapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.gerald.retrofitpedidoapp.core.Resource
import com.gerald.retrofitpedidoapp.data.model.Pedido
import com.gerald.retrofitpedidoapp.domain.PedidoRepository
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class PedidoViewModel(private val repo: PedidoRepository) : ViewModel() {

    fun fetchPedido(numped: Int) = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(repo.getPedido(numped)))
        } catch (e: Exception) {
            emit(Resource.Failure(e))
        }
    }

    fun getAllPedidos() = liveData (Dispatchers.IO){
        emit(Resource.Loading())

        try {
            emit(Resource.Success(repo.getAllPedido()))
        }catch (e : Exception){
            emit(Resource.Failure(e))
        }
    }

    fun pushPedido(pedido: Pedido) = liveData(Dispatchers.IO) {
        emit(Resource.Loading())

        try {
            emit(Resource.Success(repo.savePed(pedido)))
        }catch (e : Exception){
            emit(Resource.Failure(e))
        }
    }
}

class PedidoViewModelFactory(private val repo: PedidoRepository): ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(PedidoRepository::class.java).newInstance(repo)
    }

}