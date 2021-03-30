package com.example.convidados.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.convidados.R
import com.example.convidados.viewModel.AbsentsViewModel

class AbsentsFragment : Fragment() {

  private lateinit var absentsViewModel: AbsentsViewModel

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    absentsViewModel =
    ViewModelProviders.of(this).get(AbsentsViewModel::class.java)
    val root = inflater.inflate(R.layout.fragment_slideshow, container, false)
    val textView: TextView = root.findViewById(R.id.text_slideshow)
    absentsViewModel.text.observe(viewLifecycleOwner, Observer {
      textView.text = it
    })
    return root
  }
}