package spring.practice.kotlin.basicSyntaxPractice

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

/**
 * Created by kimchanjung on 2020-04-28 4:56 오후
 */
internal class ExceptionExpressionKtTest {

    @Test
    fun 예외처리블럭이_정상적으로_동작한다() {
        assertEquals(1, exception("1"))
        assertEquals(null, exception("AA"))
    }

    @Test
    fun 값이_없으면_예외를_발생시킨다() {
        val assertThrows = assertThrows<IllegalArgumentException> {
            exception3(null)
        }

        assertEquals("이름을 입력 하세요", assertThrows.message)
    }
}