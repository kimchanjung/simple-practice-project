package spring.practice.kotlin.basicSyntaxPractice

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * Created by kimchanjung on 2020-04-26 3:27 오후
 */
internal class DelegationTest {

    @Test
    fun 위임클래스가_정상적으로_동작한다() {
        // Given & When
        val delegation = DelegationImpl("김찬정")
        val delegationBy = DelegationByImpl(delegation, "김찬정")

        // Then
        assertEquals("김찬정", delegation.name)
        assertArrayEquals(arrayOf("김찬정", "kimchanjung"), delegation.findAll().toTypedArray())
        assertEquals("김찬정", delegationBy.name)
        assertArrayEquals(arrayOf("김찬정", "kimchanjung", "mogomezwai"), delegationBy.findAll().toTypedArray())
    }

    @Test
    fun 위임리스트가_정상적으로_동작한다() {
        // Given
        val newList = NewList<Int>(3){0}
        val delegateList = DelegateList<Int>(3){0}

        // When
        newList.add(1)
        delegateList.add(1)

        // Then
        assertEquals(0, newList.get(0))
        assertEquals(1, delegateList.get(3))
    }
}