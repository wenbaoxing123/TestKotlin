package com.mtime.testkotlin.domain

import com.mtime.testkotlin.data.ForecastRequst
import com.mtime.testkotlin.domain.model.ForecastList

/**
 * Created by wenbaoxing on 16/12/20.
 */
class RequestForecastCommand(val zipCode: String) : Command<ForecastList> {
    override fun execute(): ForecastList {
        val forecastRequst = ForecastRequst(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequst.execute())
    }
}