package com.sun.vaccovid19.data.source.remote

import com.sun.vaccovid19.data.ApiService
import com.sun.vaccovid19.data.WordDataSource
import com.sun.vaccovid19.data.model.World

class WorldRemoteDataSource(
    private val service: ApiService
) : WordDataSource {

    override suspend fun getWordData(): World = service.getWords().first()
}
