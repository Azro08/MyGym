package com.azrosk.mygym.adapter

import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.azrosk.data.remote.model.BodyPartExerciseResponseItem
import com.azrosk.mygym.databinding.BodyPartsViewHolderBinding
import com.azrosk.mygym.databinding.ExerciseViewHolderBinding
import com.azrosk.mygym.utilities.GlideLoader
import com.bumptech.glide.Glide

class RvExerciseAdapter (
    private val exercisesList : List<BodyPartExerciseResponseItem>,
    private val listener : (exer : BodyPartExerciseResponseItem) -> Unit) : RecyclerView.Adapter<RvExerciseAdapter.MyViewHolder>() {

    class MyViewHolder(listener: (exer: BodyPartExerciseResponseItem) -> Unit,
                       var binding : ExerciseViewHolderBinding
    ) : RecyclerView.ViewHolder(binding.root)
    {
        private val context = itemView.context!!
        private var exercise : BodyPartExerciseResponseItem?=null
        fun bind(myExercise: BodyPartExerciseResponseItem){
            val gifUrl = myExercise.gifUrl
            Log.d("gifurl", gifUrl)
            Glide.with(context).load(gifUrl).into(binding.ivExercise)
            binding.tvExerName.text = myExercise.name
            exercise = myExercise
        }

        init {
            binding.ivExercise.setOnClickListener { listener(exercise!!) }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(listener, ExerciseViewHolderBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(exercisesList[position])
    }

    override fun getItemCount(): Int {
        return exercisesList.size
    }


}