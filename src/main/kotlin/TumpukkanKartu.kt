import kotlin.random.Random

class TumpukkanKartu(
    private var daftarKartu: MutableList<KartuDomino>
) {

    fun kocok(berapaKaliKocok: Int) {
        for (i in 0 .. berapaKaliKocok) {
            val random1 = Random.nextInt(daftarKartu.size)
            val random2 = Random.nextInt(daftarKartu.size)
            val temp = daftarKartu[random1]
            daftarKartu[random1] = daftarKartu[random2]
            daftarKartu[random2] = temp
        }
    }

    fun getDaftarKartu() : MutableList<KartuDomino> {
        return daftarKartu
    }

    fun tarik(jumlahKartu: Int): List<KartuDomino> {
        val kartuYangDitarik = daftarKartu.take(jumlahKartu)
        this.daftarKartu = daftarKartu.drop(jumlahKartu).toMutableList()
        return kartuYangDitarik
    }

    fun tumpukDiBelakang(kartu: KartuDomino) {
        this.daftarKartu.add(kartu)
    }

    fun tumpukDiDepan(kartu: KartuDomino) {
        this.daftarKartu.add(0, kartu)
    }

    fun bisaDimainkan(melawan: KartuDomino, index: Int): List<KartuBisaDimainkan> {
        val kartuDiDepan = this.daftarKartu.first()
        val kartuDiBelakang = this.daftarKartu.last()
        val daftarKartuBisaDimainkan = arrayListOf<KartuBisaDimainkan>()
        if (kartuDiDepan.getNominal1() == melawan.getNominal1() ||
                kartuDiDepan.getNominal1() == melawan.getNominal2()) {
            val lokasi = LokasiLangkahKartu.DiDepan
            val perluDiputar = kartuDiDepan.getNominal1() == melawan.getNominal1()
            daftarKartuBisaDimainkan.add(KartuBisaDimainkan(
                perluDiputar, index, melawan, lokasi
            ))
        }
        if (kartuDiBelakang.getNominal2() == melawan.getNominal1() ||
            kartuDiBelakang.getNominal2() == melawan.getNominal2()) {
            val lokasi = LokasiLangkahKartu.DiBelakang
            val perluDiputar = kartuDiBelakang.getNominal2() == melawan.getNominal2()
            daftarKartuBisaDimainkan.add(KartuBisaDimainkan(
                perluDiputar, index, melawan, lokasi
            ))
        }
        return daftarKartuBisaDimainkan
    }

    fun tumpukLangsung(daftarKartuTambahan: List<KartuDomino>) {
        this.daftarKartu.addAll(daftarKartuTambahan)
    }

}