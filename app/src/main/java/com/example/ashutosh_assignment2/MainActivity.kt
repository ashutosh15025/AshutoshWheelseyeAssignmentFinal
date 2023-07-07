package com.example.ashutosh_assignment2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ashutosh_assignment2.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var viewModel: NewsViewModel
    private lateinit var newsAdapter : NewsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater);
       setContentView(binding.root)
        prepareRecyclerView()
        viewModel = ViewModelProvider(this)[NewsViewModel::class.java]
        viewModel.getNews()
        viewModel.observeMovieLiveData().observe(this, Observer { NewsList ->
            Log.d("size", "onCreate: "+NewsList.size.toString())
            newsAdapter.setNewsList(NewsList)
        })
    }

     private fun prepareRecyclerView() {
        newsAdapter = NewsAdapter()
         Log.d("binding", "onCreate: "+binding.toString()+"/"+newsAdapter)
        binding.NewsList.apply {
            layoutManager =LinearLayoutManager(this@MainActivity)
            adapter = newsAdapter
        }
    }
}