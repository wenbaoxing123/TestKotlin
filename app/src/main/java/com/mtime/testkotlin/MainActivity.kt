package com.mtime.testkotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.mtime.testkotlin.domain.RequestForecastCommand
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.async
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {
    var a = 1
    var b = 2
    var s = "hello"
    val arr: IntArray = intArrayOf(110, 114, 119)
    val MAX = 1024
    private val items = listOf(
            "Mon 6/23 - Sunny - 31/17",
            "Tue 6/24 - Sunny - 31/17",
            "Wed 6/25 - Sunny - 31/17",
            "Thurs 6/26 - Sunny - 31/17",
            "Fri 6/27 - Sunny - 31/17",
            "Sat 6/28 - Sunny - 31/17",
            "Sun 6/29 - Sunny - 31/17"
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv.text = "Hello Kotlin!"

        val forecastList = findViewById(R.id.forecast_list) as RecyclerView
        forecastList.layoutManager = LinearLayoutManager(this)

        async() {
            val result = RequestForecastCommand("94043").execute()
            uiThread {
                forecastList.adapter = ForecastListAdapter(result)
            }
        }


//        btn.setOnClickLis

        println("wenbaoxing say $s")

        println("MAX = $MAX")

        println("sum($a,$b)=" + sum(a, b))

        println("max($a,$b)=" + max(a, b))

        printInt(a)

        printIntArray(arr)

        testWhen(1)
        testWhen("hello")
        testWhen(1L)
        testWhen(1f)
        testWhen(0x00001111)

        testRanges(1)
        testRanges(100)
    }

    fun max(a: Int, b: Int): Int {
        if (a > b)
            return a
        else
            return b
    }

    fun sum(a: Int, b: Int) = a + b

    fun printInt(i: Int): Unit {
        println("int value = $i")
    }

    //for循环
    fun printIntArray(arr: IntArray) {
        for (i in arr)
            println("element:$i")

        for (i in arr.indices)
            println("arr[$i]=${arr[i]}")
    }

    fun testWhen(obj: Any) {
        when (obj) {
            1 -> println("int 1")
            "hello" -> println("string hello")
            is Long -> println("is Long")
            !is Double -> println("is not Long")
            else -> println("unknown")
        }
    }

    fun testRanges(i: Int): Boolean {
        println("$i in range 1-100 ${i in 1..100}")
        return i in 1..100
    }

}
