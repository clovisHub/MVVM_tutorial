package com.clovis.mvvm_tutorial.models.network

import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.clovis.mvvm_tutorial.models.repository.FirstRepository
import com.clovis.mvvm_tutorial.models.storage.AppSharedPref
import java.nio.charset.Charset

object MyVolley {

    /**
     * This method makes a network call using Volley library with a GET method.
     */
    fun makeRequest(context: Context, listener: NetworkListener) {

        val queue = Volley.newRequestQueue(context)

        val stringRequest = StringRequest(
            Request.Method.GET,
            "https://jsonplaceholder.typicode.com/posts",
            Response.Listener<String> { response ->
                // the line below send this response to the repository
                AppSharedPref.getInstance(context)
                AppSharedPref.storePostList(response)
                listener.getResponseString(response)
            },
            Response.ErrorListener {
                Log.e("error", it.message)
            })

//        stringRequest.setShouldCache(false)
//        var cache = String(stringRequest.cacheEntry.data, Charset.forName("UTF-8"))
//
//        //The Request URL is stored in the cache key ...
//        //val url = queue.getCacheKey()
//        val url = "https://jsonplaceholder.typicode.com/posts"
//
//        var cacheValues = String(stringRequest.cacheEntry.data, Charset.forName("UTF-8"))
//
//        //Accessing from the RequestQueue
//        var cacheValue = String(queue.cache.get(url).data, Charset.forName("UTF-8"))
//
//       //Check other details in the cache.
//        var expired = stringRequest.cacheEntry.isExpired
//        //checks if the cache is expired or not.
//        var last = stringRequest.cacheEntry.lastModified

        // Add the request to the RequestQueue.
        queue.add(stringRequest)
    }
}

interface NetworkListener {
    fun getResponseString(response: String)
}