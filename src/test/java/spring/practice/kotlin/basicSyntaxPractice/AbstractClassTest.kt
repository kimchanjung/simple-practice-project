package spring.practice.kotlin.basicSyntaxPractice

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * Created by kimchanjung on 2020-04-24 2:08 오후
 */
internal class AbstractClassTest{

    @Test
    fun 추상클래스가_정상적으로_선언된다() {
        // Given
        val abstractClassImpl = AbstractClassImpl("김찬정", 20,"서울")
        // When
        // Then
        assertEquals("김찬정", abstractClassImpl.name)
        assertEquals(20, abstractClassImpl.age)
        assertEquals("서울", abstractClassImpl.address)
        assertEquals("kimchanjung", abstractClassImpl.getNameInEnglish())
    }
}