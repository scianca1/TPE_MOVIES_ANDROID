package edu.ar.unicen.tpe.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import edu.ar.unicen.tpe.R
import edu.ar.unicen.tpe.databinding.ItemMovieBinding
import edu.ar.unicen.tpe.ddl.models.MovieItem

class MovieItemAdapter (
    private var items:List<MovieItem>,
    private val onMoviesChick:(MovieItem)->Unit
): RecyclerView.Adapter<MovieItemAdapter.MovieItemViewHolder>(){
    fun updateItems(items:List<MovieItem>){
        this.items = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):MovieItemViewHolder {
        val layoutInflate= LayoutInflater.from(parent.context)
        val binding = ItemMovieBinding.inflate(layoutInflate,parent,false)
        return MovieItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder:MovieItemViewHolder, position: Int) {
        val item= items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class MovieItemViewHolder(
        private val binding: ItemMovieBinding
    ):RecyclerView.ViewHolder(binding.root){
        fun bind(item: MovieItem) {

                binding.TituloItem.text=item.titulo

                Glide.with(itemView.context)
                    .load(item.fullPosterUrl)
                    .placeholder(R.drawable.ic_image_movies_placeholder_white)
                    .error(R.drawable.ic_image_movies_broken)
                    .into(binding.bottomCardMovie)

                binding.bottomCardMovie.setOnClickListener{
                    onMoviesChick(item)
                }
        }
    }

}