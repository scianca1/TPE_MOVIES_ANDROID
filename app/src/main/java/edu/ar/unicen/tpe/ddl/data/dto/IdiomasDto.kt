package edu.ar.unicen.tpe.ddl.data.dto

import com.google.gson.annotations.SerializedName

class IdiomasDto (
    @SerializedName("english_name")
    val nombreIdioma:String,
    @SerializedName("iso_639_1")
    val nombreAbreviado:String,
    @SerializedName("name")
    val nombre:String
){
}
//    {
//        "english_name": "English",
//        "iso_639_1": "en",
//        "name": "English"
//    }