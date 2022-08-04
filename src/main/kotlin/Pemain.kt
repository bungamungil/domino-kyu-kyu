class Pemain(
    private val nama: String,
    private val tumpukkanKartu: TumpukkanKartu
) {
    fun getNama() : String {
        return nama
    }

    fun getTumpukkanKartu(): TumpukkanKartu {
        return tumpukkanKartu
    }

    fun getDaftarKartu(): MutableList<KartuDomino> {
        return tumpukkanKartu.getDaftarKartu()
    }

    fun getDaftarKartuYangBisaDimainkan(tumpukkanKartuYangDimainkan: TumpukkanKartu): List<KartuBisaDimainkan> {
        val kartuYangBisaDimainkan = arrayListOf<KartuBisaDimainkan>()
        tumpukkanKartu.getDaftarKartu().forEachIndexed { index, kartuDominoPemain ->
            val kartuBisaDimainkan = tumpukkanKartuYangDimainkan.bisaDimainkan(kartuDominoPemain, index)
            kartuYangBisaDimainkan.addAll(kartuBisaDimainkan)
        }
        return kartuYangBisaDimainkan
    }

    fun mainkanKartu(kartuBisaDimainkan: KartuBisaDimainkan, tumpukkanKartuYangDimainkan: TumpukkanKartu) {
        if (kartuBisaDimainkan.perluDiputar) {
            kartuBisaDimainkan.kartuDomino.tukarPosisi()
        }
        when(kartuBisaDimainkan.lokasiLangkahKartu) {
            LokasiLangkahKartu.DiDepan ->
                tumpukkanKartuYangDimainkan.tumpukDiDepan(kartuBisaDimainkan.kartuDomino)
            LokasiLangkahKartu.DiBelakang ->
                tumpukkanKartuYangDimainkan.tumpukDiBelakang(kartuBisaDimainkan.kartuDomino)
        }
        buangKartu(kartuBisaDimainkan.indexKartu)
    }

    fun buangKartu(index: Int): KartuDomino {
        return tumpukkanKartu.getDaftarKartu().removeAt(index)
    }

    override fun toString(): String {
        return "Nama Pemain : ${nama}\n" +
                "Kartu ${tumpukkanKartu.getDaftarKartu().map { it.toString() }}"
    }

    fun score(): Int {
        if (tumpukkanKartu.getDaftarKartu().isEmpty()) return 0
        var score = 0;
        tumpukkanKartu.getDaftarKartu().forEach { kartuDomino ->
            score += kartuDomino.getNominal1() + kartuDomino.getNominal2()
        }
        return score
    }
}