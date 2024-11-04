package edu.ar.unicen.tpe.ddl.data.dto

import com.google.gson.annotations.SerializedName
import edu.ar.unicen.tpe.ddl.models.MovieDetails
import edu.ar.unicen.tpe.ddl.models.MovieItem

class MovieDetailsDto (
    @SerializedName("adult")
    val adult:Boolean,
    @SerializedName("backdrop_path")
    val backdrop_path:String,
    @SerializedName("belongs_to_collection")
    val coleccion:ColeccionDto,
    @SerializedName("budget")
    val presupuestoDolar: Int,
    @SerializedName("genres")
    val generos:List<GeneroDto>,
    @SerializedName("homepage")
    val pagOficial:String,
    @SerializedName("id")
    val id:Int,
    @SerializedName("imdb_id")
    val imdb_id:String,
    @SerializedName("origin_country")
    val origen:List<String>,
    @SerializedName("original_language")
    val idioma:String,
    @SerializedName("original_title")
    val tituloOriginal:String,
    @SerializedName("overview")
    val detalle:String,
    @SerializedName("popularity")
    val popularidad:Double,
    @SerializedName("poster_path")
    val poster_path:String,
    @SerializedName("production_companies")
    val companiasDeProduccion:List<CompaniaProduccionDto>,
    @SerializedName("production_countries")
    val paisesDeProduccion:List<PaisesDto>,
    @SerializedName("release_date")
    val fechaEstreno:String,
    @SerializedName("revenue")
    val recaudacion:Int,
    @SerializedName("runtime")
    val durecionMin:Int,
    @SerializedName("spoken_languages")
    val idiomasTraducidos:List<IdiomasDto>,
    @SerializedName("status")
    val estado:String,
    @SerializedName("tagline")
    val FracePromocional:String,
    @SerializedName("title")
    val titulo:String,
    @SerializedName("video")
    val video:Boolean,
    @SerializedName("vote_average")
    val valoracion: Double,
    @SerializedName("vote_count")
    val nroDevotos:Int

){
    fun toMovieDetails(): MovieDetails {
        return MovieDetails(
             masdieciocho=adult,
             backdrop_path=backdrop_path,
             generos=generos.map{it.nombre},
             pagOficial=pagOficial,
             id=id,
             origen=origen,
             idioma=idioma,
             tituloOriginal=tituloOriginal,
             detalle=detalle,
             popularidad=popularidad,
             companiasDeProduccion=companiasDeProduccion.map{it.nombre},
             fechaEstreno=fechaEstreno,
             duracionMin=durecionMin,
             idiomasTraducidos=idiomasTraducidos.map {it.nombre},
             estado=estado,
             titulo=titulo,
             valoracion=valoracion,
             nroDevotos=nroDevotos
        )
    }



}
//{
//    "adult": false,
//    "backdrop_path": "/qr7dUqleMRd0VgollazbmyP9XjI.jpg",
//    "belongs_to_collection": {
//    "id": 422837,
//    "name": "Blade Runner Collection",
//    "poster_path": "/qTcATCpiFDcgY8snQIfS2j0bFP7.jpg",
//    "backdrop_path": "/bSHZIvLoPBWyGLeiAudN1mXdvQX.jpg"
//},
//    "budget": 28000000,
//    "genres": [
//    {
//        "id": 878,
//        "name": "Science Fiction"
//    },
//    {
//        "id": 18,
//        "name": "Drama"
//    },
//    {
//        "id": 53,
//        "name": "Thriller"
//    }
//    ],
//    "homepage": "http://www.warnerbros.com/blade-runner",
//    "id": 78,
//    "imdb_id": "tt0083658",
//    "origin_country": [
//    "US"
//    ],
//    "original_language": "en",
//    "original_title": "Blade Runner",
//    "overview": "In the smog-choked dystopian Los Angeles of 2019, blade runner Rick Deckard is called out of retirement to terminate a quartet of replicants who have escaped to Earth seeking their creator for a way to extend their short life spans.",
//    "popularity": 52.545,
//    "poster_path": "/63N9uy8nd9j7Eog2axPQ8lbr3Wj.jpg",
//    "production_companies": [
//    {
//        "id": 5798,
//        "logo_path": "/tmuI9BGXgpWLmokhlxpnG3IGNQB.png",
//        "name": "Shaw Brothers",
//        "origin_country": "HK"
//    },
//    {
//        "id": 7965,
//        "logo_path": "/eZ6DeFO1mhHtzxB1aACcEzKqQ7L.png",
//        "name": "The Ladd Company",
//        "origin_country": "US"
//    },
//    {
//        "id": 174,
//        "logo_path": "/zhD3hhtKB5qyv7ZeL4uLpNxgMVU.png",
//        "name": "Warner Bros. Pictures",
//        "origin_country": "US"
//    }
//    ],
//    "production_countries": [
//    {
//        "iso_3166_1": "US",
//        "name": "United States of America"
//    },
//    {
//        "iso_3166_1": "HK",
//        "name": "Hong Kong"
//    },
//    {
//        "iso_3166_1": "GB",
//        "name": "United Kingdom"
//    }
//    ],
//    "release_date": "1982-06-25",
//    "revenue": 41722424,
//    "runtime": 118,
//    "spoken_languages": [
//    {
//        "english_name": "English",
//        "iso_639_1": "en",
//        "name": "English"
//    },
//    {
//        "english_name": "German",
//        "iso_639_1": "de",
//        "name": "Deutsch"
//    },
//    {
//        "english_name": "Cantonese",
//        "iso_639_1": "cn",
//        "name": "广州话 / 廣州話"
//    },
//    {
//        "english_name": "Japanese",
//        "iso_639_1": "ja",
//        "name": "日本語"
//    },
//    {
//        "english_name": "Hungarian",
//        "iso_639_1": "hu",
//        "name": "Magyar"
//    }
//    ],
//    "status": "Released",
//    "tagline": "Man has made his match...now it's his problem.",
//    "title": "Blade Runner",
//    "video": false,
//    "vote_average": 7.9,
//    "vote_count": 13695
//}