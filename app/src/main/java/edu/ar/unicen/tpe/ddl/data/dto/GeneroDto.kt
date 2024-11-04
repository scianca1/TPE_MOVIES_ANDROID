package edu.ar.unicen.tpe.ddl.data.dto

import com.google.gson.annotations.SerializedName

class GeneroDto (
    @SerializedName("id")
    val id:Int,
    @SerializedName("name")
    val nombre:String
){

}
//{
//        "id": 878,
//        "name": "Science Fiction"
//    }