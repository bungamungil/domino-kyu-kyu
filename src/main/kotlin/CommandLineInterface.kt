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

    override fun cetakDaftarKartuTerbuang(daftarKartu: List<KartuDomino>) {
        println("==============\nKartu yang Sudah Terbuang : ")
        daftarKartu.forEach { kartuDomino ->
            println(kartuDomino)
        }
    }

    override fun cetakGiliranPemain(pemain: Pemain) {
        println("Giliran ${pemain.getNama()}")
        println(pemain)
    }

    override fun cetakKartuYangBisaDimainkanPemain(pemain: Pemain, kartuYangBisaDimainkan: List<KartuBisaDimainkan>) {
        kartuYangBisaDimainkan.forEach { kartu ->
            println(kartu)
        }
    }

    override fun cetakKartuYangDicangkulPemain(pemain: Pemain, kartuYangDitarik: List<KartuDomino>) {
        println("${pemain.getNama()} menarik kartu dari cangkulan : ${kartuYangDitarik.first()}")
    }

    override fun tampilkanDaftarPemenang(daftarPemenang: List<Pemain>) {
        daftarPemenang.forEach { pemain ->
            println("${pemain.getNama()} : ${pemain.score()}")
        }
    }

    override fun cetakDaftarKartuBuatNyangkul(daftarKartu: List<KartuDomino>) {
        println("Jumlah kartu yang masih tersedia untuk dicangkul : ${daftarKartu.size}")
    }

}