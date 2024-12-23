package com.demo.footballmvvmkoinflow_21_08_2024.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.demo.footballmvvmkoinflow_21_08_2024.databinding.FootballListItemBinding
import com.demo.footballmvvmkoinflow_21_08_2024.model.Competitions
import com.demo.footballmvvmkoinflow_21_08_2024.utils.Utils
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.Picasso
import kotlinx.coroutines.withContext

class FootballAdapter(private val competitions: List<Competitions>):RecyclerView.Adapter<FootballAdapter.MyViewHolder>() {

    class MyViewHolder(val binding:FootballListItemBinding):RecyclerView.ViewHolder(binding.root) {
        fun bindView(competitions: Competitions){
            binding.txtId.text = competitions.id.toString()
            binding.txtName.text = competitions.name
            val url = competitions.area.flag
            Picasso.get()
                .load(url)
                .networkPolicy(NetworkPolicy.NO_CACHE)
                .into(binding.imageFootball)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): FootballAdapter.MyViewHolder {
        val binding = FootballListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FootballAdapter.MyViewHolder, position: Int) {
        holder.bindView(competitions[position])
    }

    override fun getItemCount(): Int {
       return competitions.size
    }
}