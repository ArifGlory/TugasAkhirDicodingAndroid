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
                title = "Tips Bermain Game FPS",
                description = "Bermain game FPS memerlukan keahlian dan strategi yang tepat. Untuk meningkatkan skill, penting untuk memahami mekanika permainan, memanfaatkan senjata dengan baik, dan berlatih secara konsisten. Selain itu, komunikasi dengan tim juga sangat krusial untuk meraih kemenangan.",
                image = "https://picsum.photos/200/300?random=1"
            ),
            Article(
                title = "Rekomendasi Game RPG Terbaik",
                description = "Game RPG menawarkan pengalaman petualangan yang mendalam dan alur cerita yang menarik. Dari dunia fantasi hingga sci-fi, banyak game RPG yang menyuguhkan karakter yang dapat disesuaikan dan jalan cerita yang beragam. Cobalah beberapa game terbaik yang telah mendapatkan banyak pengakuan di kalangan gamer.",
                image = "https://picsum.photos/200/300?random=2"
            ),
            Article(
                title = "Panduan Bermain Game MOBA",
                description = "Game MOBA seperti Mobile Legends dan Dota 2 mengharuskan pemain untuk bekerja sama dengan tim dan menggunakan strategi yang efektif. Penting untuk memahami peran masing-masing hero dan beradaptasi dengan situasi di lapangan. Dengan latihan dan strategi yang tepat, Anda dapat meningkatkan tingkat kemenangan tim.",
                image = "https://picsum.photos/200/300?random=3"
            ),
            Article(
                title = "Cara Setting Grafik Game untuk Performa Terbaik",
                description = "Pengaturan grafik yang tepat dapat memengaruhi performa permainan secara signifikan. Dengan mengatur kualitas grafik, resolusi, dan detail, Anda dapat mendapatkan keseimbangan antara visual yang baik dan kelancaran permainan. Cobalah berbagai pengaturan untuk menemukan yang paling cocok dengan perangkat Anda.",
                image = "https://picsum.photos/200/300?random=4"
            ),
            Article(
                title = "Peralatan Gaming yang Wajib Dimiliki",
                description = "Dalam dunia gaming, peralatan yang baik dapat meningkatkan pengalaman bermain. Mulai dari headset berkualitas tinggi, mouse yang responsif, hingga keyboard mekanik, setiap komponen memainkan peran penting. Investasi pada peralatan gaming yang tepat dapat membuat perbedaan besar dalam kenyamanan dan performa Anda.",
                image = "https://picsum.photos/200/300?random=5"
            ),
            Article(
                title = "Review Game Terbaru 2024",
                description = "Tahun 2024 membawa banyak game baru yang menarik untuk dimainkan. Dari game aksi yang mendebarkan hingga game strategi yang menantang, setiap gamer pasti akan menemukan sesuatu yang sesuai dengan selera mereka. Mari kita bahas beberapa game terbaru yang wajib dicoba dan alasan mengapa mereka begitu menarik.",
                image = "https://picsum.photos/200/300?random=6"
            ),
            Article(
                title = "Mengatasi Lag saat Bermain Game Online",
                description = "Lag adalah masalah umum yang sering dialami saat bermain game online. Beberapa faktor seperti kecepatan internet yang rendah dan latensi tinggi dapat memengaruhi pengalaman bermain. Dengan mengikuti tips mengurangi lag dan meningkatkan koneksi internet, Anda bisa mendapatkan pengalaman bermain yang lebih lancar dan menyenangkan.",
                image = "https://picsum.photos/200/300?random=7"
            ),
            Article(
                title = "Game Battle Royale Terpopuler",
                description = "Genre battle royale telah menjadi sangat populer di kalangan gamer. Game seperti PUBG, Fortnite, dan Apex Legends menawarkan pengalaman bermain yang seru dan kompetitif. Dalam game ini, pemain harus bertahan hidup di medan perang yang semakin menyusut, membuat strategi dan kerja sama tim menjadi sangat penting.",
                image = "https://picsum.photos/200/300?random=8"
            ),
            Article(
                title = "Pengaruh Esports Terhadap Industri Game",
                description = "Esports telah berkembang pesat dan menjadi bagian penting dari industri game. Dengan banyaknya turnamen dan liga profesional, banyak gamer yang kini menjadikan bermain game sebagai karir. Mari kita lihat bagaimana esports mempengaruhi pengembangan game dan popularitas di kalangan masyarakat.",
                image = "https://picsum.photos/200/300?random=9"
            ),
            Article(
                title = "Cara Meningkatkan Keterampilan Bermain Game Strategi",
                description = "Game strategi menguji kemampuan berpikir kritis dan pengambilan keputusan. Untuk menjadi ahli dalam genre ini, Anda perlu mempelajari berbagai teknik dan taktik. Dengan berlatih dan memahami berbagai aspek permainan, Anda bisa meningkatkan keterampilan dan meraih kemenangan lebih sering.",
                image = "https://picsum.photos/200/300?random=10"
            )
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