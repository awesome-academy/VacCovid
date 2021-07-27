package com.sun.vaccovid19.data

import com.sun.vaccovid19.data.model.*
import com.sun.vaccovid19.utils.ApiConstant
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("${ApiConstant.DATA_NPM_PARAM}/${ApiConstant.WORLD_URL}")
    suspend fun getWords(): List<World>

    @GET("${ApiConstant.DATA_NPM_PARAM}/{${ApiConstant.CONTINENT_URL}}")
    suspend fun getCountriesInContinent(@Path(ApiConstant.CONTINENT_URL) continent: String): List<Country>

    @GET("${ApiConstant.DATA_OVID_PARAM}/${ApiConstant.SIXMONTH_URL}/{${ApiConstant.SYMBOL_COUNTRY_PARAM}}")
    suspend fun getCountriesPerDay(@Path(ApiConstant.SYMBOL_COUNTRY_PARAM) symbol: String): List<CountryPerDay>

    @GET("${ApiConstant.DATA_VACCINE_URL}/{${ApiConstant.VACCINE_CATEGORY_PARAM}}")
    suspend fun getVaccinesByCategory(@Path(ApiConstant.VACCINE_CATEGORY_PARAM) category: String): List<Vaccine>

    @GET("${ApiConstant.NEWS_URL}/{${ApiConstant.TYPE_NEWS_PARAM}}/{${ApiConstant.PAGE_NEWS_PARAM}}")
    suspend fun getNews(
        @Path(ApiConstant.TYPE_NEWS_PARAM) type: String,
        @Path(ApiConstant.PAGE_NEWS_PARAM) page: String
    ): NewsResponse
}
