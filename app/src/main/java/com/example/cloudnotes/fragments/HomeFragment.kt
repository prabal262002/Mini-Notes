package com.example.cloudnotes.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.cloudnotes.BaseFragment
import com.example.cloudnotes.R
import com.example.cloudnotes.adapter.NotesAdapter
import com.example.cloudnotes.dataBase.NotesDatabase
import com.example.cloudnotes.databinding.FragmentHomeBinding
import com.example.cloudnotes.entities.Notes
import kotlinx.coroutines.launch


class HomeFragment : BaseFragment() {
    private lateinit var binding:FragmentHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)

        launch{
            context?.let {
                val notes = NotesDatabase.getDatabase(it).noteDao().getAllNotes()
                val notesAdapter = NotesAdapter(notes)
                notesAdapter.setOnClickListener(onClicked)
                binding.recyclerView.adapter = notesAdapter
            }
        }



        binding.btnCreateNote.setOnClickListener {
            replaceFragment(CreateNoteFragment.newInstance(),true)
        }
    }

    private val onClicked = object : NotesAdapter.OnItemClickListener{
        override fun onClicked(noteId:Int) {
            val fragment :Fragment
            val bundle = Bundle()
            bundle.putInt("noteId",noteId)
            fragment = CreateNoteFragment.newInstance()
            fragment.arguments = bundle
            replaceFragment(fragment,false)
        }

        override fun invoke(noteId: Int) {
            onClicked(noteId)
        }


    }
    private fun replaceFragment(fragment: Fragment, isTransition: Boolean) {
        val fragmentTransition = requireActivity().supportFragmentManager.beginTransaction()
        if (isTransition) {
            fragmentTransition.setCustomAnimations(
                android.R.anim.slide_out_right,
                android.R.anim.slide_in_left
            )
        }
        fragmentTransition.replace(R.id.frameLayout,fragment)
        fragmentTransition.addToBackStack(null)
        fragmentTransition.commit()
    }

}