package ghaza.idn.dzikir_app.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ghaza.idn.dzikir_app.R
import ghaza.idn.dzikir_app.adapter.DzikirDoaAdapter
import ghaza.idn.dzikir_app.model.DataDzikirDoa
import ghaza.idn.dzikir_app.model.DzikirDoa

class DzikirPetangActivity : AppCompatActivity() {

    private lateinit var rvDzikirPetang: RecyclerView

    private var listDzikirPetang: ArrayList<DzikirDoa> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setContentView(R.layout.activity_dzikir_petang)

        rvDzikirPetang = findViewById(R.id.rv_dzikir_petang)

        listDzikirPetang.clear()
        listDzikirPetang.addAll(DataDzikirDoa.listDzikirPetang)

        rvDzikirPetang.layoutManager = LinearLayoutManager(this)
        rvDzikirPetang.adapter = DzikirDoaAdapter(listDzikirPetang)
        rvDzikirPetang.setHasFixedSize(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}