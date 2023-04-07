package com.example.mbcevjeostanyasproba

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.mbcevjeostanyasproba.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {


    lateinit var binding: FragmentSecondBinding
    lateinit var adapter: MangaAdapter
    val navController by lazy { findNavController() }
    private var mangaDesc: String? = null
    private var mangaName: String? = null
    private var mangaPic: Int? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(layoutInflater, container, false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            mangaDesc = it.getString("myTextView")
            mangaName = it.getString("myTextView2")
            mangaPic = it.getInt("myImage")
        }
        binding.gaga.text = mangaDesc
        binding.qweZXC.text = mangaName
        Glide.with(requireContext())
            .load(mangaPic)
            .into(binding.gugu)



    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                requireActivity().onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

}