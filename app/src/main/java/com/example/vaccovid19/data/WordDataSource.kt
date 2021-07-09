package com.example.vaccovid19.data

import com.example.vaccovid19.data.model.World

interface WordDataSource {

    suspend fun getWordData(): World
}
