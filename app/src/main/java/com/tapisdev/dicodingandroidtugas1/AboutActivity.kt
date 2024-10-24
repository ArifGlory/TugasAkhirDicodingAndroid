package com.tapisdev.dicodingandroidtugas1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.tapisdev.dicodingandroidtugas1.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {
    lateinit var binding : ActivityAboutBinding
    val imageUrl = "https://avatars.githubusercontent.com/u/18402415?v=4"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val actionBar = supportActionBar
        actionBar?.title = "About Page"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.tvName.text = "Arif Rahman Edison"
        binding.tvEmail.text = "arifglory46@gmail.com"
        Glide.with(this)
            .load(imageUrl)
            .circleCrop()
            .into(findViewById(R.id.ivAbout))
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