package spring.practice.kotlin.designPattern.chainOfReponsibilityPattern

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * Created by kimchanjung on 2020-05-11 3:28 오후
 */
internal class ChainOfResponsibilityPatternTest {

    @Test
    fun 책연쇠패턴이_정상적으로_동작한다() {
        // Given
        val riderService = RiderService()

        // When
        val delivery = riderService.delivery("분식")

        // Then
        assertEquals("분식배달", delivery)
    }
}