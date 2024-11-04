package edu.ar.unicen.tpe.ddl.data.dto

import com.google.gson.annotations.SerializedName

class ColeccionDto (
    @SerializedName("id")
    val id:Int,
    @SerializedName("name")
    val nombre:String,
    @SerializedName("poster_path")
    val posterPath:String,
    @SerializedName("backdrop_path")
    val backdrop_path:String
){

}
//    "belongs_to_collection": {
//    "id": 422837,
//    "name": "Blade Runner Collection",
//    "poster_path": "/qTcATCpiFDcgY8snQIfS2j0bFP7.jpg",
//    "backdrop_path": "/bSHZIvLoPBWyGLeiAudN1mXdvQX.jpg"
//}