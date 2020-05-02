package spring.practice.kotlin.basicSyntaxPractice

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * Created by kimchanjung on 2020-04-30 5:33 오후
 */

class Person(val name: String, val age: Int) {
    operator fun component1(): String = name
    operator fun component2(): Int = age
}

data class NewPerson(val age: Int, val name: String)

internal class DestructuringTest {

    @Test
    fun Destructuring이_정상적으로_동작한다() {
        // Given
        val person = Person("김찬정", 20)
        val newPerson = NewPerson(20, "김찬정")

        // When
        val (name, age) = person
        val (newName, newAge) = newPerson

        // Then
        assertEquals("김찬정", name)
        assertEquals(20, age)
        assertEquals(20, newName)
        assertEquals("김찬정", newAge)
    }
}