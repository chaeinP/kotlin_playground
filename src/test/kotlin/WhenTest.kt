import org.amshove.kluent.shouldBe
import org.example.When
import org.junit.jupiter.api.Test

class WhenTest {
    @Test
    fun `Switch 대신 When 절을 사용한다 `() {
        val result1 = When().getDay(2)
        result1 shouldBe "화요일"

    }

    @Test
    fun `enum의 경우 처럼 값이 한정적인 경우 else 생략 가능하다`() {
        val result = When().checkRed(When.Color.RED)
        result shouldBe true
    }

    @Test
    fun `결과가 같은 조건은 한 줄에 쓸 수 있다`() {
        val result = When().checkRedAndGreen(When.Color.GREEN)
        result shouldBe true
    }
}