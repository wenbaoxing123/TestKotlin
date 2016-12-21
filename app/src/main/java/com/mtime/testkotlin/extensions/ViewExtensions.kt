package com.mtime.testkotlin.extensions

import android.content.Context
import android.view.View

/**
 * Created by wenbaoxing on 16/12/20.
 */
val View.ctx: Context
    get() = context