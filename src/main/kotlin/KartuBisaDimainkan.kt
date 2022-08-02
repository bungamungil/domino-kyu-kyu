data class KartuBisaDimainkan(
    val perluDiputar: Boolean,
    val indexKartu: Int,
    val kartuDomino: KartuDomino,
    val lokasiLangkahKartu: LokasiLangkahKartu,
    ) {

    override fun toString(): String {
        var keteranganPutar = ""
        if (perluDiputar) {
            keteranganPutar = "Perlu diputar"
        } else {
            keteranganPutar = "Tidak perlu diputar"
        }
        var keteranganLokasi = ""
        when (lokasiLangkahKartu) {
            LokasiLangkahKartu.DiDepan -> keteranganLokasi = "di depan"
            LokasiLangkahKartu.DiBelakang -> keteranganLokasi = "di belakang"
        }
        return "Kartu ke-${indexKartu} : $kartuDomino $keteranganLokasi, $keteranganPutar"
    }

}