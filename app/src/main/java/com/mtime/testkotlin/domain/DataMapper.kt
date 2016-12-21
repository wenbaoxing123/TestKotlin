package com.mtime.testkotlin.domain

import com.mtime.testkotlin.data.Forecast
import com.mtime.testkotlin.data.ForecastResult
import com.mtime.testkotlin.domain.model.ForecastList
import java.text.DateFormat
import java.util.*
import com.mtime.testkotlin.domain.model.Forecast as ModelForecast

/**
 * Created by wenbaoxing on 16/12/19.
 */
public class ForecastDataMapper {
    fun convertFromDataModel(forecast: ForecastResult): ForecastList {
        return ForecastList(forecast.city.name, forecast.city.country, converForecastListToDomain(forecast.list))
    }

    private fun converForecastListToDomain(list: List<Forecast>): List<ModelForecast> {
        return list.map { converForecastItemToDomain(it) }
    }

    private fun converForecastItemToDomain(forecast: Forecast): ModelForecast {
        return ModelForecast(converDate(forecast.dt), forecast.weather[0].description, forecast.temp.max.toInt(), forecast.temp.min.toInt(), generateIconUrl(forecast.weather[0].icon))
    }

    private fun generateIconUrl(iconCode: String): String = "http://openweathermap.org/img/w/$iconCode.png"

    private fun converDate(date: Long): String {
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        return df.format(date * 1000)
    }
}