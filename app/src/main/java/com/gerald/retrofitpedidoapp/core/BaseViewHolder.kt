package com.gerald.retrofitpedidoapp.core

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T>(itemView : View): RecyclerView.ViewHolder(itemView) {
    abstract fun render(item : T)
}