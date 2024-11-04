package edu.ar.unicen.tpe.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import edu.ar.unicen.tpe.BuildConfig
import edu.ar.unicen.tpe.ddl.data.MovieApi
import edu.ar.unicen.tpe.ddl.data.network.AuthorizationInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
@InstallIn(SingletonComponent::class)
class MovieModule {

    @Provides
    fun provideToken():String{
        return "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJjMGYzNjY3OGM2MWQ1NTcyYWEwYTg5YjFkODExN2QyZCIsIm5iZiI6MTczMDQwNjQyNy44NjMyMjksInN1YiI6IjY3MjNkZjUzMTg4MjdhOTMyOWYxYjdhZSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.2wZQPRrO_oXREFqL9uS2wW9cMRUNi9Xed4uhdG8ZY_U"
    }
    @Provides
    fun provideOkHttpClient(token:String):OkHttpClient{
        return  OkHttpClient.Builder().
                addInterceptor(AuthorizationInterceptor(token))
                .build()
    }
    @Provides
    fun provideRetrofi(
        okHttpClient: OkHttpClient
    ):Retrofit{
        return Retrofit.Builder().
                baseUrl(BuildConfig.BASE_URL).
                addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
    }

    @Provides
    fun provideMovieApi(
        retrofit: Retrofit
    ):MovieApi{
        return retrofit.create(MovieApi::class.java)
    }
}