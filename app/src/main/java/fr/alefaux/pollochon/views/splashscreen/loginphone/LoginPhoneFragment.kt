package fr.alefaux.pollochon.views.splashscreen.loginphone

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou
import fr.alefaux.pollochon.databinding.FragmentLoginPhoneBinding

class LoginPhoneFragment : Fragment() {

    private val args: LoginPhoneFragmentArgs by navArgs()

    private lateinit var binding: FragmentLoginPhoneBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentLoginPhoneBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindViewModel()

        val defaultCallingCode = args.callingCodes.toList().firstOrNull()
        GlideToVectorYou.justLoadImage(requireActivity(), defaultCallingCode?.flagUrl?.toUri(), binding.ivLoginPhoneCallingCodeFlag)
        binding.tvLoginPhoneCallingCode.text = "+${defaultCallingCode?.callingCodes?.firstOrNull()}"
        binding.btLoginPhoneNext.setOnClickListener {
            val phoneNumber = binding.etLoginPhone.text.toString()

        }
        binding.clLoginPhoneCallingCode.setOnClickListener {
            val directions = LoginPhoneFragmentDirections.toCallingCodesFragment(args.callingCodes)
            findNavController().navigate(directions)
        }
        binding.etLoginPhone.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (Regex("^0[67]\\d{8}\$").matches(s.toString())) {
                    if (!binding.btLoginPhoneNext.isEnabled) {
                        binding.btLoginPhoneNext.isEnabled = true
                    }
                } else {
                    if (binding.btLoginPhoneNext.isEnabled) {
                        binding.btLoginPhoneNext.isEnabled = false
                    }
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

        })

    }

    private fun bindViewModel() {

    }

}