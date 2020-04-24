package spring.practice.kotlin.basicSyntaxPractice

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * Created by kimchanjung on 2020-04-24 5:23 오후
 */
internal class StaticClassTest{

    @Test
    fun 오브젝트가_정상적으로_선언된다() {
        assertEquals("김찬정", StaticClass.name)
        assertEquals("김찬정 (kimchanjung)", StaticClass.getNameWithEnglishName())
    }

    @Test
    fun 정적팩토리메소가_정상적으로_동작한() {
        // Given
        val of = StaticFactoryMethodClass.of("김찬정", 20)
        val ofNew = StaticFactoryMethodClass.ofNew("김찬정", 20)

        // When
        assertEquals("김찬정님", ofNew.name)
    }
}