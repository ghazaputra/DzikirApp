package ghaza.idn.dzikir_app.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ghaza.idn.dzikir_app.R
import ghaza.idn.dzikir_app.adapter.DzikirDoaAdapter
import ghaza.idn.dzikir_app.model.DataDzikirDoa
import ghaza.idn.dzikir_app.model.DzikirDoa

class QauliyahShalatActivity : AppCompatActivity() {

    private lateinit var rvQauliyah: RecyclerView
    private var listQauliyah: ArrayList<DzikirDoa> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setContentView(R.layout.activity_qauliyah_shalat)
        rvQauliyah = findViewById(R.id.rv_qauliyah_shalat)

        listQauliyah.clear()
        listQauliyah.addAll(DataDzikirDoa.listQauliyah)

        rvQauliyah.layoutManager = LinearLayoutManager(this)
        rvQauliyah.adapter = DzikirDoaAdapter(listQauliyah)
        rvQauliyah.setHasFixedSize(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }
}