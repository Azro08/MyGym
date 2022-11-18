package com.azrosk.mygym.presentation.timer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.azrosk.mygym.R
import com.azrosk.mygym.databinding.FragmentTimerBinding

class TimerFragment : Fragment() {
    private var _binding : FragmentTimerBinding?=null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentTimerBinding.inflate(layoutInflater)
        return binding.root
    }

}