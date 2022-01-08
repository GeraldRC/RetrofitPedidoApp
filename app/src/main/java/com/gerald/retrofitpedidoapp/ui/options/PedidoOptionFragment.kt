package com.gerald.retrofitpedidoapp.ui.options

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gerald.retrofitpedidoapp.R
import com.gerald.retrofitpedidoapp.databinding.FragmentPedidoOptionBinding

class PedidoOptionFragment : Fragment(R.layout.fragment_pedido_option) {

    private lateinit var binding: FragmentPedidoOptionBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPedidoOptionBinding.bind(view)
    }

}