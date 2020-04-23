package spring.practice.kotlin.basicSyntaxPractice

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

/**
 * Created by kimchanjung on 2020-04-22 3:21 오후
 */

class OperatorTest {

    @Test
    fun IN_연산자가_올바로_작동한다() {
        // Given
        val name = "kimchanjung"
        val firstName = "kim"

        // Then
        assertTrue(firstName in name)
    }

    @Test
    fun 범위_연산자가_올바로_작동한다() {
        // Given
        val age = 1
        val life = age..100

        // Then
        for (v in 1..10) {
            println(v)
        }
        life.forEach { print("$it, ") }
        println(life)
        assertTrue(2 in life)
    }

    @Test
    fun 타입확인_연산자가_올바로_작동한다() {
        // Given
        val age = 10

        // When
        val isInt = age is Int

        //Then
        assertTrue(isInt)
    }

    @Test
    fun NULL처리_연산자가_올바로_작동한다() {
        // Given
        val name: String? = null // null 이 가능한 타입
        val address: String? = "부산광역시"

        //Then
        println(name?.length)
        println(name?.substring(1)?.length)
        println(name?.length ?: 0)  // name 의 length 가 null 이면 0을 출력
        println(address?.length)
        println(address?.substring(2)?.length)
    }

    @Test
    fun 타입케스트가_정상적으로_작동한다() {
        // Given
        val name = "찬"
        val intName = name as? Int
        val intName2 = name.toIntOrNull()

        //Then
        println(intName)
        println(intName2)
   }
}