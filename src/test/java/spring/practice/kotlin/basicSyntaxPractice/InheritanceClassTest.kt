package spring.practice.kotlin.basicSyntaxPractice

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * Created by kimchanjung on 2020-04-23 3:57 오후
 */
internal class InheritanceClassTest {

    @Test
    fun 상속이_정상적으로_이루어진다() {
        // Given
        val parent = Parent("김찬정", 10)
        val child = Child("김찬정", 20)

        // Then
        assertEquals(10, parent.age)
        assertEquals(21, child.age)
        assertTrue(child.isAdultParentMethod())
        assertEquals("kim", parent.getNameInEnglish())
        assertEquals("child kim", child.getNameInEnglish())
    }
}