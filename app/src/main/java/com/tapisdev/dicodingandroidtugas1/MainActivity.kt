package com.tapisdev.dicodingandroidtugas1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.tapisdev.dicodingandroidtugas1.adapter.ArticleAdapter
import com.tapisdev.dicodingandroidtugas1.databinding.ActivityMainBinding
import com.tapisdev.dicodingandroidtugas1.model.Article

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    private lateinit var articleAdapter : ArticleAdapter
    var articleList : List<Article> = emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        populateData()
        setupUI()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.about_page -> {
                //intent here
                val i = Intent(this,AboutActivity::class.java)
                startActivity(i)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun populateData(){
        articleList  = listOf(
            Article(
                title = R.string.article_title_1,
                description = R.string.article_desc_1,
                image = R.drawable.article_image1
            ),
            Article(
                title = R.string.article_title_2,
                description = R.string.article_desc_2,
                image = R.drawable.e_sport
            ),
            Article(
                title = R.string.article_title_3,
                description = R.string.article_desc_3,
                image = R.drawable.nes_classic
            ),
            Article(
                title = R.string.article_title_4,
                description = R.string.article_desc_4,
                image = R.drawable.vr_imersif
            ),
            Article(
                title = R.string.article_title_5,
                description = R.string.article_desc_5,
                image = R.drawable.crt_tv
            ),
            Article(
                title = R.string.article_title_6,
                description = R.string.article_desc_6,
                image = R.drawable.indie_game
            ),
            Article(
                title = R.string.article_title_7,
                description = R.string.article_desc_7,
                image = R.drawable.minecraft
            ),
            Article(
                title = R.string.article_title_8,
                description = R.string.article_desc_8,
                image = R.drawable.ai_npc
            ),
            Article(
                title = R.string.article_title_9,
                description = R.string.article_desc_9,
                image = R.drawable.among_us
            ),
            Article(
                title = R.string.article_title_10,
                description = R.string.article_desc_10,
                image = R.drawable.streamer
            ),
        )

    }

    private fun setupUI(){
        val actionBar = supportActionBar
        actionBar?.title = "List Article"

        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvArticle.layoutManager = layoutManager
        articleAdapter = ArticleAdapter(articleList)
        binding.rvArticle.adapter = articleAdapter
    }
}