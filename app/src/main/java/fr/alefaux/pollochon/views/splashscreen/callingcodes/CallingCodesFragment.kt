package fr.alefaux.pollochon.views.splashscreen.callingcodes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import fr.alefaux.pollochon.databinding.FragmentCallingCodesBinding

class CallingCodesFragment: Fragment() {

    private val args: CallingCodesFragmentArgs by navArgs()
    private lateinit var binding: FragmentCallingCodesBinding

    private val callingCodesAdapter: CallingCodesAdapter by lazy {
        CallingCodesAdapter()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentCallingCodesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvCallingCodes.adapter = callingCodesAdapter
//        callingCodesAdapter.items = args.callingCodes.toList()
    }
}