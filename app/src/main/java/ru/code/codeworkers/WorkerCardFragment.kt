package ru.code.codeworkers

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.code.codeworkers.databinding.FragmentWorkerCardBinding

class WorkerCardFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentWorkerCardBinding.inflate(
            inflater,
            container,
            false
        )
        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner, object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    AlertDialog.Builder(requireActivity()).apply {
                        findNavController().navigateUp()
                    }.create().show()
                }
            }
        )
        return  binding.root
    }
}