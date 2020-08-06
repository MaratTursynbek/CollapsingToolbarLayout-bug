package com.example.recyclerviewtest.first

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SimpleItemAnimator
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.recyclerviewtest.MainActivity
import com.example.recyclerviewtest.R
import com.example.recyclerviewtest.first.adapters.FooterAdapter
import com.example.recyclerviewtest.first.adapters.HeaderAdapter
import com.example.recyclerviewtest.first.adapters.NumbersAdapter

class FirstFragment : Fragment(), SwipeRefreshLayout.OnRefreshListener, NumberClickListener {

    private val viewModel: FirstViewModel by viewModels()

    private var refreshLayout: SwipeRefreshLayout? = null
    private var recyclerView: RecyclerView? = null

    private val headerAdapter = HeaderAdapter()
    private val numbersAdapter = NumbersAdapter(this)
    private val footerAdapter = FooterAdapter()

//    private val adapter = ConcatAdapter(
//        ConcatAdapter.Config.Builder().setIsolateViewTypes(false).build(),
//        headerAdapter,
//        numbersAdapter,
//        footerAdapter
//    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.first_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Toolbar>(R.id.toolbar)?.let {
            (view.context as? MainActivity)?.setupNavController(it)
        }

        refreshLayout = view.findViewById(R.id.refresh_layout)
        recyclerView = view.findViewById(R.id.recycler_view)

        recyclerView?.let { rv ->
            rv.setHasFixedSize(true)
            (rv.itemAnimator as? SimpleItemAnimator)?.supportsChangeAnimations = false
            rv.layoutManager = LinearLayoutManager(context)
        }
        refreshLayout?.setOnRefreshListener(this)

        (activity as? MainActivity)?.sharedViewPool?.let { recyclerView?.setRecycledViewPool(it) }
        recyclerView?.adapter = numbersAdapter
    }

    override fun onDestroyView() {
        refreshLayout?.setOnRefreshListener(null)
        refreshLayout = null
        recyclerView = null
        super.onDestroyView()
    }

    override fun onRefresh() {
        refreshLayout?.isRefreshing = false
    }

    override fun onItemClicked(number: Int) {
        Log.d("FirstFragment", "onItemClicked = $number")
        val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment2(number)
        findNavController().navigate(action)
    }
}