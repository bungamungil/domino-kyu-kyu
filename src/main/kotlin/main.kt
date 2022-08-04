fun main() {
    // kartu domino, ada dua nominal mulai dari (0,0) sampai (6,6)
    // kartu (5,3) itu sama dengan (3,5)

    val daftarPemain = arrayListOf<Pemain>()
    for (p in 1 .. 3) {
        val pemain = Pemain("Pemain ${p}", TumpukkanKartu(mutableListOf()))
        daftarPemain.add(pemain)
    }

    val game = GameDomino(daftarPemain)
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