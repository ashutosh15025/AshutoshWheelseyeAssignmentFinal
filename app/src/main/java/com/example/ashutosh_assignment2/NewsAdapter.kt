package com.example.ashutosh_assignment2

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.ashutosh_assignment2.databinding.RowlayoutBinding

class NewsAdapter():Adapter<NewsAdapter.ViewHolder>() {
    private var articles = ArrayList<Article>()
    fun setNewsList(movieList : List<Article>){
        this.articles= movieList as ArrayList<Article>
        notifyDataSetChanged()
    }
    class ViewHolder(val binding :RowlayoutBinding) : RecyclerView.ViewHolder(binding.root)  {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            RowlayoutBinding.inflate(
                LayoutInflater.from(
                    parent.context
                )
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val article=articles[position];
        holder.binding.Newstitle.text =article.title
        holder.binding.Newsdescription.text=article.description;
        Glide.with(holder.itemView).load(article.urlToImage).into(holder.binding.NewsImage)

    }

    override fun getItemCount(): Int {
        return articles.size;
    }


}