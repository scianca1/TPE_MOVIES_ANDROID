package edu.ar.unicen.tpe.ddl.data

import edu.ar.unicen.tpe.ddl.data.dto.MovieDetailsDto
import edu.ar.unicen.tpe.ddl.data.dto.MovieDto
import edu.ar.unicen.tpe.ddl.data.dto.MoviesResponseDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface MovieApi {
    @GET("movie/popular")
    suspend fun getAllPopularMovies(
        @Query("language")
        language:String
    ): Response<MoviesResponseDto>

    @GET("movie/{movie_id}")
    suspend fun getMovie(
        @Path("movie_id") movieId: Int,
    ): Response<MovieDetailsDto>



}