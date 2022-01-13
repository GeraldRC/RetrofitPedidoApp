package com.gerald.retrofitpedidoapp.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.gerald.retrofitpedidoapp.R
import com.gerald.retrofitpedidoapp.core.Resource
import com.gerald.retrofitpedidoapp.data.remote.UserPedidoDataSource
import com.gerald.retrofitpedidoapp.databinding.FragmentLoginFragmentBinding
import com.gerald.retrofitpedidoapp.domain.RetrofitClient
import com.gerald.retrofitpedidoapp.domain.UserPedidoRepositoryImpl
import com.gerald.retrofitpedidoapp.presentation.LoginViewModel
import com.gerald.retrofitpedidoapp.presentation.LoginViewModelFactory

class LoginFragment : Fragment(R.layout.fragment_login_fragment) {

    private lateinit var binding: FragmentLoginFragmentBinding

    private val viewmodel by viewModels<LoginViewModel> {
        LoginViewModelFactory(UserPedidoRepositoryImpl(UserPedidoDataSource(RetrofitClient.webService)))
    }

    private lateinit var user: String
    private lateinit var pass: String


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLoginFragmentBinding.bind(view)
        setClickListeners()
    }

    private fun setClickListeners() {
        binding.btnLogin.setOnClickListener {
            login()
        }
        binding.btnRegister.setOnClickListener {
            navigate(2)
        }
    }

    private fun login() {
        if (comprobarCampos()) {
            user = binding.txtUser.text.toString()
            pass = binding.txtPassword.text.toString()

            viewmodel.getUserLogin(user, pass).observe(viewLifecycleOwner) { result ->
                when (result) {
                    is Resource.Loading -> {
                        binding.progressBar.visibility = View.VISIBLE
                    }
                    is Resource.Success -> {
                        binding.progressBar.visibility = View.GONE
                        navigate(1)
                    }
                    is Resource.Failure -> {
                        binding.progressBar.visibility = View.GONE
                        Toast.makeText(requireContext(), "Error de Datos", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }

    private fun navigate(option: Int) {
        when (option) {
            1 -> {
                findNavController().navigate(R.id.action_loginFragment_to_pedidoOptionFragment)
            }
            2 -> {
                findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
            }
            3 -> {}
        }
    }

    private fun comprobarCampos(): Boolean {
        var cont = 0
        user = binding.txtUser.text.toString()
        pass = binding.txtPassword.text.toString()

        if (user.trim().isEmpty()) {
            binding.inputUser.error = "Ingrese Email"
        } else {
            binding.inputUser.error = null
            cont += 1
        }

        if (pass.trim().isEmpty()) {
            binding.inputPassword.error = "Ingrese Contraseña"
        } else {
            binding.inputPassword.error = null
            cont += 1
        }

        return cont == 2
    }
}