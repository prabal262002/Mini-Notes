package com.example.cloudnotes.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cloudnotes.databinding.ItemRvNotesBinding
import com.example.cloudnotes.entities.Notes
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class NotesAdapter(private val notesFlow: Flow<List<Notes>>) :
    RecyclerView.Adapter<NotesAdapter.NotesViewHolder>() {
    private var onItemClickListener:((Int) -> Unit)? = null
    private var arrList: List<Notes> = emptyList() // Initialize with an empty list

    init {
        // Collect from the Flow to update the data when Flow emits a new list of notes
        CoroutineScope(Dispatchers.Main).launch {
            notesFlow.collect { notesList ->
                arrList = notesList
                notifyDataSetChanged()
            }
        }
    }
    fun setOnClickListener(listener: OnItemClickListener){
        onItemClickListener = listener
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemRvNotesBinding.inflate(inflater, parent, false)
        return NotesViewHolder(binding,onItemClickListener)
    }

    override fun getItemCount(): Int {
        return arrList.size
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        val note = arrList[position]
        holder.bind(note)
    }

    class NotesViewHolder(private val binding: ItemRvNotesBinding, private val onItemClickListener:((Int) -> Unit)?) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(note: Notes) {
            binding.tvtitle.text = note.title
            binding.tvdatetime.text = note.dateTime
            binding.tvdesc.text = note.noteText
            binding.cardView.setOnClickListener {
                onItemClickListener?.invoke(note.id!!)
            }
        }
    }
    interface OnItemClickListener : (Int) -> Unit {
        fun onClicked(noteId:Int)
    }
}