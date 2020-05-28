package spring.practice.kotlin.basicSyntaxPractice

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * Created by kimchanjung on 2020-04-26 5:31 오후
 */
class CollectionTest {

    @Test
    fun 리스트가_정상적으로_동작한다() {
        // Given
        val listOf = listOf(1, 2, 3)
        val list = List(3) { v -> v + 1 }
        val emptyMutableList = mutableListOf<Int>()
        val mutableListOf = mutableListOf(1, 2, 3)
        val mutableList = MutableList(2) { v -> v + 1 }


        // When
        listOf.get(0)
        listOf[0]
        mutableListOf.add(3, 4)
        mutableListOf.remove(1)
        val (even, odd) = listOf.partition { it % 2 == 0 }

        // Then
        assertEquals(2, even.get(0))
        assertEquals(1, odd.get(0))
    }

    @Test
    fun 맵이_정상적으로_동작한다() {
        // Given
        val mapOf = mapOf("a" to 1, "b" to 2)
        val emptyMutableMap = mutableMapOf<String, Int>()

        // When & Then
        assertEquals(1, mapOf.get("a"))
        assertEquals(1, mapOf["a"])
        assertEquals(null, emptyMutableMap.put("c", 3))
    }
}