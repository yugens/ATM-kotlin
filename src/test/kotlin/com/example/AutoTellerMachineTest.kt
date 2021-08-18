package com.example

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify

val unit: Unit = Unit

class AutoTellerMachineTest : StringSpec({

    "should call banking service with correct amount"{
        val fakePrinter = mockk<Printer>()
        val fakeBankingService = mockk<BankingService>()
        every { fakeBankingService.withdraw(20) }returns unit
        val atm = AutoTellerMachine(fakePrinter, fakeBankingService)
        atm.withdraw(20)
        verify { fakePrinter.print("20") }
        fakeBankingService.balance shouldBe 20
    }

    "should print a receipt if money is withdrawn successfully" {
        val fakePrinter = mockk<Printer>()
        val fakeBankingService = mockk<BankingService>()
        every { fakeBankingService.withdraw(20) }returns unit
        val atm = AutoTellerMachine(fakePrinter, fakeBankingService)
        atm.withdraw(20)
        verify { fakePrinter.print("1") }
        fakePrinter.flag shouldBe 1
    }

    "should throw exception if banking service throws an exception" {
        val fakePrinter = mockk<Printer>()
        val fakeBankingService = mockk<BankingService>()
        every { fakeBankingService.withdraw(20) }returns unit
        val atm = AutoTellerMachine(fakePrinter, fakeBankingService)
        atm.withdraw(20)
        verify { fakePrinter.print("Insufficient balance") }
        fakePrinter.flag shouldBe 1
        fakePrinter.statement shouldBe "Insufficient balance"
    }


})



