import org.amshove.kluent.shouldBe
import org.example.IfElse
import org.junit.jupiter.api.Test

class IfElseTest {
    @Test
    fun `if Else 식은 값을 반환할 수 있다 `() {
        val result1 = IfElse().checkEvenNum(4)
        result1 shouldBe true

        val result2 = IfElse().checkEvenNum(5)
        result2 shouldBe false

    }

    @Test
    fun `삼항 연산자 대신 if Else 문을 사용한다`() {
        val result1 = IfElse().ternaryOperator(4)
        result1 shouldBe true

        val result2 = IfElse().ternaryOperator(5)
        result2 shouldBe false
    }
}