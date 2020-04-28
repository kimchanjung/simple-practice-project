package spring.practice.kotlin.basicSyntaxPractice

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * Created by kimchanjung on 2020-04-28 1:58 오후
 */

internal class LambdaExpressionTest {

    @Test
    fun 기본람다식이_정상적으로_동작한다() {
        assertEquals(3, sum(1, 2))
        assertEquals(3, sumLambda(1, 2))
        assertEquals(3, sum2(1, 2))
        assertEquals(3, sum2Lambda(1, 2))
    }

    @Test
    fun 콜렉션_람다식이_정상적으로_동작한다() {
        // Given
        val listOf = List(10) { v -> v + 1 }

        // When
        val map = listOf.filter { it > 2 }
                .map { it + 10 }

        // Then
        assertEquals(13, map[0])
    }
}

