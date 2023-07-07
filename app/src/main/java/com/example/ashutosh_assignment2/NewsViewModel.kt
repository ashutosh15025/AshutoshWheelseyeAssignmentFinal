package com.example.ashutosh_assignment2

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

open class NewsViewModel : ViewModel() {
    private var NewsLiveData = MutableLiveData<List<Article>>()


    fun getNews() {
        val news: Call<News> = NewsService.newsInstance.getHeadlines("in",1)
        news.enqueue(object: Callback<News> {
            override fun onResponse(call: Call<News>, response: Response<News>) {

                Log.d("get function", "onResponse: No Error ")
                if(response.body()!=null){
                   NewsLiveData.value=response.body()!!.articles;
                    Log.d("Done", "onResponse: No Error ")
                }
            }

            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.d("Done", "onResponse:  Error fetching"+t.message.toString())
            }
        })
    }
    fun observeMovieLiveData() : LiveData<List<Article>> {
        return NewsLiveData;
    }
}