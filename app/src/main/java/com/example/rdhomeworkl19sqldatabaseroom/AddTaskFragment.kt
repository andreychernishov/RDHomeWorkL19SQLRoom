package com.example.rdhomeworkl19sqldatabaseroom

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.rdhomeworkl19sqldatabaseroom.mvvm.TaskViewModel

class AddTaskFragment: Fragment() {
    private lateinit var viewModel: TaskViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.add_task_fragment, container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity()).get(TaskViewModel::class.java)
        val editName: EditText = view.findViewById(R.id.edit_task_text)
        val editDescription: EditText = view.findViewById(R.id.description_edit_text)
        val doneBtn: Button = view.findViewById(R.id.done_btn)

        doneBtn.setOnClickListener {
            val task = editName.text.toString()
            val description = editDescription.text.toString()
            viewModel.add(task,description)
            parentFragmentManager.popBackStack()
        }
    }
}