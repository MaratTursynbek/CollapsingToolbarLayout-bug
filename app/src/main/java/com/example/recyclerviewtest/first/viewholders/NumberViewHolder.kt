package com.example.recyclerviewtest.first.viewholders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewtest.R
import com.example.recyclerviewtest.first.NumberClickListener

class NumberViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

    private val tvTitle: TextView = itemView.findViewById(R.id.list_number_tv_title)

    private var clickListener: NumberClickListener? = null

    init {
        itemView.setOnClickListener(this)
    }

    fun setClickListener(listener: NumberClickListener?) {
        this.clickListener = listener
    }

    fun bind() {
        tvTitle.text = adapterPosition.toString()
    }

    override fun onClick(v: View?) {
        clickListener?.onItemClicked(adapterPosition)
    }
}