import childClass.Debt
import childClass.Transaction

fun main() {
    try {
        println("\n==========FINANCIAL TRACKER==========")

        // Input Data Transaksi
        println("\nDAFTAR TRANSAKSI")
        val tgl28 = Transaction()
        tgl28.date(28, 10, 2023)
        tgl28.addIn(500000, Categories.PAYCHECK)
        tgl28.addOut(50000, Categories.ENTERTAIMENT)
        tgl28.addOut(35000, Categories.FOOD)
        tgl28.addOut(12000, Categories.TRANSPORTATION)
        tgl28.addIn(50000, Categories.BONUS)

        val tgl29 = Transaction()
        tgl29.date(29, 10, 2023)
        tgl29.addOut(25000, Categories.FOOD)
        tgl29.addOut(120000, Categories.ENTERTAIMENT)


        // Cetak Outcome
        println("\nTOTAL SELURUH OUTCOME")
        val totalOut = tgl28.getTotalOut()
        if (totalOut != null) {
            println("Total outcome = Rp$totalOut")
        } else {
            println("Tidak ada Outcome.")
        }


        // Cetak Income
        println("\nTOTAL SELURUH INCOME")
        val totalIn = tgl28.getTotalIn()
        if (totalIn != null) {
            println("Total income = Rp$totalIn")
        } else {
            println("Tidak ada Income.")
        }


        // Cetak Nominal Saat Ini
        println("\nNOMINAL SAAT INI")
        tgl28.cetakNow()


        // Laporan Budgeting
        println("\nCHECK BUDGETING UPDATE")
        val listCategory = Categories.FOOD

        when (listCategory) {
            Categories.FOOD -> {
                val planned = 50000
                val totalOut: Int? = tgl28.getTotalCat(Categories.FOOD)
                if (totalOut == null) {
                    println("Tidak ada pengeluaran untuk FOOD.")
                } else {
                    if (totalOut > planned) {
                        val diff = planned - totalOut
                        println("Anda telah melewati Budget FOOD sebesar Rp$diff.")
                    } else {
                        println("Anda masih dalam batas Budget FOOD.")
                    }
                }
            }

            Categories.ENTERTAIMENT -> {
                val planned = 50000
                val totalOut: Int? = tgl28.getTotalCat(Categories.ENTERTAIMENT)
                if (totalOut == null) {
                    println("Tidak ada pengeluaran untuk ENTERTAIMENT.")
                } else {
                    if (totalOut > planned) {
                        val diff = planned - totalOut
                        println("Anda telah melewati Budget ENTERTAIMENT sebesar Rp$diff.")
                    } else {
                        println("Anda masih dalam batas Budget ENTERTAIMENT.")
                    }
                }
            }

            Categories.TRANSPORTATION -> {
                val planned = 20000
                val totalOut: Int? = tgl28.getTotalCat(Categories.TRANSPORTATION)
                if (totalOut == null) {
                    println("Tidak ada pengeluaran untuk TRANSPORTATION.")
                } else {
                    if (totalOut > planned) {
                        val diff = planned - totalOut
                        println("Anda telah melewati Budget TRANSPORTATION sebesar Rp$diff.")
                    } else {
                        println("Anda masih dalam batas Budget TRANSPORTATION.")
                    }
                }
            }

            Categories.MEDICAL -> {
                val planned = 100000
                val totalOut: Int? = tgl28.getTotalCat(Categories.MEDICAL)
                if (totalOut == null) {
                    println("Tidak ada pengeluaran untuk MEDICAL.")
                } else {
                    if (totalOut > planned) {
                        val diff = planned - totalOut
                        println("Anda telah melewati Budget MEDICAL sebesar Rp$diff.")
                    } else {
                        println("Anda masih dalam batas Budget MEDICAL.")
                    }
                }
            }

            Categories.other_out -> {
                val planned = 50000
                val totalOut: Int? = tgl28.getTotalCat(Categories.other_out)
                if (totalOut == null) {
                    println("Tidak ada pengeluaran untuk OTHER.")
                } else {
                    if (totalOut > planned) {
                        val diff = planned - totalOut
                        println("Anda telah melewati Budget OTHER sebesar Rp$diff.")
                    } else {
                        println("Anda masih dalam batas Budget OTHER.")
                    }
                }
            }

            else -> println("Ini bukan kategori Outcome.")

        }

        // Data Hutang
        println("\nDATA HUTANG")
        val utang = Debt()
        utang.addDebt(0, "Amanda")
        utang.addDebt(27000, "Amanda")
        utang.addDebt(10000, "Nurul")

        val totalKeAmanda = utang.getTotalDebt("Amanda")

        println("Total Hutang ke Amanda = Rp$totalKeAmanda")
    } catch (e: Exception) {
        println("Terjadi kesalahan: ${e.message}")
    }
}