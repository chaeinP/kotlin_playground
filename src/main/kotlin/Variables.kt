package org.example

val topLevelValue: Int = 0;

class Variables() {
    var value: String = "1"
    fun allocateNewValeToValue(newValue: String): String {
        value = newValue
        return value;
    }

    fun getTopLevelValue(): Int {
        return topLevelValue;
    }

    fun addOneTopLevelValue(): Int {
        return topLevelValue + 1;
    }

    fun lazyInitialization(data: Int): Int {
        val value: Int
        value = data
        return value
    }

    fun addElemMutableListDeclaredByVal(value: String): MutableList<String> {
        val names = mutableListOf("1", "2", "3")
        names.add(value)
        return names
    }
}