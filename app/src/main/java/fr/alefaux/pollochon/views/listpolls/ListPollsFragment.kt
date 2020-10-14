package fr.alefaux.pollochon.views.listpolls

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import fr.alefaux.pollochon.databinding.FragmentListPollsBinding
import org.koin.android.viewmodel.ext.android.viewModel

class ListPollsFragment : Fragment() {

    private val listPollsViewModel: ListPollsViewModel by viewModel()

    private lateinit var binding: FragmentListPollsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListPollsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindViewModel()
    }

    private fun bindViewModel() {
        listPollsViewModel.pollsErrorLiveData.observe(viewLifecycleOwner, {
            Snackbar.make(requireView(), "Impossible des récupérer les votes", Snackbar.LENGTH_LONG)
                .show()
        })
        listPollsViewModel.pollsLiveData.observe(viewLifecycleOwner, {
            TODO("Afficher les polls")
        })
        listPollsViewModel.getAll()
    }

}