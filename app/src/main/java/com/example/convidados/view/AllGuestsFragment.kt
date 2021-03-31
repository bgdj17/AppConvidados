package com.example.convidados.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.convidados.R
import com.example.convidados.view.adapter.GuestAdapter
import com.example.convidados.viewModel.AllGuestsViewModel

class AllGuestsFragment : Fragment() {

  private lateinit var allGuestsViewModel: AllGuestsViewModel

  private val mAdapter : GuestAdapter = GuestAdapter()

  override fun onCreateView(inflater: LayoutInflater,   container: ViewGroup?, savedInstanceState: Bundle?): View? {
    allGuestsViewModel =  ViewModelProvider(this).get(AllGuestsViewModel::class.java)
    val root = inflater.inflate(R.layout.fragment_all, container, false)

    //para fazer uma Recycler tem que ter: obter uma recycler, Layout, Adapter,

    val recycler = root.findViewById<RecyclerView>(R.id.recycler_all_guest)
    recycler.layoutManager = LinearLayoutManager(context)
    recycler.adapter = mAdapter

    //fim recycler

    observer()

    allGuestsViewModel.load()

    return root
  }

  private fun observer(){

    allGuestsViewModel.guestList.observe(viewLifecycleOwner, Observer {
      mAdapter.notifyDataSetChanged()

    })
  }
}