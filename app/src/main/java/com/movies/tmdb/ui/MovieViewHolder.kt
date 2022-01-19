package com.movies.tmdb.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.movies.tmdb.R

import com.movies.tmdb.model.Movie

class MovieViewHolder(view: View,var context: Context) : RecyclerView.ViewHolder(view) {
    private val name: TextView = view.findViewById(R.id.movie_name)
    private val movieImage: ImageView = view.findViewById(R.id.movieImage)
    private val description: TextView = view.findViewById(R.id.movie_description)



    private var movie: Movie? = null

    init {
        view.setOnClickListener {
           /* val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            view.context.startActivity(intent)*/
        }
    }

    fun bind(movie: Movie?) {
        if (movie == null) {
            val resources = itemView.resources
            name.text = resources.getString(R.string.loading)
            description.visibility = View.GONE


        } else {
            showMovieData(movie)
        }
    }

    private fun showMovieData(movie: Movie) {
        this.movie = movie
        name.text = movie.original_title
        var descriptionVisibility = View.GONE
        if (movie.overview != null) {
            description.text = movie.overview
            descriptionVisibility = View.VISIBLE
        }
        description.visibility = descriptionVisibility
        Glide.with(context)
            .load("https://image.tmdb.org/t/p/w200"+movie.poster_path)
            .into(movieImage)

    }

    companion object {
        fun create(parent: ViewGroup): MovieViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.movie_view_item, parent, false)

            return MovieViewHolder(view,parent.context)
        }
    }
}
