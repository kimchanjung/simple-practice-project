package spring.practice.kotlin

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * Created by kimchanjung on 2020-04-19 3:47 오후
 */
internal class ExpressionPracticeTest {


    @Test
    fun 변수의_값_선언에_IF_가_정상적으로_반영된() {
        // Given
        val msgType = 1

        // When
        val msg = if (msgType == 1) "안녕" else "잘가"

        // Then
        assertEquals("안녕", msg)
    }


    @Test
    fun 함수_선언에_IF_가_정상적으로_반영된다() {
        // Given
        fun getMsg(msgType: Int) = if (msgType == 1) "안녕" else "잘가"

        // When
        val msg = getMsg(2)

        // Then
        assertEquals("잘가", msg)
    }

    @Test
    fun WHEN_선언이_정상적으로_동작한다() {
        // Given
        val inputType = 2
        val inputString = "2"
        fun checkType(type: Int) = if (type == 1) 1 else -1

        // When
        when(inputType) {
            1 -> println("1")
            2,3 -> println("2 or 3")
            else -> println("not")
        }

        when(inputType) {
            checkType(inputType) -> println("OK")
            else -> println("NOT OK")
        }

        val result = when(inputType) {
            in 1..100 -> "1..100 OK"
            else -> "NOT OK"
        }

        when {
            inputString == "4" -> println("4 OK")
            inputString.length == 1 -> println("LENGTH IS 1")
          //  else -> println("2 NOT OK")
        }

        // Then
        assertEquals("1..100 OK", result)
    }

}