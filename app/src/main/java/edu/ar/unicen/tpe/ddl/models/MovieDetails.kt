package edu.ar.unicen.tpe.ddl.models

import edu.ar.unicen.tpe.BuildConfig

class MovieDetails(
    val masdieciocho:Boolean,
    val backdrop_path:String,
    val generos: List<String>,
    val pagOficial:String,
    val id:Int,
    val origen:List<String>,
    val idioma:String,
    val tituloOriginal:String,
    val detalle:String,
    val popularidad:Double,
    val companiasDeProduccion:List<String>,
    val fechaEstreno:String,
    val duracionMin:Int,
    val idiomasTraducidos:List<String>,
    val estado:String,
    val titulo:String,
    val valoracion:Double,
    val nroDevotos:Int
) {
    val fullPosterUrl:String
        get()= BuildConfig.BASE_URL_IMAGES+"$backdrop_path"
}