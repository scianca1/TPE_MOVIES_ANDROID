package edu.ar.unicen.tpe.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import edu.ar.unicen.tpe.R
import edu.ar.unicen.tpe.databinding.ActivityDetailsMovieBinding
import edu.ar.unicen.tpe.databinding.ActivityMainBinding
import edu.ar.unicen.tpe.ddl.models.MovieDetails
import edu.ar.unicen.tpe.ddl.models.MovieItem
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class DetailsMovieActivity: AppCompatActivity() {
    private lateinit var binding: ActivityDetailsMovieBinding

    private val viewModel by viewModels<MovieViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= ActivityDetailsMovieBinding.inflate(layoutInflater)

        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.detailsMovie) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        suscribeUi()
        subscribeViewModel()
        val movie= intent.getParcelableExtra<MovieItem>("movie")
        if(movie!=null) {
//            binding.TituloMovie.text = movie.titulo
            viewModel.getMovie(movie)
        }


    }

    private fun suscribeUi() {

        binding.botonReintentar.setOnClickListener {
            val movie= intent.getParcelableExtra<MovieItem>("movie")
            if(movie!=null) {
                viewModel.getMovie(movie)
            }
             }
    }

    private fun subscribeViewModel() {
        viewModel.loading.onEach { loading->
            if(loading){
                binding.progressBar.visibility= android.view.View.VISIBLE
            }else{
                binding.progressBar.visibility= android.view.View.INVISIBLE
            }
        }.launchIn(lifecycleScope)

        viewModel.movieDetails.onEach { movie->
            if(movie!=null){
                binding.TituloMovie.text= movie.titulo
                Glide.with(this)
                    .load(movie.fullPosterUrl)
                    .placeholder(R.drawable.ic_image_movies_placeholder_white)
                    .error(R.drawable.ic_image_movies_broken)
                    .into(binding.image)
                binding.descripcion.text=movie.detalle
                binding.duracion.text= movie.duracionMin.toString()+" min"
                binding.Lansamiento.text=movie.fechaEstreno
                binding.valoracion.text=movie.valoracion.toString()

                binding.generos.text= movie.generos.joinToString (", ")
                if(movie.masdieciocho==true){
                    binding.apto.text= "18+"
                }else{
                    binding.apto.text= "Apto para todas las edades"
                }
            }
        }.launchIn(lifecycleScope)

        viewModel.error.onEach { error->
            if(error){
                binding.error.visibility= android.view.View.VISIBLE
                binding.botonReintentar.visibility=android.view.View.VISIBLE
            }else{
                binding.error.visibility= android.view.View.INVISIBLE
                binding.botonReintentar.visibility=android.view.View.INVISIBLE
            }
        }.launchIn(lifecycleScope)
    }


}