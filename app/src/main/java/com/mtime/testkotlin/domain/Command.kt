package com.mtime.testkotlin.domain

/**
 * Created by wenbaoxing on 16/12/19.
 */
public  interface Command<T> {
    fun execute():T
}