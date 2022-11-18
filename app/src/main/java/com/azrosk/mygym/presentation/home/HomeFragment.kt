package com.azrosk.mygym.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import com.azrosk.domain.model.BodyPartName
import com.azrosk.mygym.R
import com.azrosk.mygym.adapter.RvBodyPartsAdapter
import com.azrosk.mygym.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private var _binding : FragmentHomeBinding?=null
    private val binding get() = _binding!!
    private val bodyParts = ArrayList<BodyPartName>()
    private var adapter : RvBodyPartsAdapter?= null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        bodyParts.add((BodyPartName("back", R.drawable.upper_arm)))
        bodyParts.add(BodyPartName("cardio", R.drawable.cardio))
        bodyParts.add(BodyPartName("chest", R.drawable.chest_muscle))
        bodyParts.add(BodyPartName("lower arms", R.drawable.lower_arm))
        bodyParts.add(BodyPartName("lower legs", R.drawable.lower_leg))
        bodyParts.add(BodyPartName("neck", R.drawable.neck))
        bodyParts.add(BodyPartName("shoulders", R.drawable.shoulder))
        bodyParts.add(BodyPartName("upper arms", R.drawable.upper_arm))
        bodyParts.add(BodyPartName("upper legs", R.drawable.upper_leg))
        bodyParts.add(BodyPartName("waist", R.drawable.waist))

        adapter = RvBodyPartsAdapter(bodyParts){ bodyParts, view, viewList ->
            moveToExercise(bodyParts, view, viewList)
        }
        binding.rvBodyParts.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.rvBodyParts.setHasFixedSize(true)
        binding.rvBodyParts.adapter = adapter
    }

    private fun moveToExercise(bodyParts: BodyPartName, view: ViewGroup, viewList: List<View>) {
        for (i in viewList){
            i.setBackgroundResource(R.drawable.exer_bgnd)
        }
        view.setBackgroundResource(R.drawable.exer_bgnd_clicked)
        binding.btnToExer.visibility = View.VISIBLE
        binding.btnToExer.setOnClickListener {
            findNavController().navigate(R.id.nav_to_exer, bundleOf(Pair("body_part", bodyParts.name)))
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}