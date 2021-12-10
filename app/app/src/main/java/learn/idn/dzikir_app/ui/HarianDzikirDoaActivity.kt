package learn.idn.dzikir_app.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import learn.idn.dzikir_app.R
import learn.idn.dzikir_app.adapter.DzikirDoaAdapter
import learn.idn.dzikir_app.model.DzikirDoa

class HarianDzikirDoaActivity : AppCompatActivity() {
    private lateinit var rvDzikirDoaHarian: RecyclerView

    private var dzikirDoaHarianArray: ArrayList<DzikirDoa> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setContentView(R.layout.activity_harian_dzikir_doa)
        rvDzikirDoaHarian = findViewById(R.id.rv_dzikir_doa_harian)

        initData()

        rvDzikirDoaHarian.layoutManager = LinearLayoutManager(this)
        rvDzikirDoaHarian.adapter = DzikirDoaAdapter(dzikirDoaHarianArray)
        rvDzikirDoaHarian.setHasFixedSize(true)
    }

    fun initData() {
        // bagian dzikir & doa harian
        val desc = resources.getStringArray(R.array.dzikir_doa_harian)
        val lafaz = resources.getStringArray(R.array.lafaz_dzikir_doa_harian)
        val terjemah = resources.getStringArray(R.array.terjemah_dzikir_doa_harian)

        dzikirDoaHarianArray.clear()
        for (data in desc.indices) {
            dzikirDoaHarianArray.add(
                DzikirDoa(
                    desc[data],
                    lafaz[data],
                    terjemah[data]
                )
            )
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }
}