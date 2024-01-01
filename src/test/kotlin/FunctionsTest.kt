import org.amshove.kluent.shouldBe
import org.amshove.kluent.shouldBeEqualTo
import org.example.Functions
import org.junit.jupiter.api.Test

class FunctionsTest {

    @Test
    fun `기명함수`() {
        val result = Functions().namedFunction(1, 3)
        result shouldBe 4
    }

    @Test
    fun `함수 표현식`() {
        val result = Functions().functionExpression(1, 3)
        result shouldBe 4
    }

    @Test
    fun `함수 표현식은 리턴 타입 생략이 가능하다`() {
        val result = Functions().omitReturnTypeFunctionExpression(1, 3)
        result shouldBe 4
    }

    @Test
    fun `파라미터가 주어지지 않았을 때 디폴트 값을 파라미터에 부여할 수 있다`() {
        val message = Functions().defaultParameter()
        message shouldBe "안녕하세요!"
    }

    @Test
    fun `named prameter 방식을 사용하면 파라미터 순서에 상관없이 값을 부여할 수 있다`() {
        val message1 = Functions().namedParameter(message = "log")
        val message2 = Functions().namedParameter(level = "DEBUG", message = "log")
        val message3 = Functions().namedParameter(message = "log", level = "DEBUG")

        message1 shouldBeEqualTo "[INFO] log"
        message2 shouldBeEqualTo "[DEBUG] log"
        message3 shouldBeEqualTo "[DEBUG] log"
    }
}