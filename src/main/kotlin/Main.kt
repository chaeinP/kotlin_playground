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

// 클래스
class Coffee constructor(val name: String) {
}

// constructor 생략 가능
class Coffee1(val name: String) {

}

// 게터 세터 자동 설정
// val => 게터만
// var => 게터, 세터 모두
fun classTest() {
    val t = Coffee1("1")
    println(t.name)

}

// 본문 없으면 중괄호 생략 가능
class Coffe2(val name: String)

// 커스텀 게터, 세터
class Coffe3(val name: String) {
    var brand: String = "1"
        get() = "1"
    // get(){return "1"} 힘수로 로직 작성도 가능

    var quantity: Int = 0
        set(value) {
            if (value > 0) {
                field = value
                // quantity = value 하면 무한 재귀 상태가 발생, field 식별자로 backing field에 접근하게 함
            }
        }
}

// 모든 클래스의 조상은 Any
// class 기본은 final, 상속 가능한 클래스를 위해선 open 을 붙여야함
open class Dog {
    open var age: Int = 0
    open fun bark() {
        println("멍")
    }
}

// 상속
class Bulldog : Dog() {
    override var age: Int // override한 요소, 메소드는 자동으로 모두 open 상태
        get() = super.age
        set(value) {}

    final override fun bark() { // override 막기
        super.bark()
    }
}

// 생성자에 override 할 수 있음
class Bulldog1(override var age: Int) : Dog() {}

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