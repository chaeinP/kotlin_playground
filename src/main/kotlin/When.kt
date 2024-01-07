package org.example

class When {

    enum class Color {
        RED, GREEN
    }

    fun getDay(day: Int): String {

        // 값 반환 가능
        // break 안해도 됨
        val result = when (day) {
            1 -> "월요일"
            2 -> "화요일"
            else -> "기타"
        }

        return result
    }


    fun checkRed(color: Color): Boolean {
        // enum 타입 추론으로 else 없어도 오류 안남
        return when (color) {
            Color.RED -> true
            Color.GREEN -> false
        }
    }


    fun checkRedAndGreen(color: Color): Boolean {
        // 여러개 조건 한줄에 다 쓸 수 있음
        return when (color) {
            Color.RED, Color.GREEN -> true
        }
    }
}