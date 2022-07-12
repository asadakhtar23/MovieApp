package com.android.movieapp.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.movieapp.R
import com.android.movieapp.bloc.events.CategoryEvent
import com.android.movieapp.bloc.states.CategoryState
import com.android.movieapp.databinding.ItemCategoryBinding
import com.movieapp.core.models.app.Category
import com.movieapp.core.models.category.Results


class CategoryAdapter(var data: List<Category>, private val itemEventsListener: ItemEventsListener): RecyclerView.Adapter<CategoryAdapter.ItemViewHolder>() {

    //class ItemViewHolder(binding: ItemCategoryBinding) : RecyclerView.ViewHolder(binding.root)

    class ItemViewHolder(val binding: ItemCategoryBinding) :
        RecyclerView.ViewHolder(binding.root)

    lateinit var context: Context

    lateinit var binding: ItemCategoryBinding

    private var movieList: List<Results> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        binding = ItemCategoryBinding.inflate(layoutInflater, parent,false)
        context = parent.context
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val data = data[position]
        holder.binding.category = data

        val isExpandable: Boolean = data.isExpandable
        holder.binding.expandableLayout.visibility = if (isExpandable) View.VISIBLE else View.GONE

        handleUI(isExpandable, holder)

        initMovieList(holder)

        if(this.data[position].loadInitially) {
            this.data[position].loadInitially = false
            itemEventsListener.onCategoryEventListener(position,data,CategoryEvent.Expand) { state ->
                handleStates(state, holder)
            }

            handleUI(isExpandable, holder)
        }

        holder.binding.llMain.setOnClickListener {
            data.isExpandable = !data.isExpandable

            itemEventsListener.onCategoryEventListener(position,data,CategoryEvent.Expand) { state ->
                handleStates(state, holder)
            }

            handleUI(isExpandable, holder)
        }

    }

    private fun handleUI(
        isExpandable: Boolean,
        holder: ItemViewHolder
    ) {
        if (isExpandable) {
            holder.binding.ivArrow.setImageResource(R.drawable.ic_arrow_up)
            holder.binding.expandableLayout.visibility = View.VISIBLE
        } else {
            holder.binding.ivArrow.setImageResource(R.drawable.ic_arrow_down)
            holder.binding.expandableLayout.visibility = View.GONE
        }
    }

    private fun initMovieList(holder: ItemViewHolder) {
        val adapter = NestedMovieAdapter(movieList, itemEventsListener)

        holder.binding.rvMovies.layoutManager = LinearLayoutManager(holder.itemView.context)
        holder.binding.rvMovies.setHasFixedSize(true)

        val horizontalLayout = LinearLayoutManager(
            context,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        holder.binding.rvMovies.layoutManager = horizontalLayout

        holder.binding.rvMovies.adapter = adapter
    }

    private fun handleStates(
        state: CategoryState,
        holder: ItemViewHolder
    ) {
        when (state) {
            is CategoryState.Initial -> {

            }
            is CategoryState.Loading -> {
                Log.e("Loading","Loading")
                holder.binding.progressBar.visibility = View.VISIBLE
            }
            is CategoryState.CategoryDataFetched -> {
                Log.e("CategoryDataFetched","CategoryDataFetched")
                movieList = state.data
                notifyItemChanged(holder.adapterPosition)
                holder.binding.progressBar.visibility = View.GONE
            }
        }
    }

//    private fun handleListPopulation(
//        isExpandable: Boolean,
//        position: Int,
//        holder: ItemViewHolder
//    ) {
//
//    }

//    private fun handleState(
//        position: Int,
//        holder: ItemViewHolder,
//        event: CategoryEvent
//    ) {
//
//
//    }

//    private fun initMovieList(
//        state: CategoryState.CategoryDataFetched,
//        holder: ItemViewHolder
//    ) {
//
//    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

}