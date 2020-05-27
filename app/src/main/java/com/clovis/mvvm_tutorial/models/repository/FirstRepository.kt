package com.clovis.mvvm_tutorial.models.repository

import android.app.Application
import com.clovis.mvvm_tutorial.models.Post
import com.clovis.mvvm_tutorial.models.network.MyVolley
import com.clovis.mvvm_tutorial.models.network.NetworkListener
import com.clovis.mvvm_tutorial.models.storage.AppSharedPref
import com.google.gson.Gson

object FirstRepository : NetworkListener {

    private val mutablelist : MutableList<Post>  =  mutableListOf()

    /**
     * This method makes a will initiate a network call if the storage is empty.
     */
    fun makeRequest(context: Application) {

        AppSharedPref.getInstance(context)

        if(AppSharedPref.getPostList().isEmpty())  {
            // if there are not values saved the preference is empty
            // then the network call ahs to be made.
            MyVolley.makeRequest(context, this)

        } else {
            //otherwise just return to the presenter the values saved from shared preference file.
            fetchData(AppSharedPref.getPostList())
        }
    }

    /**
     * This method convert the response string to a list of Posts.
     */
    private fun fetchData(values: String) {
         var currentList : Array<Post> ? = null
        //convert response to Array of Posts and make sure nothing wrong will happen.
         try {
             currentList = Gson().fromJson(values, Array<Post>::class.java)

         } catch (exception: Exception) {

         }
        // clear the previous value of the list if there is any.
        mutablelist.clear()

        // if currentList is not null then pass its content as value to the 'mutablelist of Posts'
        currentList?.let {
            mutablelist.addAll(currentList)
        }
    }

    fun getPostList(): List<Post> = mutablelist

    override fun getResponseString(response: String) {
        fetchData(response)
    }
}