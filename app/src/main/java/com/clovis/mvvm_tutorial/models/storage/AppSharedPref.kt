package com.clovis.mvvm_tutorial.models.storage

import android.content.Context
import android.content.SharedPreferences

object AppSharedPref {

    private var pref : SharedPreferences? = null

    private const val postKey = "posts"

    /**
     * This method initializes the preference file,
     * so that values can start being saved and retrieve later on.
     */
    fun getInstance(context:Context) {

        pref = context.applicationContext.getSharedPreferences("MyPref", 0)
    }

    /**
     * This method below saves the json as a String in preferences  with 'postKey'.
     */
    fun storePostList(posts : String) {

        pref?.edit()?.putString(postKey, posts)?.apply()
    }

    /**
     * This method returns a the posts saved in preferences,
     * otherwise it returns an empty string if nothing was previously saved.
     */
    fun getPostList() : String  {

       return  pref?.getString(postKey, "")?:""
    }
}