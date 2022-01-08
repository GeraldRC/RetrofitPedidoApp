package com.gerald.retrofitpedidoapp.ui.pedido

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gerald.retrofitpedidoapp.R
import com.gerald.retrofitpedidoapp.databinding.FragmentPedidos2Binding
import com.gerald.retrofitpedidoapp.databinding.FragmentPedidosBinding

class PedidosFragment : Fragment(R.layout.fragment_pedidos2) {

    private lateinit var binding: FragmentPedidos2Binding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPedidos2Binding.bind(view)
    }
}