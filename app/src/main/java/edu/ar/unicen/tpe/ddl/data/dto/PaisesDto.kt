package edu.ar.unicen.tpe.ddl.data.dto

import com.google.gson.annotations.SerializedName

class PaisesDto (
   @SerializedName("iso_3166_1")
   val nombreAbreviado:String,
   @SerializedName("name")
    val nombre:String
){

}
//    {
//        "iso_3166_1": "US",
//        "name": "United States of America"
//    }