package com.tapisdev.dicodingandroidtugas1.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tapisdev.dicodingandroidtugas1.R
import com.tapisdev.dicodingandroidtugas1.model.Article

class ArticleAdapter (private var articles : List<Article>) :
    RecyclerView.Adapter<ArticleAdapter.MovieViewHolder>() {

    class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val llArticle: LinearLayout = view.findViewById(R.id.llArticle)
        val tvTitle: TextView = view.findViewById(R.id.tvTitle)
        val tvDescription: TextView = view.findViewById(R.id.tvDescription)
        val ivArticle : ImageView = view.findViewById(R.id.ivArticle)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_article, parent, false)
        return MovieViewHolder(view)
    }

    override fun getItemCount() = articles.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val article = articles[position]
        holder.tvTitle.text = article.title

        val descriptionWords = article.description.split(" ")
        val shortDescription = descriptionWords.take(8).joinToString(" ")
        holder.tvDescription.text = "$shortDescription ..."
        Glide.with(holder.itemView.context)
            .load(article.image)
            .placeholder(R.drawable.placeholder)
            .into(holder.ivArticle)

        holder.llArticle.setOnClickListener {
            //listener.onHistoryClick(history.episodeId)
        }
    }





}