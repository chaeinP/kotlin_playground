package org.example

//default public
class Person(
    val name: String, // 읽기 전용, only getter
    var isMarried: Boolean // getter and setter
)

class Rectangle(val height: Int, val width: Int) {
    val isSquare: Boolean
        get() {
            return height == width
        }
}

class Coffee(val name: String) {
    var brand: String = "1"
        get() = name
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
    override var age: Int
        get() = 0
        set(value) {}
    // override한 요소, 메소드는 자동으로 모두 open 상태


    final override fun bark() { // override 막기
        super.bark()
    }
}


// 생성자에 override 할 수 있음
class Bulldog1(override var age: Int) : Dog() {}