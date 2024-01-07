package org.example


// exception
fun tryCatch() {
    // try catch 표현식임
    // checked Exception은 try cach 안해도 컴파일 오류는 안남
    val a = try {
        "1234".toInt()
    } catch (e: Exception) {
        println(e)
    }


    // Nothing 타입 안전 연산자 필요없음
    val b: String? = null
    val c = b ?: fail()
    println(c.length) // c?.length 라고 안해도 됨
}

// TODO: Nothing 타입 공부
// 컴파일러가 이 다음 코드는 항상 실행되지 않음을 보장해줌

fun fail(): Nothing {
    throw IllegalArgumentException()
}


// 추상 클래스
abstract class Developer {
    abstract var age: Int  // abstract 요소는 하위 클래스에서 구현을 강제
    abstract fun code(language: String)
}

class BackendDeveloper : Developer() {
    override var age = 0;
    override fun code(language: String) {
        println("1")
    }
}

// 인터페이스
class Product(val name: String, val price: Int)
interface Cart {
    var coin: Int
    fun add(product: Product)
    fun rent() {
        if (coin > 0) {
            println("1")
        }
    }

    fun printId() = println("1")
}

// 인터페이스 상속
interface Cart2 : Cart {
    fun roll() {}
}

interface Order {
    fun printId() = println("1")
}

class MyCart(override var coin: Int) : Cart, Cart2, Order {
    override fun add(product: Product) {
        if (coin <= 0) println("needs coin")
        else println("${product.name}가 담김")
    }

    // 복수개의 interface에 동일하게 구현된 시그니처 함수가 있는 경우 구현 강제
    override fun printId() {
        super<Cart>.printId()
        super<Order>.printId()
    }
}


fun main() {
    println("Hello World!")
}