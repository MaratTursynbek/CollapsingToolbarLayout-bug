package com.example.recyclerviewtest.second

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.recyclerviewtest.MainActivity
import com.example.recyclerviewtest.R

class SecondFragment : Fragment() {

    private val viewModel: SecondViewModel by viewModels()
    private val args: SecondFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.second_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Toolbar>(R.id.toolbar)?.let {
            (view.context as? MainActivity)?.setupNavController(it)
        }

        val tvNumber: TextView = view.findViewById(R.id.second_fragment_tv_number)
        tvNumber.text = args.number.toString()
    }
}