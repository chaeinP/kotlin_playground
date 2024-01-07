package org.example

import java.util.*

class Loop {
    val array = mutableListOf<Int>()

    fun range(a: Int, b: Int): MutableList<Int> {
        for (i in a..b) {
            array.add(i)
        }

        return array
    }

    fun until(a: Int, b: Int): MutableList<Int> {
        for (i in a until b) {
            array.add(i)
        }

        return array
    }

    fun step(a: Int, b: Int, c: Int): MutableList<Int> {
        for (i in a..b step c) {
            array.add(i)
        }

        return array
    }

    fun downTo(a: Int, b: Int): MutableList<Int> {
        for (i in a downTo b) {
            array.add(i)
        }

        return array
    }

    fun loopMap() {
        val binaryReps = TreeMap<Char, String>()
        for (c in 'A'..'F') {
            val binary = Integer.toBinaryString(c.digitToInt())
            binaryReps[c] = binary
        }

        for ((letter, binary) in binaryReps) {
            println("${letter}, ${binary}")
        }

        val list = arrayListOf("10", "11", "12")
        for ((index, element) in list.withIndex()) {
            println("{$index}: {$element}")
        }

    }

    fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'
    fun isNotDigit(c: Char) = c !in '0'..'9'
    fun recognize(c: Char) = when (c) {
        in '0'..'9' -> "digit"
        in 'a'..'z', in 'A'..'Z' -> "letter"
        else -> "dont know"
    }

    fun string(): Boolean {
        return "Kotlin" in "Java".."Scala"
    }

}