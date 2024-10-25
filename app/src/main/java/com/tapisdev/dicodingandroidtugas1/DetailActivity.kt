package com.tapisdev.dicodingandroidtugas1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.tapisdev.dicodingandroidtugas1.databinding.ActivityDetailBinding
import com.tapisdev.dicodingandroidtugas1.model.Article

class DetailActivity : AppCompatActivity() {
    lateinit var binding : ActivityDetailBinding
    lateinit var article: Article

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        article = intent.getParcelableExtra("article")!!


        setupUI()
    }

    private fun setupUI(){
        val actionBar = supportActionBar
        actionBar?.title = "Detail Article"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.tvTitle.text = getString(article.title)
        binding.tvDescription.text = getString(article.description)
        binding.ivBackdrop.setImageResource(article.image)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
               onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}