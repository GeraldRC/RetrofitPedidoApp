package com.gerald.retrofitpedidoapp.ui.pedido.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.gerald.retrofitpedidoapp.core.BaseViewHolder
import com.gerald.retrofitpedidoapp.data.model.Pedido
import com.gerald.retrofitpedidoapp.databinding.ItemNewPedidoBinding

class PedidoAdapter(
    private val listPedido: List<Pedido>,
    private val itemClickListener: OnPedidoClickListener
): RecyclerView.Adapter<BaseViewHolder<*>>() {

    interface OnPedidoClickListener{
        fun onPedidoClick(pedido : Pedido)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBinding = ItemNewPedidoBinding.inflate(LayoutInflater.from(parent.context), parent,
        false)
        val holder = PedidoViewHolder(itemBinding, parent.context)

        itemBinding.root.setOnClickListener {
            val position = holder.bindingAdapterPosition.takeIf {
                it != DiffUtil.DiffResult.NO_POSITION
            } ?: return@setOnClickListener
            itemClickListener.onPedidoClick(listPedido[position])
        }
        return holder
    }


    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (holder) {
         is PedidoViewHolder ->holder.render(listPedido[position])
        }
    }

    override fun getItemCount(): Int =listPedido.size

    private inner class PedidoViewHolder(val binding : ItemNewPedidoBinding, val context: Context) : BaseViewHolder<Pedido>(binding.root){
        override fun render(item: Pedido) {
            binding.txtPed.text = "Pedido : ${item.numPed}"
            binding.txtFecha.text = "Fecha : ${item.date}"
        }
    }
}