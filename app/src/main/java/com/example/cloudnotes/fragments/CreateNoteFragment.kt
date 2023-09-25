package com.example.cloudnotes.fragments

import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.cloudnotes.BaseFragment
import com.example.cloudnotes.R
import com.example.cloudnotes.dataBase.NotesDatabase
import com.example.cloudnotes.databinding.FragmentCreateNoteBinding
import com.example.cloudnotes.entities.Notes
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.Date


class CreateNoteFragment : BaseFragment() {
    private lateinit var binding: FragmentCreateNoteBinding
    private var currentDate: String? = null
    private var imagePath: String? = null
    private var noteId = -1
    private var launcher = registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        uri?.let {
            val inputStream = requireActivity().contentResolver.openInputStream(it)
            val bitMap = BitmapFactory.decodeStream(inputStream)
            binding.imageNote.setImageBitmap(bitMap)
            binding.rl.visibility = View.VISIBLE
            imagePath = getImagePathFromUri(uri)
        }
    }

    private fun getImagePathFromUri(uri: Uri): String? {
        val cursor = requireActivity().contentResolver.query(uri, null, null, null, null)
        cursor?.use {
            it.moveToFirst()
            val imagePathColumn = it.getColumnIndex(MediaStore.Images.Media.DATA)
            return it.getString(imagePathColumn)
        }
        return null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        noteId = requireArguments().getInt("noteId", -1)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_create_note, container, false)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            CreateNoteFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Toast.makeText(context, "$noteId", Toast.LENGTH_SHORT).show()
        if (noteId != -1) {
            viewLifecycleOwner.lifecycleScope.launch(Dispatchers.IO) {
                context?.let {
                    val notes = NotesDatabase.getDatabase(it).noteDao().getSpecificNote(noteId)
                    withContext(Dispatchers.Main) {
                        binding.editTextNoteDesc.setText(notes.noteText)
                        binding.editTextTitle.setText(notes.title)
                        binding.editTextSubTitle.setText(notes.subTitle)
                        Toast.makeText(context, "${binding.editTextNoteDesc.text}", Toast.LENGTH_SHORT).show()
                        if (notes.imgPath != null && notes.imgPath!!.isNotEmpty()) {
                            val imageFile = File(notes.imgPath)

                            if (imageFile.exists()) {
                                val inputStream = FileInputStream(imageFile)
                                val bitmap = BitmapFactory.decodeStream(inputStream)

                                if (bitmap != null) {
                                    binding.imageNote.setImageBitmap(bitmap)
                                    binding.rl.visibility = View.VISIBLE
                                } else {
                                    // Handle the case where decoding the image failed.
                                    Toast.makeText(
                                        context,
                                        "Failed to load the image",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                    binding.rl.visibility = View.GONE
                                }
                            } else {
                                // Handle the case where the file does not exist.
                                Toast.makeText(
                                    context,
                                    "Image file does not exist",
                                    Toast.LENGTH_SHORT
                                ).show()
                                binding.rl.visibility = View.GONE
                            }
                        } else {
                            // Handle the case where imgPath is null or empty.
                            binding.rl.visibility = View.GONE
                        }
                    }
                }
            }
            binding.deleteNote.visibility = View.VISIBLE
        }


        val sdf = SimpleDateFormat("dd/mm/yyyy hh:mm:ss")
        currentDate = sdf.format(Date())

        binding.dateTime.text = currentDate

        binding.imgDone.setOnClickListener {
            if (noteId != -1) {
                Log.d("YourTag", "Before updateNote: ${binding.editTextNoteDesc.text}")
                updateNote()
                Log.d("YourTag", "After updateNote: ${binding.editTextNoteDesc.text}")
            } else {
                saveNote()
            }
            replaceFragment(HomeFragment())
        }

        binding.imgBack.setOnClickListener {
            replaceFragment(HomeFragment())
        }

        binding.addImage.setOnClickListener {
            launcher.launch("image/*")
        }

        binding.imageDelete.setOnClickListener {
            imagePath = null
            binding.rl.visibility = View.GONE

        }
        binding.deleteNote.setOnClickListener {
            viewLifecycleOwner.lifecycleScope.launch(Dispatchers.IO) {
                context?.let {
                    NotesDatabase.getDatabase(it).noteDao().deleteSpecificNote(noteId)
                }
            }
            binding.editTextNoteDesc.setText("")
            binding.editTextTitle.setText("")
            binding.editTextSubTitle.setText("")
            binding.rl.visibility = View.GONE
            replaceFragment(HomeFragment())
        }
    }

    private fun updateNote() {
        viewLifecycleOwner.lifecycleScope.launch(Dispatchers.IO) {
            context?.let {
                val notes = NotesDatabase.getDatabase(it).noteDao().getSpecificNote(noteId)
                notes.title = binding.editTextTitle.text.toString()
                notes.subTitle = binding.editTextSubTitle.text.toString()
                val updatedNoteText = binding.editTextNoteDesc.text.toString()
                notes.noteText = updatedNoteText
                notes.dateTime = currentDate
                if (imagePath?.isNotEmpty() == true) {
                    try {
                        val imageFile =
                            File(
                                requireContext().cacheDir,
                                "note_image_${System.currentTimeMillis()}.jpg"
                            )
                        val imageStream = FileInputStream(File(imagePath))
                        val outputStream = FileOutputStream(imageFile)
                        imageStream.copyTo(outputStream)
                        imageStream.close()
                        outputStream.close()
                        notes.imgPath = imageFile.absolutePath
                    } catch (e: Exception) {
                        e.printStackTrace()
                        Toast.makeText(context, "Error saving image.", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    notes.imgPath = imagePath
                }
                withContext(Dispatchers.Main) {
                    binding.editTextNoteDesc.setText(updatedNoteText)
                    // Any other UI updates should be placed here
                }
                NotesDatabase.getDatabase(it).noteDao().updateNote(notes)
            }
        }
        binding.editTextNoteDesc.setText("")
        binding.editTextTitle.setText("")
        binding.editTextSubTitle.setText("")
        binding.rl.visibility = View.GONE
    }



    private fun saveNote() {
        if (binding.editTextTitle.text.isNullOrEmpty() && binding.editTextNoteDesc.text.isNullOrEmpty()
        ) {
            Toast.makeText(context, "Can't Be Empty!!", Toast.LENGTH_SHORT).show()
            return
        }
        val notes = Notes()
        notes.title = binding.editTextTitle.text.toString()
        notes.subTitle = binding.editTextSubTitle.text.toString()
        notes.noteText = binding.editTextNoteDesc.text.toString()
        notes.dateTime = currentDate
        if (imagePath?.isNotEmpty() == true) {
            try {
                val imageFile =
                    File(requireContext().cacheDir, "note_image_${System.currentTimeMillis()}.jpg")
                val imageStream = FileInputStream(File(imagePath))
                val outputStream = FileOutputStream(imageFile)
                imageStream.copyTo(outputStream)
                imageStream.close()
                outputStream.close()
                notes.imgPath = imageFile.absolutePath
            } catch (e: Exception) {
                e.printStackTrace()
                Toast.makeText(context, "Error saving image.", Toast.LENGTH_SHORT).show()
            }
        }
        viewLifecycleOwner.lifecycleScope.launch(Dispatchers.IO) {
            context?.let {
                NotesDatabase.getDatabase(it).noteDao().insertNotes(notes)
            }
        }
        binding.editTextNoteDesc.setText("")
        binding.editTextTitle.setText("")
        binding.editTextSubTitle.setText("")
        binding.rl.visibility = View.GONE

    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentTransition = requireActivity().supportFragmentManager.beginTransaction()
        fragmentTransition.setCustomAnimations(
            android.R.anim.slide_out_right,
            android.R.anim.slide_in_left
        )
        fragmentTransition.replace(R.id.frameLayout, fragment)
        fragmentTransition.addToBackStack(null)
        fragmentTransition.commit()
    }

}