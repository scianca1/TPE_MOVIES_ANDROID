package edu.ar.unicen.tpe.ddl.data

import edu.ar.unicen.tpe.ddl.data.dto.MovieDetailsDto
import edu.ar.unicen.tpe.ddl.data.dto.MovieDto
import edu.ar.unicen.tpe.ddl.data.dto.MoviesResponseDto
import edu.ar.unicen.tpe.ddl.models.MovieDetails
import edu.ar.unicen.tpe.ddl.models.MovieItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class MovieDataSource @Inject constructor(
    private val movieApi: MovieApi
) {
    suspend fun getAllPopularMovies(language:String):List<MovieItem>?{
        return withContext(Dispatchers.IO){
            try {
                delay(1000)
                val response: Response<MoviesResponseDto> = movieApi.getAllPopularMovies(language)
                return@withContext response.body()?.movies?.map{it.tomovieItem()}
            }catch (e:Exception){
                e.printStackTrace()
                return@withContext null
            }
        }
    }

    suspend fun getMovie(movie: MovieItem): MovieDetails?{
        return withContext(Dispatchers.IO){
            try {
                val movieId:Int= movie.id
                val response:Response<MovieDetailsDto> = movieApi.getMovie(movieId)
                return@withContext response.body()?.toMovieDetails()
            }catch (e:Exception){
                e.printStackTrace()
                return@withContext null
            }
        }

    }
//    suspend fun getMovie(movie: MovieItem):MovieItem?{
//        return withContext(Dispatchers.IO){
//                try {
//                    val itemDto=movieItemDao.getItem()
//                    val item= movie.map{it.toMovieItem()}
//                    return@withContext item
//                }catch (e:Exception){
//                    e.printStackTrace()
//                    return@withContext null
//                }
//        }
//    }
}