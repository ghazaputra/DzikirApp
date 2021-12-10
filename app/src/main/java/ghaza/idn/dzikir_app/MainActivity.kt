package ghaza.idn.dzikir_app

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import ghaza.idn.dzikir_app.adapter.ArtikelAdapter
import ghaza.idn.dzikir_app.helper.OnItemClickCallback
import ghaza.idn.dzikir_app.model.Artikel
import ghaza.idn.dzikir_app.ui.HarianDzikirDoaActivity
import ghaza.idn.dzikir_app.ui.PagiPetangDzikirActivity
import ghaza.idn.dzikir_app.ui.QauliyahShalatActivity
import ghaza.idn.dzikir_app.ui.SetiapSaatDzikirActivity
import ghaza.idn.dzikir_app.ui.detail.DetailArtikelActivity

class   MainActivity : AppCompatActivity() {

    private lateinit var llDzikirDoaShalat: LinearLayout
    private lateinit var llDzikirDoaHarian: LinearLayout
    private lateinit var llDzikirSetiapSaat: LinearLayout
    private lateinit var llDzikirPagiPetang: LinearLayout
    private lateinit var llDotsSlider: LinearLayout

    private lateinit  var vpArtikel: ViewPager2

    private var artikelArray: ArrayList<Artikel> = arrayListOf()

    private lateinit var dotsSlider: Array<ImageView?>
    private var dotsCount = 0

    private val slidingCallback = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            for (dot in 0 until dotsCount) {
                dotsSlider[dot]?.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext, R.drawable.non_active_dot
                    )
                )
            }

            dotsSlider[position]?.setImageDrawable(
                ContextCompat.getDrawable(
                    applicationContext, R.drawable.active_dot
                )
            )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initData()
        initView()
        setUpViewPager()
    }

    private fun initView() {
        llDzikirDoaShalat = findViewById(R.id.ll_dzikir_doa_shalat)
        llDzikirDoaShalat.setOnClickListener {
            startActivity(Intent(this, QauliyahShalatActivity::class.java))
        }

        llDzikirDoaHarian = findViewById(R.id.ll_dzikir_doa_harian)
        llDzikirDoaHarian.setOnClickListener {
            startActivity(Intent(this, HarianDzikirDoaActivity::class.java))
        }

        llDzikirSetiapSaat = findViewById(R.id.ll_dzikir_setiap_saat)
        llDzikirSetiapSaat.setOnClickListener {
            startActivity(Intent(this, SetiapSaatDzikirActivity::class.java))
        }

        llDzikirPagiPetang = findViewById(R.id.ll_dzikir_pagi_petang)
        llDzikirPagiPetang.setOnClickListener {
            startActivity(Intent(this, PagiPetangDzikirActivity::class.java))
        }

        llDotsSlider = findViewById(R.id.ll_slider_dots)
        vpArtikel = findViewById(R.id.vp_artikel)
    }

    private fun initData() {
        // bagian artikel
        val image = resources.obtainTypedArray(R.array.img_artikel)
        val title = resources.getStringArray(R.array.title_artikel)
        val desc = resources.getStringArray(R.array.desc_artikel)

        artikelArray.clear()
        for (data in title.indices) {
            artikelArray.add(
                Artikel(
                    image.getResourceId(data, 0),
                    title[data],
                    desc[data]
                )
            )
        }
        image.recycle()
    }

    private fun setUpViewPager() {
        val artikelAdapter = ArtikelAdapter(artikelArray)
        artikelAdapter.setOnItemClickCallback(object : OnItemClickCallback {
            override fun onItemClicked(data: Artikel) {
                val intent = Intent(applicationContext, DetailArtikelActivity::class.java)

//                intent.putExtra("title", data.titleArtikel)
//                intent.putExtra("desc", data.descArtikel)
//                intent.putExtra("image", data.imageArtikel)

                intent.putExtra("data", data)
                startActivity(intent)
            }
        })

        vpArtikel.apply {
            adapter = artikelAdapter
            registerOnPageChangeCallback(slidingCallback)
        }

        dotsCount = artikelArray.size
        dotsSlider = arrayOfNulls(dotsCount)

        for (i in 0 until dotsCount) {
            dotsSlider[i] = ImageView(this)
            dotsSlider[i]?.setImageDrawable(
                ContextCompat.getDrawable(
                    applicationContext, R.drawable.non_active_dot
                )
            )
            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            params.setMargins(8, 0, 8, 0)
            llDotsSlider.addView(dotsSlider[i], params)
        }

        dotsSlider[0]?.setImageDrawable(
            ContextCompat.getDrawable(
                applicationContext, R.drawable.active_dot
            )
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        vpArtikel.unregisterOnPageChangeCallback(slidingCallback)
    }
}