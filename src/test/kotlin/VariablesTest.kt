import org.amshove.kluent.shouldBe
import org.example.Variables
import org.junit.jupiter.api.Test

class VariablesTest {

    @Test
    fun `var로 선언했을 경우 재할당이 가능하다`() {
        val newValue = "newValue"
        val result = Variables().allocateNewValeToValue(newValue)
        result shouldBe newValue
    }

    @Test
    fun `함수 내부에서 top레벨 변수에 접근이 가능하다`() {
        val topLevelValue = Variables().getTopLevelValue();

        topLevelValue + 1 shouldBe Variables().addOneTopLevelValue()
    }

    @Test
    fun `타입과 함께 선언되었면 지연 초기화가 가능하다`() {
        val result = Variables().lazyInitialization(3)
        result shouldBe 3
    }

    @Test
    fun `val로 선언된 mutableList는 내부 요소 추가, 삭제가 가능하다`() {
        val names = Variables().addElemMutableListDeclaredByVal("new")
        names.last() shouldBe "new"
    }
}