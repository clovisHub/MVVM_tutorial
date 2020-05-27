package com.clovis.mvvm_tutorial.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.clovis.mvvm_tutorial.models.Post
import com.clovis.mvvm_tutorial.models.repository.FirstRepository

class FirstViewModel(private val app: Application) : AndroidViewModel(app) {

    private  var mutablePosts : MutableLiveData<List<Post>>

    init {
        FirstRepository.makeRequest(app)
         mutablePosts = MutableLiveData()
    }

    fun fetchPost() : LiveData<List<Post>> {
        mutablePosts.postValue(FirstRepository.getPostList())
        return mutablePosts
    }
}