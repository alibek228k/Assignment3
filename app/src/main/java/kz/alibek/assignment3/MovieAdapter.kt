package kz.alibek.assignment3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kz.alibek.assignment3.model.Movie

class MovieAdapter(
    private val movieList: List<Movie>,
    private val onItemClicked: (Movie) -> Unit
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.textView_title)
        val yearTextView: TextView = itemView.findViewById(R.id.textView_year)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movieList[position]
        holder.titleTextView.text = movie.title
        holder.yearTextView.text = movie.year.toString()

        holder.itemView.setOnClickListener {
            onItemClicked(movie)
        }
    }

    override fun getItemCount(): Int = movieList.size
}
