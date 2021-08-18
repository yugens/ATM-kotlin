package com.example

class BankingService(val transaction: Boolean){
    var balance = 0;
    fun withdraw(amount: Int) {
        balance = amount
        if (transaction == false) {
            throw error("Not enough amount available")
        }
    }

}