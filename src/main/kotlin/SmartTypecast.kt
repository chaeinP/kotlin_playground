package org.example

interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

fun eval(e: Expr): Int {
    if (e is Num)
        return e.value // 따로 e as Num 이라고 캐스팅 해주지 않아도 알아서 캐스팅 됩
    else if (e is Sum)
        return eval(e.left) + eval(e.right)
    else
        throw IllegalArgumentException()
}

fun eval2(e: Expr): Int {
    return when (e) {
        is Num -> e.value
        is Sum -> eval2(e.left) + eval2(e.right)
        else
        -> throw IllegalArgumentException()
    }
}

fun eval3(e: Expr): Int {
    return when (e) {
        is Num -> { // if, when 블록문으로 쓸때 가장 마지막 식이 블록의 결과임
            println("e is Num")
            e.value
        }

        is Sum -> eval2(e.left) + eval2(e.right)
        else
        -> throw IllegalArgumentException()
    }
}