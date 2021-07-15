package com.example.vaccovid19.data

import com.example.vaccovid19.data.model.Country
import com.example.vaccovid19.data.model.World
import com.example.vaccovid19.utils.ApiConstant
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET(ApiConstant.WORLD_URL)
    suspend fun getWorldData(): List<World>

    @GET("{${ApiConstant.CONTINENT_URL}}")
    suspend fun getCountriesInContinent(@Path(ApiConstant.CONTINENT_URL) continent: String): List<Country>
}
