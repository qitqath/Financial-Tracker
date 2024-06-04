package childClass

import Categories
import Container
import Tracker
import kotlin.IllegalArgumentException

class Debt : Tracker() {

    private val arrayDebt = mutableListOf<String>()

    fun addDebt(nominal: Int, nama: String) {
        try {
            if (nominal > 0) {
                val container = Container(nominal, Categories.DEBT, false)
                arrayOut.add(container)
                arrayCat.add(Categories.DEBT)
                arrayDebt.add(nama)
                println("Rp$nominal kepada $nama.")
            } else {
                throw IllegalArgumentException("Nilai harus lebih dari 0.")
            }
        } catch (e: IllegalArgumentException){
            println("Error: ${e.message}")
        }
    }

    fun getTotalDebt(nama: String): Int {
        var total = 0
        for (i in 0 until arrayOut.size) {
            if (arrayCat[i] == Categories.DEBT && arrayOut[i].nominal > 0 && nama == arrayDebt[i]) {
                total += arrayOut[i].nominal
            }
        }
        return if (total > 0) total else 0
    }

}