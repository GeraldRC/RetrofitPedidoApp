package com.gerald.retrofitpedidoapp.ui.detail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.ArrayAdapter
import androidx.fragment.app.viewModels
import com.gerald.retrofitpedidoapp.R
import com.gerald.retrofitpedidoapp.core.Resource
import com.gerald.retrofitpedidoapp.data.remote.PedidoDataSource
import com.gerald.retrofitpedidoapp.databinding.FragmentPedidosBinding
import com.gerald.retrofitpedidoapp.domain.PedidoRepositoryImpl
import com.gerald.retrofitpedidoapp.domain.RetrofitClient
import com.gerald.retrofitpedidoapp.presentation.PedidoViewModel
import com.gerald.retrofitpedidoapp.presentation.PedidoViewModelFactory

class PedidoDetailFragment : Fragment(R.layout.fragment_pedidos) {

    private lateinit var binding: FragmentPedidosBinding

    private val viewModel by viewModels<PedidoViewModel> {
        PedidoViewModelFactory(PedidoRepositoryImpl(PedidoDataSource(RetrofitClient.webService)))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPedidosBinding.bind(view)
        bindingPedido()
    }


    private fun bindingPedido() {
        viewModel.fetchPedido(1).observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Loading -> {
                    Log.d("Loading", "Loading....")
                }
                is Resource.Success -> {
                    Log.d("ResultPedido", it.data.toString())
                    binding.txtNumPed.text = "Pedido: ${it.data.numPed.toString()}"
                    binding.txtDetail.text = it.data.detail
                    binding.txtArt.text = it.data.canArt.toString()
                    binding.txtArtEnt.text = it.data.cantArtEnt.toString()
                    binding.txtDate.text = it.data.date

                    val list = mutableListOf<String>()
                    it.data.images.forEach { paths ->
                        list.add(paths.path)
                    }
                    val adapter = ArrayAdapter(requireContext(),R.layout.custom_list_items,list)
                    binding.menu.setAdapter(adapter)

                }
                is Resource.Failure -> {
                    Log.e("Error Server", it.toString())
                }
            }
        }
    }

}