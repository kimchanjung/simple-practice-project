package spring.practice.kotlin.designPattern.statePattern

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * Created by kimchanjung on 2020-05-12 3:11 오후
 */
internal class StatePatternTest {

    @Test
    fun 상태패턴이_정상적으로_동작한다() {
        // Given
        val delivery = Delivery()
        // When
        val status1 = delivery.backwardStatus()
        val status2 = delivery.forwardStatus()
        val status3 = delivery.forwardStatus()
        val status4 = delivery.forwardStatus()
        val status5 = delivery.forwardStatus()

        // Then
        assertEquals("뒤로불가", status1)
        assertEquals("배차완료", status2)
        assertEquals("픽업완료", status3)
        assertEquals("전달완료", status4)
        assertEquals("진행불가", status5)
    }
}