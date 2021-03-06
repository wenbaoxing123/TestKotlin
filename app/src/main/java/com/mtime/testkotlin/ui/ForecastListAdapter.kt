package com.mtime.testkotlin.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mtime.testkotlin.R
import com.mtime.testkotlin.ui.ForecastListAdapter.ViewHolder
import com.mtime.testkotlin.domain.model.Forecast
import com.mtime.testkotlin.domain.model.ForecastList
import com.mtime.testkotlin.extensions.ctx
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_forecast.view.*

/**
 * Created by wenbaoxing on 16/12/19.
 */
class ForecastListAdapter(val weekForecast: ForecastList, val itemClick: (Forecast) -> Unit) : RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_forecast, parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
//        with(weekForecast.dailyForecast[position]) {
//            holder?.textview?.text = "$date-$description-$high-$low"
//        }
        holder?.bindForecast(weekForecast[position])
    }

    override fun getItemCount(): Int = weekForecast.size()

    class ViewHolder(view: View, val itemClick: (Forecast) -> Unit) : RecyclerView.ViewHolder(view) {
//        private val iconView: ImageView
//        private val dateView: TextView
//        private val descriptionView: TextView
//        private val maxTemperatureView: TextView
//        private val minTemperatureView: TextView

        init {
//            iconView = view.find(R.id.icon)
//            dateView = view.find(R.id.date)
//            descriptionView = view.find(R.id.desciption)
//            maxTemperatureView = view.find(R.id.maxTemperature)
//            minTemperatureView = view.find(R.id.minTemperature)
        }

        fun bindForecast(forecast: Forecast) {
            with(forecast) {
                Picasso.with(itemView.ctx).load(iconUrl).into(itemView.icon)
                itemView.date.text = date
                itemView.desciption.text = description
                itemView.maxTemperature.text = "${high.toString()}"
                itemView.minTemperature.text = "${low.toString()}"
                itemView.setOnClickListener { itemClick(forecast) }

                //使用Lambda
//                itemView.setOnClickListener { itemView.ctx.toast("itemclick")}
//                itemView.setOnClickListener ({view -> itemView.ctx.toast("itemclick")})
//                itemView.setOnClickListener ({itemView.ctx.toast("itemclick")})
//                itemView.setOnClickListener (){itemView.ctx.toast("itemclick")}
//                itemView.setOnClickListener {itemView.ctx.toast("itemclick")}
            }
        }

    }

//    public interface OnItemClickListener {
//        operator fun invoke(forecast: Forecast)
//    }


}