import org.amshove.kluent.shouldBe
import org.example.Npe
import org.junit.jupiter.api.Test

class NpeTest {
    @Test
    fun `안전연산자와 엘비스 연산자를 이용해 NPE를 방어할 수 있다`() {
        val result = Npe().getStringLength(null)
        result shouldBe 0
    }
}