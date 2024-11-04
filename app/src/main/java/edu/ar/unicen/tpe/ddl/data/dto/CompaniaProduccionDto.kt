package edu.ar.unicen.tpe.ddl.data.dto

import com.google.gson.annotations.SerializedName

class CompaniaProduccionDto(
    @SerializedName("id")
    val id:Int,
    @SerializedName("logo_path")
    val logoPath:String,
    @SerializedName("name")
    val nombre:String,
    @SerializedName("origin_country")
    val paisOriginal:String
) {
}
//    {
//        "id": 5798,
//        "logo_path": "/tmuI9BGXgpWLmokhlxpnG3IGNQB.png",
//        "name": "Shaw Brothers",
//        "origin_country": "HK"
//    },