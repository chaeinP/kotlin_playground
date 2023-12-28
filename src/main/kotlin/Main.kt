package org.example

import org.intellij.lang.annotations.Language

// 함수 바깥에서 변수 선언 가능
var o = 1;

fun variables(){
    // 함수 안에서 탑레벨 변수 참조 가능
    o += 1;

    //
    val a: Int = 1;

    // 타입 추론
    val b = 1;

    //지연 할당, 타입 선언은 반드시
    val c: Int;
    c = 1;

    // var vs val
    // var => 재할당 가능, val => final, readonly
    var d: String = "HELLO"
    d = "WORLD"
    // d = 1 다른 타입으로 재할당 안됨

    val e: String = "HELLO"
    // e = "WORLD" => 재할당에서 에러남

    // node에서 var 안쓰는 것처럼 그냥 val만 있다고 생각하고 쓰자
}

fun functions(){
    // 기본 함수 스타일
    fun sum(a: Int, b: Int): Int {
        return a + b;
    }

    // 표현식 가능
    fun sum2(a:Int, b:Int): Int = a + b

    // 표현식 & 반환 타입 생략
    // 표현식 아닌데 반환 타입 제거하면 오류남
    fun sum3(a:Int, b:Int) = a + b

    // 반환 타입이 없으면 Unit 반환 => void 같은 것
    // TODO: Unit 타입 알아보기
    fun printSum(a:Int, b:Int) {
        println("$a + $b")
    }

    // 디폴트 파라미터
    fun greeting(message:String = "안녕하세요!"){
        println(message)

        // greeting() => "안녕하세요!" 출력
    }

    // named parameter
    fun log(level: String ="INFO", message: String){
        println("[$level] $message")
    }

    log(message="log")
    log(level="DEBUG", message="log")
    log(message="log", level="DEBUG")
    log("DEBUG", "log") // 개발시 실수하기 쉬운 부분
}

fun ifElse(){
    val a = 'a'

    if (a == 'a'){
        println("same")
    } else {
        println("not same")
    }

    // if else는 표현식이다. 짱편함
    val age = 10;
    val str = if (age > 10) {
        "성인"
    } else {
        "아이"
    }

    // if else는 삼항연산자가 없다.
    val aa = 1;
    val b = 2;
    val c = if (aa > b) b else aa // 삼항연산자 대신 요렇게
}

// switch를 대신하는 when 식
fun whenExpression(){
    val day = 2;

    // 값 반환 가능
    // break 안해도 됨
    val result = when (day) {
        1 -> "월요일"
        2 -> "화요일"
        else -> "기타"
    }
    println(result)
}

enum class Color {
    RED, GREEN
}

fun getColor() = Color.RED
fun whenExpression2(){
    // enum 타입 추론으로 else 없어도 오류 안남
    when(getColor()){
        Color.RED -> println(1);
        Color.GREEN -> println(2);
    }

    // 여러개 조건 한줄에 다 쓸 수 있음
    when(getColor()){
        Color.RED, Color.GREEN -> println(1)
    }
}

fun loop(){
    // 범위 연산자 ..
    for (i in 0 .. 3){
     println(i)
    }

    // until <= a <
    for (i in 0 until 3){
        println(i)
    }

    // step
    for (i in 0 .. 6 step 2){
        println(i)
    }

    // downTo
    for (i in 3 downTo 1){
        println(i)
    }

    // 배열반복
    val numbers = arrayOf(1,2,3)
    for(i in numbers){
        println(i)
    }

    // while은 크게 다른거 없음
    var x = 5
    while( x > 0){
        println(x)
        x--
    }
}

// kotlin의 NPE 해결 => 컴파일 오류 발생됨, 100% 방지는 안됨
fun npeProblem(){
    // val a: String = null; => 컴파일 오류

    //nullable
    val a: String? = null
    // a.length => 컴파일 오류
    // 안전연산자를 사용하자!
    println(a?.length)

    // 엘비스 연산자, js 에서 ?? 같은 녀석
    val c = a?.length ?: 0

    // 단언 연산자, null이 아님을 단언하는 연신자 ts !와 같음
    val d = a!!.length
}

// exception
fun tryCatch(){
    // try catch 표현식임
    // checked Exception은 try cach 안해도 컴파일 오류는 안남
    val a = try {
        "1234".toInt()
    }catch(e: Exception){
        println(e)
    }


    // Nothing 타입 안전 연산자 필요없음
    val b: String? = null
    val c = b?: fail()
    println(c.length) // c?.length 라고 안해도 됨
}

// TODO: Nothing 타입 공부
// 컴파일러가 이 다음 코드는 항상 실행되지 않음을 보장해줌

fun fail(): Nothing{
    throw IllegalArgumentException()
}

// 클래스
class Coffee constructor (val name: String) {
}

// constructor 생략 가능
class Coffee1 (val name: String){

}

// 게터 세터 자동 설정
// val => 게터만
// var => 게터, 세터 모두
fun classTest(){
    val t = Coffee1("1")
    println(t.name)

}

// 본문 없으면 중괄호 생략 가능
class Coffe2(val name: String)

// 커스텀 게터, 세터
class Coffe3(val name: String){
    var brand:String = "1"
        get() = "1"
    // get(){return "1"} 힘수로 로직 작성도 가능

    var quantity: Int = 0
        set(value){
            if (value > 0){
                field = value
                // quantity = value 하면 무한 재귀 상태가 발생, field 식별자로 backing field에 접근하게 함
            }
        }
}

// 모든 클래스의 조상은 Any
// class 기본은 final, 상속 가능한 클래스를 위해선 open 을 붙여야함
open class Dog {
    open var age: Int = 0
    open fun bark(){
        println("멍")
    }
}
// 상속
class Bulldog: Dog(){
    override var age: Int // override한 요소, 메소드는 자동으로 모두 open 상태
        get() = super.age
        set(value) {}

    final override fun bark() { // override 막기
        super.bark()
    }
}

// 생성자에 override 할 수 있음
class Bulldog1(override var age: Int):Dog(){}

// 추상 클래스
abstract class Developer {
    abstract var age: Int  // abstract 요소는 하위 클래스에서 구현을 강제
    abstract fun code(language: String)
}

class BackendDeveloper: Developer() {
    override var age = 0;
    override fun code(language: String){
        println("1")
    }
}

// 인터페이스
class Product(val name:String, val price:Int)
interface Cart {
    var coin: Int
    fun add(product: Product)
    fun rent(){
        if (coin > 0) {
            println("1")
        }
    }

    fun printId() = println("1")
}

// 인터페이스 상속
interface Cart2: Cart {
    fun roll(){}
}

interface Order{
    fun printId() = println("1")
}

class MyCart(override var coin: Int): Cart, Cart2, Order {
    override fun add(product: Product) {
        if (coin <= 0) println("needs coin")
        else println("${product.name}가 담김")
    }

    // 복수개의 interface에 동일하게 구현된 시그니처 함수가 있는 경우 구현 강제
    override fun printId(){
        super<Cart>.printId()
        super<Order>.printId()
    }
}


fun main() {
    println("Hello World!")
}