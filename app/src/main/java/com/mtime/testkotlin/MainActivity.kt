package com.mtime.testkotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var a = 1
    var s = "hello"
    val MAX = 1024

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        btn.setOnClickLis

        println(sum(1, 1))

        println(max(1, 2))

        printInt(110)
    }

    fun max(a: Int, b: Int): Int {
        if (a > b)
            return a
        else
            return b
    }

    fun sum(a: Int, b: Int) = a + b

    fun printInt(i: Int): Unit {
        println("i=$i")
    }

    fun printIntArray(arr: IntArray) {
        for (i in arr)
            println("element:$i")
    }
}
