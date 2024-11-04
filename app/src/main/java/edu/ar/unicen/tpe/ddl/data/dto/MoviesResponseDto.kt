package edu.ar.unicen.tpe.ddl.data.dto

import com.google.gson.annotations.SerializedName

data class MoviesResponseDto(
    @SerializedName("results")
    val movies:List<MovieDto>
)