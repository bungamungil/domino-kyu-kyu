open class GameDomino(
    val userInterface: GameDominoUserInterface
) {

    val tumpukkanKartuBuatNyangkul: TumpukkanKartu
    val tumpukkanKartuYangSudahKebuang: TumpukkanKartu
    val daftarPemain: List<Pemain>

    init {
        val daftarKartu = generateKartuDomino();

        tumpukkanKartuBuatNyangkul = TumpukkanKartu(daftarKartu)
        tumpukkanKartuBuatNyangkul.kocok(tumpukkanKartuBuatNyangkul.getDaftarKartu().size * 2)

        tumpukkanKartuYangSudahKebuang = TumpukkanKartu(mutableListOf())

        val jumlahPemain = userInterface.inputJumlahPemain()
        daftarPemain = arrayListOf()
        for (i in 1 .. jumlahPemain) {
            daftarPemain.add(Pemain(
                userInterface.inputNamaPemain(i),
                TumpukkanKartu(mutableListOf())
            ))
        }
        daftarPemain.forEach { pemain ->
            pemain.getTumpukkanKartu().tumpukLangsung(tumpukkanKartuBuatNyangkul.tarik(6))
        }
    }

    fun mulai() {
        val kartuPerdana = tumpukkanKartuBuatNyangkul.tarik(1)
        tumpukkanKartuYangSudahKebuang.tumpukLangsung(kartuPerdana)
        do {
            this.daftarPemain.forEach { pemain ->
                userInterface.cetakDaftarKartuTerbuang(tumpukkanKartuYangSudahKebuang.getDaftarKartu())
                userInterface.cetakDaftarKartuBuatNyangkul(tumpukkanKartuBuatNyangkul.getDaftarKartu())

                // Player's Turn
                userInterface.cetakGiliranPemain(pemain)

                val kartuYangBisaDimainkan = pemain.getDaftarKartuYangBisaDimainkan(tumpukkanKartuYangSudahKebuang)

                if (kartuYangBisaDimainkan.isNotEmpty()) {
                    // Todo : input user memilih kartu yang akan dimainkan
                    pemain.mainkanKartu(userInterface.tanyaKartuYangAkanDimainkan(pemain, kartuYangBisaDimainkan), tumpukkanKartuYangSudahKebuang)
                } else {
                    if (tumpukkanKartuBuatNyangkul.getDaftarKartu().isNotEmpty()) {
                        val kartuYangDitarik = tumpukkanKartuBuatNyangkul.tarik(1)
                        pemain.getTumpukkanKartu().tumpukLangsung(kartuYangDitarik)
                        userInterface.cetakKartuYangDicangkulPemain(pemain, kartuYangDitarik)
                    } else {
                        return@forEach
                    }
                }
            }
        } while (!apakahGameSudahSelesai())
        val daftarPemenang = this.daftarPemain.sortedBy { pemain -> pemain.score() }
        userInterface.tampilkanDaftarPemenang(daftarPemenang)
    }

    fun apakahGameSudahSelesai(): Boolean {
        this.daftarPemain.forEach { pemain ->
            if (pemain.getTumpukkanKartu().getDaftarKartu().isEmpty()) {
                return true
            }
        }
        return tumpukkanKartuBuatNyangkul.getDaftarKartu().isEmpty()
    }

}