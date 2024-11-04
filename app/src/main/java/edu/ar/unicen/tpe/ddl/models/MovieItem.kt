package edu.ar.unicen.tpe.ddl.models

import android.os.Parcelable
import edu.ar.unicen.tpe.BuildConfig
import kotlinx.parcelize.Parcelize
@Parcelize
class MovieItem(
    val id:Int,
    val titulo:String,
    val posterPath:String
) : Parcelable {
    val fullPosterUrl:String
        get()= BuildConfig.BASE_URL_IMAGES+"$posterPath"
}