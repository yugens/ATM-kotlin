package com.example
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class DummyTest : StringSpec({
    "should return the dummy output" {
        Dummy().dummyOutput("hello") shouldBe "hellohello"
    }

})