package spring.practice.kotlin.basicSyntaxPractice

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * Created by kimchanjung on 2020-04-23 12:54 오후
 */

class DefineFunctionTest {


    // 중위 함수 - Int 타입에 적용한다, 자기 자신 값과 파라메터를 합산
    private infix fun Int.infixFunc(value: Int):Int {
        return this + value
    }

    // 중위 함수 - 모든 타입에 추가한다, 어떤 타입이던 문자열로 변경후 파라메터와 합쳐서 문자열로 리턴
    private infix fun Any.infixFunc2(value: Int) = this.toString() + value


    @Test
    fun 함수가_정상적으로_선언된다() {
        // Given
        fun simpleFunc(name: String = "김찬정", age: Int = 10): String = if (age > 10) name else "어린이"

        // When
        val result = simpleFunc()
        val result2 = simpleFunc("찬정", 20)
        val result3 = simpleFunc(age = 20, name = "찬정")
        val result4 = simpleFunc(age = 20)

        // Then
        assertEquals("어린이", result)
        assertEquals("찬정", result2)
        assertEquals("찬정", result3)
        assertEquals("김찬정", result4)


    }

    @Test
    fun 가변인자가_정상적으로_선언된다() {

        // Given
        val item = Array(5) { v -> v + 1 }
        fun <T> newList(vararg ts: T): List<T> {
            val result = ArrayList<T>()
            for (t in ts)
                result.add(t)

            return result
        }

        // When
        val newList = newList(1, 2, 3)
        val newList2 = newList(*item) // '*' 스프레드 연산자 item의 요소를 풀어서 넘긴다.


        // Then
        newList.forEach { println(it) }
        println()
        newList2.forEach { println(it) }
    }

    /**
     * 코틀린 확장 함수란 상속받지 않고 메소드를 추가한다.
     */
    @Test
    fun 확장함수가_정상적으로_선언된다() {

        // Given
        fun <T> Array<T>.addMethod(index1: Int, index2: Int): Int {
            return 1
        }

        val arrayOf = arrayOf(1, 2, 3)

        // When
        val addMethod = arrayOf.addMethod(1, 3)

        // Then
        assertEquals(1, addMethod)
    }

    /**
     * 코틀린 확장 함수란 상속받지 않고 메소드를 추가한다.
     */
    @Test
    fun 중위함수가_정상적으로_선언된다() {
        println(1 infixFunc 2)
        println("문" infixFunc2 2)
        println(1.infixFunc(2))
        println("문".infixFunc2(2))
    }
}
