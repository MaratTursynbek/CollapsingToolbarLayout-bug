package com.example.recyclerviewtest.first.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewtest.R
import com.example.recyclerviewtest.first.viewholders.FooterViewHolder
import com.example.recyclerviewtest.first.viewholders.HeaderViewHolder

class FooterAdapter : RecyclerView.Adapter<FooterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FooterViewHolder {
        return FooterViewHolder(LayoutInflater.from(parent.context).inflate(viewType, parent, false))
    }

    override fun getItemCount(): Int {
        return 1
    }

    override fun onBindViewHolder(holder: FooterViewHolder, position: Int) {

    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.list_footer
    }
}