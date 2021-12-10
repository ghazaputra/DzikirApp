package learn.idn.dzikir_app.helper

import learn.idn.dzikir_app.model.Artikel

interface OnItemClickCallback {
    fun onItemClicked(data: Artikel)
}