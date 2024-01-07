import org.amshove.kluent.shouldBe
import org.example.Coffee
import org.example.Person
import org.example.Rectangle
import org.junit.jupiter.api.Test

class ClassTest {
    @Test
    fun `클래스 프로퍼티 접근`() {
        val person = Person(name = "Bob", isMarried = true)
        person.name shouldBe "Bob"
        person.isMarried shouldBe true
    }

    @Test
    fun `커스텀 게터 사용`() {
        val rectangle = Rectangle(height = 10, width = 10)
        rectangle.height shouldBe 10
        rectangle.width shouldBe 10
        rectangle.isSquare shouldBe true
    }

    @Test
    fun `커스텀 세터 사용`() {
        val coffee = Coffee(name = "브라질")
        coffee.quantity = 1

        coffee.brand shouldBe "브라질"
        coffee.quantity shouldBe 1
    }


}