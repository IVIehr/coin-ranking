package com.application.coin_ranking.data.repo

import com.application.coin_ranking.data.model.Country

class CountryRepository {

    val list = listOf<Country>()
    fun sendData() : List<Country>{
        return FakeData.Countries
    }

}