package com.gerald.retrofitpedidoapp.ui.create

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.gerald.retrofitpedidoapp.R
import com.gerald.retrofitpedidoapp.data.remote.PedidoDataSource
import com.gerald.retrofitpedidoapp.databinding.FragmentPedidoCreateBinding
import com.gerald.retrofitpedidoapp.domain.PedidoRepositoryImpl
import com.gerald.retrofitpedidoapp.domain.RetrofitClient
import com.gerald.retrofitpedidoapp.presentation.PedidoViewModel
import com.gerald.retrofitpedidoapp.presentation.PedidoViewModelFactory

class PedidoCreateFragment : Fragment(R.layout.fragment_pedido_create) {

    private lateinit var binding: FragmentPedidoCreateBinding
    private val viewmodel by viewModels<PedidoViewModel> {
        PedidoViewModelFactory(PedidoRepositoryImpl(PedidoDataSource(RetrofitClient.webService)))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPedidoCreateBinding.bind(view)
    }



}