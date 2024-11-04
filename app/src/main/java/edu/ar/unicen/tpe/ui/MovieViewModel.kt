package edu.ar.unicen.tpe.ui

import androidx.lifecycle.ViewModel
import edu.ar.unicen.tpe.ddl.models.MovieItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.ar.unicen.tpe.ddl.data.MovieRepository
import edu.ar.unicen.tpe.ddl.models.MovieDetails
import kotlinx.coroutines.launch
import org.intellij.lang.annotations.Language
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val movieRepository: MovieRepository
):ViewModel() {

    private val _loading= MutableStateFlow(false)
    val loading = _loading.asStateFlow()

    private val _error = MutableStateFlow(false)
    val error = _error.asStateFlow()


    private val _items = MutableStateFlow<List<MovieItem>?>(null)
    val items = _items.asStateFlow()

    private val _movieDetails= MutableStateFlow<MovieDetails?>(null)
    val movieDetails= _movieDetails.asStateFlow()

    fun getMovies(language: String){
        viewModelScope.launch {
            _loading.value= true
            _error.value=false

            val items= movieRepository.getAll(language)

            _items.value=items
            _loading.value=false
            _error.value= items==null

        }
    }

    fun getMovie(movie: MovieItem) {
        viewModelScope.launch {
            _loading.value= true
            _error.value=false

            val movie= movieRepository.getmovie(movie)

            _movieDetails.value=movie
            _loading.value=false
            _error.value= movie==null

        }

    }


}