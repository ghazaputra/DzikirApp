package ghaza.idn.dzikir_app.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ghaza.idn.dzikir_app.R
import ghaza.idn.dzikir_app.model.DzikirDoa

class DzikirDoaAdapter(private val listDzikirDoa: ArrayList<DzikirDoa>) :
    RecyclerView.Adapter<DzikirDoaAdapter.MyViewHolder>() {

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvDesc = view.findViewById<TextView>(R.id.tv_desc)!!
        val tvBacaan = view.findViewById<TextView>(R.id.tv_lafaz)!!
        val tvTerjemah = view.findViewById<TextView>(R.id.tv_terjemah)!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.row_item_doa, parent, false)
    )

    override fun getItemCount() = listDzikirDoa.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val qauliyah = listDzikirDoa[position]
        holder.tvDesc.text = qauliyah.desc
        holder.tvBacaan.text = qauliyah.lafaz
        holder.tvTerjemah.text = qauliyah.terjemah
    }
}