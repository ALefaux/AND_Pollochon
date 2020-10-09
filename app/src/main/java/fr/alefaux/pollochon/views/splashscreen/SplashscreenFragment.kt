package fr.alefaux.pollochon.views.splashscreen

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import fr.alefaux.pollochon.R
import fr.alefaux.pollochon.databinding.FragmentSplashscreenBinding
import fr.alefaux.pollochon.extensions.hide
import fr.alefaux.pollochon.extensions.show
import fr.alefaux.pollochon.views.home.HomeActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.android.viewmodel.ext.android.viewModel

class SplashscreenFragment : Fragment(R.layout.fragment_splashscreen) {

    private val splashscreenViewModel: SplashscreenViewModel by viewModel()

    private lateinit var binding: FragmentSplashscreenBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentSplashscreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindViewModel()

        binding.btSplashscreenIgnore.setOnClickListener {
            splashscreenViewModel.connectAnonymously()
        }
    }

    private fun bindViewModel() {
        splashscreenViewModel.callingCodesLiveData.observe(viewLifecycleOwner, Observer { callingCodes ->
            binding.btSplashscreenPhone.setOnClickListener {
                val destination = SplashscreenFragmentDirections.toLoginPhoneDialogFragment(callingCodes.toTypedArray())
                findNavController().navigate(destination)
            }
        })
        splashscreenViewModel.userConnectedLiveData.observe(viewLifecycleOwner, Observer {
            binding.groupSplashscreenLogin.hide()
            next()
        })
        splashscreenViewModel.userNotConnectedLiveData.observe(viewLifecycleOwner, Observer {
            binding.groupSplashscreenLogin.show()
        })
        splashscreenViewModel.listen()
        splashscreenViewModel.getAllCallingCodes()
    }

    private fun next() {
        lifecycleScope.launch {
            delay(3000)
            val intent = Intent(context, HomeActivity::class.java)
            startActivity(intent)
        }
    }

}