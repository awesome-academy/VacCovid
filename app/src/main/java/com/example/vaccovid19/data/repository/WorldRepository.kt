package com.example.vaccovid19.data.repository

import com.example.vaccovid19.data.WordDataSource

class WorldRepository(
    private val worldDataSource: WordDataSource
) {

    suspend fun getWorldData() = worldDataSource.getWordData()
}
