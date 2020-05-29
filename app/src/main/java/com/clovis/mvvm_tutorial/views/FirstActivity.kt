package com.clovis.mvvm_tutorial.views

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.clovis.mvvm_tutorial.databinding.ActivityFirstBinding
import com.clovis.mvvm_tutorial.models.Post
import com.clovis.mvvm_tutorial.viewmodels.FirstViewModel
import com.clovis.mvvm_tutorial.views.ItemActivity.Companion.startItemActivity

class FirstActivity : AppCompatActivity(), PostsAdapter.ListenerClick{

    private val postListAdapter :PostsAdapter by lazy { PostsAdapter(this) }
    private val viewModel: FirstViewModel by lazy { FirstViewModel(application) }
    private var flag = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityFirstBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        val layoutManagers = LinearLayoutManager(this)

        binding?.recyclerId?.apply {
            layoutManager = layoutManagers
            adapter = postListAdapter
            setHasFixedSize(true)
        }

        viewModel.fetchPost().observe(this, Observer { list ->
            list?.let {
                if(!flag) {
                    flag = true
                    postListAdapter.setPostList(list)
                }
            }
        })

    }

    companion object {
        fun startFirstActivity(context: AppCompatActivity) {
            context.startActivity(Intent(context, FirstActivity::class.java))
        }
    }

    override fun onCick(post: Post) {
        startItemActivity(this, post)
    }
}