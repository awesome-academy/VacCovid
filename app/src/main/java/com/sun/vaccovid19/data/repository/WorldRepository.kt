package com.sun.vaccovid19.data.repository

import com.sun.vaccovid19.data.WordDataSource

class WorldRepository(
    private val worldDataSource: WordDataSource
) {

    suspend fun getWorldData() = worldDataSource.getWordData()
}
