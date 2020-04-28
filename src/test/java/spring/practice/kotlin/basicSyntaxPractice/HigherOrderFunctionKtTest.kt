package spring.practice.kotlin.basicSyntaxPractice

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * Created by kimchanjung on 2020-04-28 2:53 오후
 */
internal class HigherOrderFunctionKtTest {

    @Test
    fun 상차함수가_올바로_동작한다() {
        // Given & When
        val calculator1 = calculator(1, 2) { a, b -> a + b }
        val calculator2 = calculator(1, 2, { a, b -> a + b })
        val calculator21 = calculator2({ 1 })
        val calculator22 = calculator2 { 2 }
        val calculator3 = calculator3 (1, { a -> a + 1 }, { a -> a + 2 })

        // Then
        assertEquals(3, calculator1)
        assertEquals(3, calculator2)
        assertEquals(1, calculator21)
        assertEquals(2, calculator22)
        assertEquals(5, calculator3)
    }
}