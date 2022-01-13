package com.gerald.retrofitpedidoapp.ui.pedido

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gerald.retrofitpedidoapp.R
import com.gerald.retrofitpedidoapp.core.Resource
import com.gerald.retrofitpedidoapp.data.model.Pedido
import com.gerald.retrofitpedidoapp.data.remote.PedidoDataSource
import com.gerald.retrofitpedidoapp.databinding.FragmentPedidos2Binding
import com.gerald.retrofitpedidoapp.domain.PedidoRepositoryImpl
import com.gerald.retrofitpedidoapp.domain.RetrofitClient
import com.gerald.retrofitpedidoapp.presentation.PedidoViewModel
import com.gerald.retrofitpedidoapp.presentation.PedidoViewModelFactory
import com.gerald.retrofitpedidoapp.ui.pedido.adapter.PedidoAdapter

class PedidosFragment : Fragment(R.layout.fragment_pedidos2), PedidoAdapter.OnPedidoClickListener {

    private lateinit var binding: FragmentPedidos2Binding
    private lateinit var recyclerView: RecyclerView

    private val viewmodel by viewModels<PedidoViewModel> {
        PedidoViewModelFactory(PedidoRepositoryImpl(PedidoDataSource(RetrofitClient.webService)))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPedidos2Binding.bind(view)
        recyclerView = binding.rvPed
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        loadingPedidos()
        clickListeners()

    }

    private fun clickListeners() {
        binding.btnSearch.setOnClickListener {
            getPedido()
        }
    }

    private fun getPedido(){
        val ped = binding.txtSearch.text.toString()
        if (ped.trim().isEmpty()){
            loadingPedidos()
        }else{
            viewmodel.fetchPedido(ped.toInt()).observe(viewLifecycleOwner){
                when (it) {
                    is Resource.Loading -> {
                        Log.d("Loading","Paso por aca" )
                        binding.progessPeds.visibility = View.VISIBLE
                    }
                    is Resource.Success -> {
                        Log.d("Response", it.data.toString())
                        binding.progessPeds.visibility = View.GONE
                        recyclerView.adapter = PedidoAdapter(listOf(it.data), this@PedidosFragment)
                    }
                    is Resource.Failure -> {
                        binding.progessPeds.visibility = View.GONE
                        Log.d("Error", it.exception.toString())
                        Toast.makeText(requireContext(), "Pedido: ${ped.trim()} no encontrado!", Toast.LENGTH_LONG)
                            .show()
                    }
                }
            }
        }
    }

    private fun loadingPedidos() {
        viewmodel.getAllPedidos().observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Loading -> {
                    Log.d("Loading","Paso por aca" )
                    binding.progessPeds.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    Log.d("Response", it.data.toString())
                    binding.progessPeds.visibility = View.GONE
                    recyclerView.adapter = PedidoAdapter(it.data, this@PedidosFragment)
                }
                is Resource.Failure -> {
                    binding.progessPeds.visibility = View.GONE
                    Log.d("Error", it.exception.toString())
                    Toast.makeText(requireContext()," it.exception.toString()", Toast.LENGTH_LONG)
                        .show()
                }
            }
        }
    }

    override fun onPedidoClick(pedido: Pedido) {
        val action = PedidosFragmentDirections.actionPedidosFragment2ToPedidosFragment(pedido.numPed)
        findNavController().navigate(action)
    }
}