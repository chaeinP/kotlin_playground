import org.amshove.kluent.shouldBeEqualTo
import org.example.Color
import org.junit.jupiter.api.Test

class EnumTest {
    @Test
    fun `enum 메소드 테스트`() {
        Color.BLUE.rgb() shouldBeEqualTo 255
    }
}