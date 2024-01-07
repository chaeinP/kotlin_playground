package org.example


enum class Color(val r: Int, val g: Int, val b: Int) {

    RED(255, 0, 0), BLUE(0, 0, 255), GREEN(0, 255, 0); // 메서드를 정의하는 경우 마지막 상수 뒤에 ;를 붙여야함

    fun rgb() = (r * 256 + g) * 256 + b
}

fun mix(c1: Color, c2: Color): Color {
    return when (setOf(c1, c2)) {
        setOf(Color.RED, Color.BLUE) -> Color.GREEN
        else -> Color.RED
    }
}

// 위와 다르게 setOf 객체를 만들지 않아서 효율적임
fun mixOptimized(c1: Color, c2: Color): Color {
    return when {
        (c1 == Color.RED && c2 == Color.BLUE) || (c1 == Color.BLUE && c2 == Color.RED)
        -> Color.GREEN

        else -> Color.RED
    }
}