package com.mtime.testkotlin.data

import com.google.gson.Gson

/**
 * Created by wenbaoxing on 16/12/19.
 */
public class ForecastRequst (val zipCode:String){
    companion object{
        //6d7e28663e3ad76c6e2e8cd1471d2018
        //1564a06818f61f7b8d7823ca833e1ce
        private val APP_ID="6d7e28663e3ad76c6e2e8cd1471d2018"
        private val URL="http://api.openweathermap.org/data/2.5/"+"forecast/daily?mode=json&units=metric&cnt=7"
        private val COMPLETE_URL="$URL&APPID=$APP_ID&q="
    }

    fun execute():ForecastResult{
        val forecastJsonStr=java.net.URL(COMPLETE_URL+zipCode).readText()
        return Gson().fromJson(forecastJsonStr,ForecastResult::class.java)
    }


}