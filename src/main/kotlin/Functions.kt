package org.example

class Functions {
    fun namedFunction(a: Int, b: Int): Int {
        return a + b;
    }

    fun functionExpression(a: Int, b: Int): Int = a + b

    fun omitReturnTypeFunctionExpression(a: Int, b: Int) = a + b

    // 디폴트 파라미터
    fun defaultParameter(message: String = "안녕하세요!"): String {
        return message
    }

    fun namedParameter(level: String = "INFO", message: String): String {
        return "[$level] $message"
    }
}