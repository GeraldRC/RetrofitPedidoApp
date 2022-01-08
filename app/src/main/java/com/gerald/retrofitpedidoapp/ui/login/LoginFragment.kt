package com.gerald.retrofitpedidoapp.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gerald.retrofitpedidoapp.R
import com.gerald.retrofitpedidoapp.databinding.FragmentLoginFragmentBinding

class LoginFragment : Fragment(R.layout.fragment_login_fragment) {

    private lateinit var bindig: FragmentLoginFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindig = FragmentLoginFragmentBinding.bind(view)
    }
}