package spring.practice.kotlin.basicSyntaxPractice

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

/**
 * Created by kimchanjung on 2020-04-23 12:19 오후
 */

class ArrayTest {

    @Test
    fun 배열이_정상적으로_선언된다() {
        // Given
        val arr = arrayOfNulls<Int>(10)
        val initArr = arrayOf(1, 2, 3)
        val initDiffTypeArr = arrayOf(1, "2", 3L)
        val initIntArr = intArrayOf(1, 2, 3)
        val initConstructorArr = Array(10) { 1 }
        val initLambdaArr = Array(10) { v -> v + 1 }
        val initWithIncrement = (1..10).toList().toTypedArray()
        val initWithIncrementByStep = (1..10).step(2).toList().toTypedArray()
        val initWithIncrementByStep2 = IntRange(1, 10).step(2).toList().toTypedArray()

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
        initWithIncrement.forEach { println("initWithIncrement) $it") }
        initWithIncrementByStep.forEach { println("initWithIncrementByStep) $it") }

        Assertions.assertEquals(3, initIntArr[2])
        Assertions.assertEquals(2, arr[1])
        Assertions.assertEquals(1, initConstructorArr.get(2))
        Assertions.assertEquals(10, initConstructorArr.size)
    }
}