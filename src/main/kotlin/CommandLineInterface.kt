import java.util.*

class CommandLineInterface : GameDominoUserInterface {

    private fun generateScanner(): Scanner {
        return Scanner(System.`in`)
    }

    fun mulai() {
        cetakUcapanSelamatDatang()
        val game = GameDomino(this)
        game.mulai()
    }

    fun cetakUcapanSelamatDatang() {
        println("Selamat datang di DOMINO KYU KYU! GAME DOMINO TANPA DUIT~! BUKAN JUDI!! LEGAL DI PSE!!")
    }

    override fun inputJumlahPemain(): Int {
        print("Masukkan jumlah pemain : ")
        return generateScanner().nextInt()
    }

    override fun inputNamaPemain(pemainKe: Int): String {
        print("Masukkan nama pemain ke-$pemainKe : ")
        return generateScanner().nextLine()
    }

}