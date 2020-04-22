package spring.practice.kotlin

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * Created by kimchanjung on 2020-04-19 3:29 오후
 */
internal class DefineDataTypeTest {

    @Test
    fun 숫자타입이_정상적으로_선언된다() {
        // Given
        val age = 10
        var height: Int = 180
        val shoeSize = 260_270

        // When
        height = 170
        val newAge = age + 20
        val newHeight = height + 10

        // Then
        assertEquals(30, newAge)
        assertEquals(180, newHeight)
        assertEquals(260270, shoeSize)
    }

    @Test
    fun 문자타입이_정상적으로_선언된다() {
        // Given
        val name = "김찬정"
        var address: String = "서울"
        val job = """
            컴퓨터
            프로그래머
        """
        val company = """
            우아한형제들
            배달의민족
            딜리버리플랫폼팀
        """.trimIndent()

        // When
        address = "부산"
        val newName = name + "님"
        val newAddress = address + "광역시"


        // Then
        println(job)
        println(company)
        assertEquals("김찬정님", newName)
        assertEquals("부산광역시", newAddress)
    }

    @Test
    fun 배열이_정상적으로_선언된다() {
        // Given
        val arr = arrayOfNulls<Int>(10)
        val initArr = arrayOf(1, 2, 3)
        val initDiffTypeArr = arrayOf(1, "2", 3L)
        val initIntArr = intArrayOf(1, 2, 3)
        val initConstructorArr = Array(10) { 1 }
        val initLambdaArr = Array(10) { v -> v + 1 }

        // When
        arr[0] = 1
        arr.set(1, 2)

        // Then
        for (v in arr) {
            println(v)
        }
        for ((index, value) in initDiffTypeArr.withIndex()) {
            println("$index: $value")
        }
        initArr.forEach { println(it) }
        initArr.forEachIndexed { index, v -> println("$index) $v") }

        assertEquals(3, initIntArr[2])
        assertEquals(2, arr[1])
        assertEquals(1, initConstructorArr.get(2))
        assertEquals(10, initConstructorArr.size)
    }
}