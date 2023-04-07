package com.example.mbcevjeostanyasproba

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.mbcevjeostanyasproba.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {

    lateinit var binding: FragmentFirstBinding

    lateinit var adapter: MangaAdapter
    val navController by lazy { findNavController() }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rw = requireActivity().findViewById<RecyclerView>(R.id.rw)

        adapter = MangaAdapter(requireContext()) { manga, position ->
            Toast.makeText(requireContext(), "${manga.name}", Toast.LENGTH_SHORT).show()


        }
        adapter.setNewData(createManga())
        rw.adapter = adapter
    }

}