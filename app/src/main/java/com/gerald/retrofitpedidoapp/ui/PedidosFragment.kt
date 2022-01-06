package com.gerald.retrofitpedidoapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.gerald.retrofitpedidoapp.R
import com.gerald.retrofitpedidoapp.core.Resource
import com.gerald.retrofitpedidoapp.data.remote.PedidoDataSource
import com.gerald.retrofitpedidoapp.databinding.FragmentPedidosBinding
import com.gerald.retrofitpedidoapp.domain.PedidoRepositoryImpl
import com.gerald.retrofitpedidoapp.domain.RetrofitClient
import com.gerald.retrofitpedidoapp.presentation.PedidoViewModel
import com.gerald.retrofitpedidoapp.presentation.PedidoViewModelFactory

class PedidosFragment : Fragment(R.layout.fragment_pedidos) {

    private lateinit var binding: FragmentPedidosBinding

    private val viewModel by viewModels<PedidoViewModel>{
        PedidoViewModelFactory(PedidoRepositoryImpl(PedidoDataSource(RetrofitClient.webService)))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPedidosBinding.bind(view)
        bindingPedido()

        viewModel.fetchPedido(1).observe(viewLifecycleOwner){
            when(it){
                is Resource.Loading ->{

                }
                is Resource.Success ->{}
                is Resource.Failure ->{}
            }
        }
    }


    fun bindingPedido() {

    }


}