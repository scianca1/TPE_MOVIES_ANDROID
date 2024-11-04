package edu.ar.unicen.tpe.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import edu.ar.unicen.tpe.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class MainActivity : AppCompatActivity(

) {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MovieItemAdapter
    private val viewModel by viewModels<MovieViewModel>()

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            enableEdgeToEdge()
            binding= ActivityMainBinding.inflate(layoutInflater)

            setContentView(binding.root)

            ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }

            subscribeUi()
            subscribeViewModel()
            viewModel.getMovies("en-US&page=1")
        }

    private fun subscribeUi() {
        adapter= MovieItemAdapter(
            items = emptyList(),
            onMoviesChick={movie->
                val intent= Intent(this, DetailsMovieActivity::class.java)
                intent.putExtra("movie",movie)
                if(movie!=null){
                startActivity(intent)
                }else{
                    Toast.makeText(this, "Por alguna razon esa pelicula no carga sus datos", Toast.LENGTH_SHORT).show()
                }
            }
        )

        binding.movieList.adapter=adapter

        binding.botonReintentar.setOnClickListener { viewModel.getMovies("en-US&page=1") }

    }
    private fun subscribeViewModel(){
            viewModel.loading.onEach { loading->
                if(loading){
                    binding.progressBar.visibility= android.view.View.VISIBLE
                }else{
                    binding.progressBar.visibility= android.view.View.INVISIBLE
                }
            }.launchIn(lifecycleScope)

            viewModel.items.onEach { items->
                adapter.updateItems(items?: emptyList())
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