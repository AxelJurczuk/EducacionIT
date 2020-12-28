package com.example.android.educacionit.api

import com.example.android.educacionit.model.User
import retrofit2.Call
import retrofit2.http.GET

interface Api {

    //defino las operaciones que quiero hacer con esta api
    @GET("users") //aca va el endpoint sin la /
    fun getUsers (): Call<List<User>>
}