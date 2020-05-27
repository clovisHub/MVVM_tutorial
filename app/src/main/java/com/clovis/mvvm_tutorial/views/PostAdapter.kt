package com.clovis.mvvm_tutorial.views

import com.clovis.mvvm_tutorial.models.Post
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.clovis.mvvm_tutorial.R
import com.clovis.mvvm_tutorial.databinding.PostItemBinding


class PostsAdapter : RecyclerView.Adapter<PostsAdapter.PostHolder>() {

    private var postsList:List<Post> = mutableListOf()

    fun setPostList(posts: List<Post>) {
        postsList = posts
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): PostHolder {
        val view  = DataBindingUtil
            .inflate<PostItemBinding>(LayoutInflater.from(parent.context),
                R.layout.post_item, parent, false)

        return PostHolder(view)
    }

    override fun onBindViewHolder(postHolder: PostHolder, position: Int) {
        postHolder.view.post = postsList[position]
    }

    override fun getItemCount(): Int {
        return postsList.size
    }

    class PostHolder(val view: PostItemBinding) : RecyclerView.ViewHolder(view.root)
}