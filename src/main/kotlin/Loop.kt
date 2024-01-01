package org.example

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
}