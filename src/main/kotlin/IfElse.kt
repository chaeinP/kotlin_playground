package org.example

class IfElse {
    fun checkEvenNum(value: Int): Boolean {
        val result = if (value % 2 == 0) {
            true
        } else {
            false
        }

        return result
    }

    fun ternaryOperator(value: Int): Boolean {
        return if (value % 2 == 0) true else false
    }
}