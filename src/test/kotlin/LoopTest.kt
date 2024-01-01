import org.amshove.kluent.shouldBeEqualTo
import org.example.Loop
import org.junit.jupiter.api.Test

class LoopTest {

    @Test
    fun `range`() {
        val array = Loop().range(1, 3)
        array shouldBeEqualTo mutableListOf(1, 2, 3)
    }

    @Test
    fun `until`() {
        val array = Loop().until(1, 3)
        array shouldBeEqualTo mutableListOf(1, 2)
    }

    @Test
    fun `step`() {
        val array = Loop().step(1, 6, 2)
        array shouldBeEqualTo mutableListOf(1, 3, 5)
    }

    @Test
    fun `downTo`() {
        val array = Loop().downTo(3, 1)
        array shouldBeEqualTo mutableListOf(3, 2, 1)
    }
}