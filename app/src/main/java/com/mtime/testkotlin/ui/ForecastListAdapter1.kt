package com.mtime.testkotlin.ui

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import com.mtime.testkotlin.ui.ForecastListAdapter1.ViewHolder

/**
 * Created by wenbaoxing on 16/12/19.
 */
class ForecastListAdapter1(val items: List<String>) : RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(TextView(parent?.context))
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.textview?.text = items[position]
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(val textview: TextView) : RecyclerView.ViewHolder(textview)
}