package com.example.mbcevjeostanyasproba

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mbcevjeostanyasproba.databinding.ItemCatBinding

class MangaAdapter(
    val context: Context,
    val onClick: (model: Manga, position: Int) -> Unit,
) : RecyclerView.Adapter<MangaAdapter.MangaHolder>() {
    private val list = ArrayList<Manga>()

    inner class MangaHolder(val binding: ItemCatBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindView(manga: Manga, position: Int) {
            binding.tvName.text = manga.name
            binding.tvDisc.text = manga.ReleaseDate.toString()
            Glide.with(context)
                .load(manga.ResId)
                .into(binding.iv)
            binding.author.text = manga.Author
            binding.genre.text = manga.Genre
            binding.button.setOnClickListener {
                onClick(manga, position)
                val navController = binding.root.findNavController()
                val bundle = Bundle()
                bundle.putString("myTextView", manga.Plot)
                bundle.putString("myTextView2", manga.name)
                bundle.putInt("myImage", manga.ResId)
                navController.navigate(R.id.firstToSecond, bundle)


            }

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MangaHolder {
        val view = ItemCatBinding.inflate(LayoutInflater.from(context), parent, false)
        return MangaHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MangaHolder, position: Int) {
        val manga = list[position]
        holder.bindView(manga, position)


    }

    fun setNewData(newList: List<Manga>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()

    }
}