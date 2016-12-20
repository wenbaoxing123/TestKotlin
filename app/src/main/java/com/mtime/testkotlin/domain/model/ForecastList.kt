package com.mtime.testkotlin.domain.model

/**
 * Created by wenbaoxing on 16/12/20.
 */
data class ForecastList(val city: String, val country: String, val dailyForecast: List<Forecast>)