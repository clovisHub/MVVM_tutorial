package com.clovis.mvvm_tutorial.views

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.clovis.mvvm_tutorial.databinding.ContentItemBinding
import com.clovis.mvvm_tutorial.models.Post

class ItemActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ContentItemBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        intent.apply {
            binding.textTitleId.text = getStringExtra("title").toString()
            binding.userNumberId.text = getStringExtra("id").toString()
            binding.numbeId.text = getStringExtra("user").toString()
            binding.contentId.text = getStringExtra("content").toString()
        }
    }

    companion object {
        fun startItemActivity(context: AppCompatActivity, post: Post) {
            context.startActivity(Intent(context, ItemActivity::class.java).apply {
                putExtra("title", post.title.toString())
                putExtra("user", post.userId.toString())
                putExtra("id", post.id.toString())
                putExtra("content", post.body.toString())
            })
        }
    }
}