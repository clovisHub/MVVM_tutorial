package com.clovis.mvvm_tutorial.models.business

import com.google.gson.Gson
import com.google.gson.GsonBuilder

object AppUtils {

    fun getGsonBuilder() : Gson {
        return GsonBuilder().create()
    }
}