package ru.code.codeworkers

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import ru.code.codeworkers.adapter.WorkersAdapter
import ru.code.codeworkers.adapter.onInteractionListener
import ru.code.codeworkers.databinding.FragmentFeedBinding
import ru.code.codeworkers.dto.Worker
import ru.code.codeworkers.viewmodel.WorkersViewModel

class FeedFragment : Fragment() {
    private val viewModel: WorkersViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentFeedBinding.inflate(
            inflater,
            container,
            false
        )

        var workers = listOf<Worker>(
            Worker(1, "Alex Sergeev", "Boss"),
            Worker(2, "Sergey Sergeev", "Lawyer")
        )

        val adapter = WorkersAdapter(object : onInteractionListener {
            override fun onClick(worker: Worker) {
                findNavController().navigate(R.id.action_feedFragment_to_workerCardFragment)
            }
        }
        )
//        viewModel.data.observe(viewLifecycleOwner) { workers ->
//            adapter.submitList(workers)
//        }
        binding.list.adapter = adapter

        return binding.root
    }
}