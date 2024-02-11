package com.lnoxx.animeapp.fragments.homeFragment.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lnoxx.animeapp.R
import com.lnoxx.animeapp.databinding.AnimeItemBinding
import com.lnoxx.animeapp.jikanAPI.jikanDataClasses.Anime
import com.squareup.picasso.Picasso

class TopAnimeRecyclerViewAdapter(private var animeList: List<Anime>, private val listener: TopListListener):
    RecyclerView.Adapter<TopAnimeRecyclerViewAdapter.PostHolder>(){
    class PostHolder(view: View):RecyclerView.ViewHolder(view){
        private val binding = AnimeItemBinding.bind(view)
        fun bind(anime: Anime, position: Int,listener: TopListListener){
            with(binding){
                animeTitle.text = anime.title
                val ratingEpisodes = anime.episodes.toString() + " episodes  |  " + anime.score.toString()
                animeRaiting.text = ratingEpisodes
                animeSynopsis.text = anime.synopsis
                ratingPos.text = (position).toString()
                Picasso.get().load(anime.images.jpg.image_url).into(animeImageView)
            }
            itemView.setOnClickListener {
                listener.onOpenAnimeInfo(anime)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.anime_item, parent, false)
        return PostHolder(view)
    }

    override fun getItemCount(): Int {
        return animeList.size
    }

    override fun onBindViewHolder(holder: PostHolder, position: Int) {
        holder.bind(animeList[position],position+1, listener)
    }

    fun addTopAnime(newAnimeList: List<Anime>){
        animeList = newAnimeList
        notifyItemRangeInserted(animeList.size,newAnimeList.size)
    }

    interface TopListListener{
        fun onOpenAnimeInfo(anime: Anime)
    }
}