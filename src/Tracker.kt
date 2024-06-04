// parent class
open class Tracker {

    val arrayOut = mutableListOf<Container>()
    val arrayCat = mutableListOf<Categories>()
    private val awal: Int = 500000
    var current: Int = awal

    fun date(day: Int, month: Int, year: Int) {
        println("Tanggal: $day/$month/$year")
    }

    fun cetakNow(){
        println("Nominal = Rp$current")
    }

}