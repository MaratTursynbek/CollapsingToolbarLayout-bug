package com.example.recyclerviewtest.first.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewtest.R
import com.example.recyclerviewtest.first.NumberClickListener
import com.example.recyclerviewtest.first.viewholders.HeaderViewHolder
import com.example.recyclerviewtest.first.viewholders.NumberViewHolder

class NumbersAdapter(private val listener: NumberClickListener) : RecyclerView.Adapter<NumberViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumberViewHolder {
        return NumberViewHolder(LayoutInflater.from(parent.context).inflate(viewType, parent, false))
    }

    override fun getItemCount(): Int {
        return 13
    }

    override fun onBindViewHolder(holder: NumberViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.list_number
    }

    override fun onViewAttachedToWindow(holder: NumberViewHolder) {
        super.onViewAttachedToWindow(holder)
        holder.setClickListener(listener)
    }

    override fun onViewDetachedFromWindow(holder: NumberViewHolder) {
        super.onViewDetachedFromWindow(holder)
        holder.setClickListener(null)
    }
}