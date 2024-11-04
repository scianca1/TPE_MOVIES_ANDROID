package edu.ar.unicen.tpe.ddl.data.dto
import com.google.gson.annotations.SerializedName
import edu.ar.unicen.tpe.ddl.models.MovieItem

class MovieDto(
    @SerializedName("adult")
    val adult:Boolean,
    @SerializedName("backdrop_path")
    val backdrop_path:String,
    @SerializedName("genre_ids")
    val genre_ids:List<Int>,
    @SerializedName("id")
    val id:Int,
    @SerializedName("original_language")
    val language:String,
    @SerializedName("original_title")
    val originalTitle:String,
    @SerializedName("overview")
    val descripcion:String,
    @SerializedName("popularity")
    val popularidad:Double,
    @SerializedName("poster_path")
    val poster_path:String,
    @SerializedName("release_date")
    val release_date:String,
    @SerializedName("title")
    val titulo:String,
    @SerializedName("video")
    val video:Boolean,
    @SerializedName("vote_average")
    val vote_average:Double,
    @SerializedName("vote_count")
    val cantidadVotos:Int


){
    fun tomovieItem(): MovieItem {
        return MovieItem(
            id= id,
            titulo= titulo,
            posterPath= poster_path
            )
    }

}

