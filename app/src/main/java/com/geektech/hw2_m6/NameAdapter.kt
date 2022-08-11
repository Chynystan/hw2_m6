package com.geektech.hw2_m6

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.geektech.hw2_m6.databinding.ItemPhoneBinding

class NameAdapter(private val onClick: (pos: Int)-> Unit):
  RecyclerView.Adapter<NameAdapter.ViewHolder>(){
    private val name = mutableListOf<NamesModel>()

    @SuppressLint("NotifyDataSetChanged")
    fun addNames(list: MutableList<NamesModel>){
        name.clear()
        name.addAll(list)
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun deleteNames(pos: Int){
        name.removeAt(pos)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemPhoneBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false))

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(name[position])
        holder.itemView.setOnLongClickListener {
            onClick(position)
            true
        }
    }

    override fun getItemCount(): Int = name.size

    inner class ViewHolder(private val binding: ItemPhoneBinding ):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(name: NamesModel){
            binding.txtName.text = name.name
        }
    }
}