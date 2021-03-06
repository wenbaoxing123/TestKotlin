package com.mtime.testkotlin.domain.model

/**
 * Created by wenbaoxing on 16/12/20.
 */
data class Forecast(val date: String, val description: String, val high: Int, val low: Int, val iconUrl: String)

data class ForecastList(val city: String, val country: String, val dailyForecast: List<Forecast>) {
    operator fun get(position: Int): Forecast = dailyForecast[position]
    fun size(): Int = dailyForecast.size
}