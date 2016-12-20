package com.mtime.testkotlin

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import com.mtime.testkotlin.ForecastListAdapter.ViewHolder
import com.mtime.testkotlin.domain.model.ForecastList

/**
 * Created by wenbaoxing on 16/12/19.
 */
class ForecastListAdapter(val weekForecast: ForecastList) : RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(TextView(parent?.context))
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        with(weekForecast.dailyForecast[position]){
            holder?.textview?.text="$date-$description-$high-$low"
        }
    }

    override fun getItemCount(): Int = weekForecast.dailyForecast.size

    class ViewHolder(val textview: TextView) : RecyclerView.ViewHolder(textview)
}