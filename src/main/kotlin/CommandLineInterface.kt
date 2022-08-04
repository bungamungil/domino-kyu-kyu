import java.util.*

class CommandLineInterface {

    private fun generateScanner(): Scanner {
        return Scanner(System.`in`)
    }

    fun mulai() {
        cetakUcapanSelamatDatang()
        val jumlahPemain = jumlahPemain()
        val daftarPemain = arrayListOf<Pemain>()
        for (i in 1 .. jumlahPemain) {
            daftarPemain.add(Pemain(
                tanyaNamaPemain(i),
                TumpukkanKartu(mutableListOf())
            ))
        }
        val game = GameDomino(daftarPemain)
        game.mulai()
    }

    fun cetakUcapanSelamatDatang() {
        println("Selamat datang di DOMINO KYU KYU! GAME DOMINO TANPA DUIT~! BUKAN JUDI!! LEGAL DI PSE!!")
    }

    fun jumlahPemain(): Int {
        print("Masukkan jumlah pemain : ")
        return generateScanner().nextInt()
    }

    fun tanyaNamaPemain(pemainKe: Int): String {
        print("Masukkan nama pemain ke-$pemainKe : ")
        return generateScanner().nextLine()
    }

}