class KartuDomino(

    private var nominal1: Int,

    private var nominal2: Int,

) {

    override fun toString(): String {
        return "(${this.nominal1}, ${this.nominal2})"
    }

    fun tukarPosisi() {
        val temp = nominal1
        nominal1 = nominal2
        nominal2 = temp
    }

    fun getNominal1(): Int {
        return nominal1
    }

    fun getNominal2(): Int {
        return nominal2
    }

}