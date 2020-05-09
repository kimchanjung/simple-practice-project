package spring.practice.kotlin.basicSyntaxPractice

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * Created by kimchanjung on 2020-04-22 3:21 오후
 */

class OperatorTest {


    @Test
    fun 동등성_테스트가_정상적으로_작동한() {
        // Given
        val a = 1
        val b = 1
        val A = Integer(1)
        val B = Integer(1)
        class Person(val name: String)
        data class Car(val name: String)

        // When
        val person = Person("김찬정")
        val person2 = Person("김찬정")
        val sonata = Car("sonata")
        val sonata2 = Car("sonata")

        // Then
        assertTrue(a == b)
        assertTrue(a === b)
        assertTrue(a.equals(b))
        assertTrue(A == B)
        assertFalse(A === B)
        assertTrue(A.equals(B))

        assertFalse(person == person2)
        assertFalse(person === person2)
        assertFalse(person.equals(person2))
        assertTrue(person.name == person2.name)
        assertTrue(person.name === person2.name)
        assertTrue(person.name.equals(person2.name))

        assertTrue(sonata == sonata2)
        assertFalse(sonata === sonata2)
        assertTrue(sonata.equals(sonata2))
        assertTrue(sonata.name == sonata2.name)
        assertTrue(sonata.name === sonata2.name)
        assertTrue(sonata.name.equals(sonata2.name))
    }

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
        val newName = name ?: "김찬정" // name 이 null 이면 김찬정 값을 대입 아니면 name 값 대입

        //Then
        println(newName)
        println(name?.length)
        println(name?.substring(1)?.length)
        println(name?.length ?: 0)  // name 의 length 가 null 이면 0을 출력 아니면 length 출력
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

    @Test
    fun 연산자_오버로딩_및_확장이_정상적으로_작동한다() {
        // Given
        operator fun Int.plus(b: String) = "$this$b"

        class Position(var a: Int, var b: Int) {
            operator fun plus(position: Position): Position {
                return Position(a + position.a, b + position.b)
            }

            operator fun set(position: Int, value: Int) {
                when (position) {
                    0 -> a = value
                    1 -> b = value
                    else -> throw IndexOutOfBoundsException("Invalid coordinate $position")
                }
            }

            operator fun get(position: Int): Int = when (position) {
                0 -> a
                1 -> b
                else -> throw IndexOutOfBoundsException("Invalid coordinate $position")
            }
        }

        // When
        val add = 10 + "2"
        val position = Position(1, 2) + Position(3, 4)
        position[1] = 10

        // Then
        assertEquals("102", add)
        assertEquals(4, position.a)
        assertEquals(10, position[1])
    }
}