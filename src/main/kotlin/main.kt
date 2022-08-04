fun main() {
    // kartu domino, ada dua nominal mulai dari (0,0) sampai (6,6)
    // kartu (5,3) itu sama dengan (3,5)

    val cli = CommandLineInterface()
    cli.mulai()
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