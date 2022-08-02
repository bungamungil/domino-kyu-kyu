fun main() {
    // kartu domino, ada dua nominal mulai dari (0,0) sampai (6,6)
    // kartu (5,3) itu sama dengan (3,5)
    val daftarKartu = generateKartuDomino();
    println("Daftar Kartu")
    daftarKartu.forEach { item ->
        println(item)
    }

    val tumpukkanKartu = TumpukkanKartu(daftarKartu)
    tumpukkanKartu.kocok(tumpukkanKartu.getDaftarKartu().size * 2)
    tumpukkanKartu.cetakDaftarKartu()

    val daftarPemain = arrayListOf<Pemain>()
    for (p in 1 .. 3) {
        val kartuPemain = tumpukkanKartu.tarik(6)
        val pemain = Pemain("Pemain ${p}", TumpukkanKartu(kartuPemain.toMutableList()))
        daftarPemain.add(pemain)
    }

    daftarPemain.forEach { pemain ->
        println(pemain)
    }

    val game = GameDomino(daftarPemain, tumpukkanKartu, TumpukkanKartu(mutableListOf()))
    game.mulai()
}

fun generateKartuDomino(): MutableList<KartuDomino> {
    val daftarKartu = arrayListOf<KartuDomino>()
    for (i in 0 .. 6) {
        for (ii in i .. 6) {
            daftarKartu.add(KartuDomino(i, ii))
        }
    }
    return daftarKartu
}