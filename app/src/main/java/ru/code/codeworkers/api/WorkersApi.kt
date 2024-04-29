package ru.code.codeworkers.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import ru.code.codeworkers.BuildConfig
import ru.code.codeworkers.dto.Worker
import java.util.concurrent.TimeUnit

val BASE_URL = "http://stoplight.io/mocks/kode-api/trainee-test/331141861/"

val retrofit = Retrofit.Builder()
    .client(
        OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .run {
                if(BuildConfig.DEBUG) {
                    addInterceptor(HttpLoggingInterceptor().apply {
                        level = HttpLoggingInterceptor.Level.BODY
                    })
                } else {
                    this
                }
            }
            .build()
    )
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

interface WorkersApiService {
    @GET("users")
    fun getAll(): Call<List<Worker>>

//    @POST("posts")
//    fun save(@Body worker: Worker): Call<Worker>
//
//    @POST("posts/{id}/likes")
//    fun likeById(@Path("id") id: Long): Call<Worker>
//
//    @DELETE("posts/{id}/likes")
//    fun unlikeById(@Path("id") id: Long): Call<Worker>
//
//    @DELETE("posts/{id}")
//    fun removeById(@Path("id") id: Long): Call<Unit>
}

object WorkersApi {
    val retrofitService: WorkersApiService by lazy {
        retrofit.create()
    }
}