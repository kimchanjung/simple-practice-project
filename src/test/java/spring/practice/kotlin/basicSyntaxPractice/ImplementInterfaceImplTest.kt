package spring.practice.kotlin.basicSyntaxPractice

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * Created by kimchanjung on 2020-04-23 4:10 오후
 */
internal class ImplementInterfaceImplTest{

    @Test
    fun 인터페이스가_정상적으로_구현된다() {
        // Given
        val implementInterface = ImplementInterfaceImpl(20)

        // When
        val nameInEnglish = implementInterface.getNameInEnglish()
        val isAdult = implementInterface.isAdult()

        // Given
        assertEquals("kim", nameInEnglish)
        assertTrue(isAdult)
    }
}