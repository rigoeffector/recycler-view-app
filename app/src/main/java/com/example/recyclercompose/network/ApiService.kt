package com.example.recyclercompose.network
import com.example.recyclercompose.models.DataModel
import retrofit2.http.GET

interface ApiService {
    @GET("objects")
    suspend fun fetchData(): List<DataModel>
}



