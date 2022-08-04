interface GameDominoUserInterface {

    fun inputJumlahPemain(): Int

    fun inputNamaPemain(pemainKe: Int): String

    fun cetakDaftarKartuTerbuang(daftarKartu: List<KartuDomino>)

    fun cetakGiliranPemain(pemain: Pemain)

    fun cetakKartuYangBisaDimainkanPemain(pemain: Pemain, kartuYangBisaDimainkan: List<KartuBisaDimainkan>)

    fun cetakKartuYangDicangkulPemain(pemain: Pemain, kartuYangDitarik: List<KartuDomino>)

    fun tampilkanDaftarPemenang(daftarPemenang: List<Pemain>)

    fun cetakDaftarKartuBuatNyangkul(daftarKartu: List<KartuDomino>)

}