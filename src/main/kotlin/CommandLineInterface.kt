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
        clearConsole()
        println("\nGiliran ${pemain.getNama()}")
        println(pemain)
    }

    override fun tanyaKartuYangAkanDimainkan(pemain: Pemain, kartuYangBisaDimainkan: List<KartuBisaDimainkan>): KartuBisaDimainkan {
        for (i in 1 .. kartuYangBisaDimainkan.size) {
            println("$i. ${kartuYangBisaDimainkan[i-1]}")
        }
        print("Pilih kartu yang mau ${pemain.getNama()} mainkan : ")
        val kartuYangDipilih = generateScanner().nextInt()
        if (kartuYangDipilih < 1 || kartuYangDipilih > kartuYangBisaDimainkan.size) {
            return tanyaKartuYangAkanDimainkan(pemain, kartuYangBisaDimainkan)
        }
        return kartuYangBisaDimainkan[kartuYangDipilih-1]
    }

    override fun konfirmasiKartuYangDicangkulPemain(pemain: Pemain, kartuYangDitarik: List<KartuDomino>) {
        println("${pemain.getNama()} menarik kartu dari cangkulan : ${kartuYangDitarik.first()}")
        print("Lanjutkan? ")
        generateScanner().nextLine()
    }

    override fun tampilkanDaftarPemenang(daftarPemenang: List<Pemain>) {
        println("======================================")
        println("PERMAINAN BERAKHIR ! ! ! SELAMAT KEPADA PEMENANG :")
        println(daftarPemenang.first().getNama())
        println("======================================")
        daftarPemenang.forEach { pemain ->
            println("${pemain.getNama()} : ${pemain.score()}")
        }
    }

    override fun cetakDaftarKartuBuatNyangkul(daftarKartu: List<KartuDomino>) {
        println("Jumlah kartu yang masih tersedia untuk dicangkul : ${daftarKartu.size}")
    }

    private fun clearConsole() {
        try {
            val os = System.getProperty("os.name")
            if (os.contains("Windows")) {
                Runtime.getRuntime().exec(arrayOf("cls"))
            } else {
                Runtime.getRuntime().exec(arrayOf("clear"))
            }
        } catch (e: Exception) {
            //  Handle any exceptions.
        }
    }

}