package com.azrosk.mygym.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.azrosk.domain.model.BodyPartName
import com.azrosk.mygym.databinding.BodyPartsViewHolderBinding

class RvBodyPartsAdapter (
    private val bodyParts : ArrayList<BodyPartName>,
    private val listener : (bodyParts:BodyPartName, view : ViewGroup, lv : List<View>) -> Unit) : RecyclerView.Adapter<RvBodyPartsAdapter.MyViewHolder>() {

   var viewList = ArrayList<View>()

    inner class MyViewHolder(
        listener: (bodyParts: BodyPartName, view: ViewGroup, lv : List<View>) -> Unit,
        var binding: BodyPartsViewHolderBinding) : RecyclerView.ViewHolder(binding.root)
    {
        private val context = itemView.context!!
        var bodyParts : BodyPartName?=null
        fun bind(myBodyParts: BodyPartName){
            binding.tvBodyPart.text = myBodyParts.name
            binding.ivBodyPart.setBackgroundResource(myBodyParts.img)
            bodyParts = myBodyParts
        }

        init {
            binding.llBodyPartHolder.setOnClickListener { listener(bodyParts!!, binding.llBodyPartHolder, viewList) }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding =  BodyPartsViewHolderBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        viewList.add(binding.root)

        return MyViewHolder(listener, binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(bodyParts[position])
    }

    override fun getItemCount(): Int {
        return bodyParts.size
    }
}