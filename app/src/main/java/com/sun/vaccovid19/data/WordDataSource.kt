package com.sun.vaccovid19.data

import com.sun.vaccovid19.data.model.World

interface WordDataSource {

    suspend fun getWordData(): World
}
