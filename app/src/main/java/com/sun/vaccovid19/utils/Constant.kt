package com.sun.vaccovid19.utils

object ApiConstant {
    const val BASE_URL =
        "https://vaccovid-coronavirus-vaccine-and-treatment-tracker.p.rapidapi.com/api/"
    const val API_PARAM = "x-rapidapi-key"
    const val DATA_NPM_PARAM = "npm-covid-data"
    const val DATA_OVID_PARAM = "covid-ovid-data"


    const val WORLD_URL = "world"
    const val CONTINENT_URL = "continent"
    const val SIXMONTH_URL = "sixmonth"
    const val DATA_VACCINE_URL = "vaccines"
    const val NEWS_URL = "news"

    const val SYMBOL_COUNTRY_PARAM = "symbol"
    const val VACCINE_CATEGORY_PARAM = "vaccineCategory"
    const val CONTINENT_EURO_PARAM = "europe"
    const val CONTINENT_ASIA_PARAM = "asia"
    const val CONTINENT_SOUTHERN_PARAM = "southamerica"
    const val CONTINENT_NORTHERN_PARAM = "northamerica"
    const val CONTINENT_OCEANIA_PARAM = "australia"
    const val CONTINENT_AFRICA_PARAM = "africa"

    const val CLINICAL_VACCINE_PARAM = "get-all-vaccines-pre-clinical"
    const val PHASE1_VACCINE_PARAM = "get-all-vaccines-phase-i"
    const val PHASE2_VACCINE_PARAM = "get-all-vaccines-phase-ii"
    const val PHASE3_VACCINE_PARAM = "get-all-vaccines-phase-iii"
    const val PHASE4_VACCINE_PARAM = "get-all-vaccines-phase-iv"

    const val TYPE_NEWS_PARAM = "typenews"
    const val PAGE_NEWS_PARAM = "pagenews"
    const val HEALTH_NEWS_PARAM = "get-health-news"
    const val VACCINE_NEWS_PARAM = "get-vaccine-news"
    const val COVID_NEWS_PARAM = "get-coronavirus-news"

}

object AppConstant {
    const val BLANK = ""
    const val FIRST_PAGE = 1
    const val END_PAGE = 5
}
