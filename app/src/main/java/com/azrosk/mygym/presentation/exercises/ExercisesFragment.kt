package com.azrosk.mygym.presentation.exercises

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.azrosk.mygym.R
import com.azrosk.mygym.adapter.RvExerciseAdapter
import com.azrosk.mygym.databinding.FragmentExercisesBinding
import com.azrosk.mygym.utilities.GlideLoader
import com.azrosk.mygym.viewmodel.ExerciseViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ExercisesFragment : Fragment() {
    private var _binding : FragmentExercisesBinding?=null
    private val binding get() = _binding!!
    private val viewModel : ExerciseViewModel by viewModels()
    private var adapter : RvExerciseAdapter?=null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentExercisesBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val bodyPart = arguments?.getString("body_part")

        if (bodyPart != null) {
            loadExercise(bodyPart)
        }

    }

    private fun loadExercise(bodyPart: String) {
        viewModel.loadExercise(bodyPart)
        viewModel.responseExercise.observe(requireActivity()){ exer ->
            adapter = RvExerciseAdapter(exer) { TODO()}
            binding.rvExer.layoutManager = GridLayoutManager(requireContext(), 2)
            binding.rvExer.setHasFixedSize(true)
            binding.rvExer.adapter = adapter
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding!!
    }

}