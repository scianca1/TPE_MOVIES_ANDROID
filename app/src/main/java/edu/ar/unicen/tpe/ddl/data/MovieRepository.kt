package edu.ar.unicen.tpe.ddl.data

import edu.ar.unicen.tpe.ddl.models.MovieDetails
import edu.ar.unicen.tpe.ddl.models.MovieItem
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val data:MovieDataSource
) {
    suspend fun getAll(language:String):List<MovieItem>?{
        return data.getAllPopularMovies(language)
    }

   suspend fun getmovie(movie: MovieItem): MovieDetails? {
        return data.getMovie(movie)
    }
//    suspend fun getMovie(item:MovieItem):MovieItem?{
//        return data.getMovie(item)
//    }
}