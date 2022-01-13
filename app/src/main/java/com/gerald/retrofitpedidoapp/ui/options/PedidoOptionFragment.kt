package com.gerald.retrofitpedidoapp.ui.options

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.gerald.retrofitpedidoapp.R
import com.gerald.retrofitpedidoapp.databinding.FragmentPedidoOptionBinding


class PedidoOptionFragment : Fragment(R.layout.fragment_pedido_option) {

    private lateinit var binding: FragmentPedidoOptionBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPedidoOptionBinding.bind(view)
        clickListeners()
    }

    private fun clickListeners(){
        binding.optPedidos.setOnClickListener {
            navigate(1)
        }
    }

    private fun navigate(opt: Int){
        when(opt){
            1 -> {
                findNavController().navigate(R.id.action_pedidoOptionFragment_to_pedidosFragment2)
            }
        }
    }

}