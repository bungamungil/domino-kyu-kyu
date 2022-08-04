open class GameDomino(
    val daftarPemain: List<Pemain>
) {

    val tumpukkanKartuBuatNyangkul: TumpukkanKartu
    val tumpukkanKartuYangSudahKebuang: TumpukkanKartu

    init {
        val daftarKartu = generateKartuDomino();
        println("Daftar Kartu")
        daftarKartu.forEach { item ->
            println(item)
        }

        tumpukkanKartuBuatNyangkul = TumpukkanKartu(daftarKartu)
        tumpukkanKartuBuatNyangkul.kocok(tumpukkanKartuBuatNyangkul.getDaftarKartu().size * 2)
        tumpukkanKartuBuatNyangkul.cetakDaftarKartu()

        tumpukkanKartuYangSudahKebuang = TumpukkanKartu(mutableListOf())

        daftarPemain.forEach { pemain ->
            pemain.getTumpukkanKartu().tumpukLangsung(tumpukkanKartuBuatNyangkul.tarik(6))
        }
    }

    fun mulai() {
        val kartuPerdana = tumpukkanKartuBuatNyangkul.tarik(1)
        tumpukkanKartuYangSudahKebuang.tumpukLangsung(kartuPerdana)
        do {
            this.daftarPemain.forEach { pemain ->
                // Cetak daftar kartu yang sudah terbuang
                println("==============\nKartu yang Sudah Terbuang : ")
                tumpukkanKartuYangSudahKebuang.cetakDaftarKartu();

                // Player's Turn
                println("${pemain.getNama()} Jalan : ")
                println(pemain)
                val kartuYangBisaDimainkan = pemain.getDaftarKartuYangBisaDimainkan(tumpukkanKartuYangSudahKebuang)
                kartuYangBisaDimainkan.forEach { kartuBisaDimainkan ->
                    println(kartuBisaDimainkan)
                }
                if (kartuYangBisaDimainkan.isNotEmpty()) {
                    // Todo : Pemain bisa memilih kartu mana yang akan dimainkan .... (Interaksi console)
                    pemain.mainkanKartu(kartuYangBisaDimainkan.first(), tumpukkanKartuYangSudahKebuang)
                } else {
                    if (tumpukkanKartuBuatNyangkul.getDaftarKartu().isNotEmpty()) {
                        val kartuYangDitarik = tumpukkanKartuBuatNyangkul.tarik(1)
                        pemain.getTumpukkanKartu().tumpukLangsung(kartuYangDitarik)
                        println("${pemain.getNama()} menarik kartu dari cangkulan : ${kartuYangDitarik.first()}")
                    } else {
                        return@forEach
                    }
                }
            }
        } while (!apakahGameSudahSelesai())
        val daftarPemenang = this.daftarPemain.sortedBy { pemain -> pemain.score() }
        daftarPemenang.forEach { pemain ->
            println("${pemain.getNama()} : ${pemain.score()}")
        }
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