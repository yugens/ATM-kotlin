package com.example

class AutoTellerMachine(val printer: Printer, val bankingService: BankingService) {
    fun withdraw(amount: Int) {
        //WRITE CODE HERE.
        try {
            bankingService.withdraw(amount)
            printer.print("$amount withdrawn by customer")
        } catch (exception: Exception) {
            printer.print("Insufficient balance")
        }
    }
}