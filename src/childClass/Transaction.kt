package childClass

import Categories
import Container
import Tracker

// child class
class Transaction : Tracker() {

    private val arrayIn = mutableListOf<Container>()

    fun addIn(nominal: Int, category: Categories){
        if(nominal > 0) {
            val container = Container(nominal, category, true)
            arrayIn.add(container)
            arrayCat.add(category)
            println("+Rp$nominal\t($category)")
            current += nominal
        } else {
            println("Nilai harus lebih dari 0.")
        }
    }

    fun addOut(nominal: Int, category: Categories){
        if(nominal > 0) {
            val container = Container(nominal, category, false)
            arrayOut.add(container)
            arrayCat.add(category)
            println("-Rp$nominal\t($category)")
            current -= nominal
        }
        else {
            println("Nilai harus lebih dari 0.")
        }
    }

    fun getTotalOut(): Int? {
        return if (arrayOut.isNotEmpty()) arrayOut.sumOf{it.nominal} else null
    }

    fun getTotalIn(): Int? {
        return if (arrayIn.isNotEmpty()) arrayIn.sumOf{it.nominal} else null
    }

    fun getTotalCat(category: Categories):Int? {
        var total = 0
        for (i in 0 until arrayOut.size) {
            if (arrayCat[i] == category) {
                total += arrayOut[i].nominal
            }
        }
        return if (total > 0) total else null
    }

}