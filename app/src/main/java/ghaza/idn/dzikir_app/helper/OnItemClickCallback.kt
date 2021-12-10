package ghaza.idn.dzikir_app.helper

import ghaza.idn.dzikir_app.model.Artikel

interface OnItemClickCallback {
    fun onItemClicked(data: Artikel)
}