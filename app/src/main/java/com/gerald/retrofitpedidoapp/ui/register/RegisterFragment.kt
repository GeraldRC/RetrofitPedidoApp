package com.gerald.retrofitpedidoapp.ui.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.gerald.retrofitpedidoapp.R
import com.gerald.retrofitpedidoapp.databinding.FragmentRegisterFragmentBinding

class RegisterFragment : Fragment(R.layout.fragment_register_fragment) {

    private lateinit var binding: FragmentRegisterFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRegisterFragmentBinding.bind(view)
    }
}