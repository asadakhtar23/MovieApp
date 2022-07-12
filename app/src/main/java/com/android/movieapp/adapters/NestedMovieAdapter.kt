package com.android.movieapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.movieapp.bloc.events.MovieDetailsEvent
import com.android.movieapp.databinding.ItemMovieBinding
import com.movieapp.core.models.category.Results

class NestedMovieAdapter (var data: List<Results>, private val itemEventsListener: ItemEventsListener): RecyclerView.Adapter<NestedMovieAdapter.ItemViewHolder>() {

    class ItemViewHolder(val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root)

    lateinit var context: Context

    lateinit var binding: ItemMovieBinding

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        binding = ItemMovieBinding.inflate(layoutInflater, parent,false)
        context = parent.context
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val data = data[position]
        binding.results = data
        holder.binding.clMain.setOnClickListener {
            itemEventsListener.onMovieDetailsEventListener(position, data.id!!, MovieDetailsEvent.MovieDetails)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

}