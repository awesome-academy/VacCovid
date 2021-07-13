package com.example.vaccovid19.data

import com.example.vaccovid19.data.model.World
import com.example.vaccovid19.utils.ApiConstant
import retrofit2.http.GET

interface ApiService {

    @GET(ApiConstant.WORLD_URL)
    suspend fun getWorldData(): List<World>
}
