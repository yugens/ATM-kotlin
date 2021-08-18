package com.example

class  Printer {
    var statement = ""
    var flag: Int = 0
       fun print(text: String) {
        flag++
        statement = text
    }

}