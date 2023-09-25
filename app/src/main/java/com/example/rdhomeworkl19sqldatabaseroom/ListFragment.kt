package com.example.rdhomeworkl19sqldatabaseroom

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rdhomeworkl19sqldatabaseroom.database.TaskEntity
import com.example.rdhomeworkl19sqldatabaseroom.mvvm.TaskViewModel
import com.example.rdhomeworkl19sqldatabaseroom.recycler.TaskEntityListAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListFragment: Fragment() {

    private lateinit var viewModel:TaskViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(TaskViewModel::class.java)
        val listView: RecyclerView = view.findViewById(R.id.fragment_rc)
        val fab : FloatingActionButton = view.findViewById(R.id.fragment_fab)
        val adapter = TaskEntityListAdapter()
        listView.adapter = adapter
        listView.layoutManager = LinearLayoutManager(requireContext())

        viewModel.listState.observe(viewLifecycleOwner){ uiState->
            when(uiState){
                is TaskViewModel.ListState.EmptyList -> Unit
                is TaskViewModel.ListState.UpdateList ->{
                    adapter.updateItems(uiState.list)
                }
            }
        }
        fab.setOnClickListener{
            val fragment = AddTaskFragment()
            parentFragmentManager.beginTransaction()
                .add(R.id.main_container,fragment)
                .addToBackStack(fragment.javaClass.name)
                .commit()
        }
    }
}