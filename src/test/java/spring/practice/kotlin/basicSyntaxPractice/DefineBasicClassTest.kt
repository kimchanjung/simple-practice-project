package spring.practice.kotlin.basicSyntaxPractice

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * Created by kimchanjung on 2020-04-19 5:08 오후
 */
internal class DefineBasicClassTest {


    @Test
    fun 간단_클래스가_정상적으로_선언된다() {
        // When
        val simpleBasicConstructor = SimpleClass("김찬정", "서울")

        // Then
        assertEquals("서울", simpleBasicConstructor.address)
        assertEquals(41,simpleBasicConstructor.age)
    }

    @Test
    fun 클래스가_정상적으로_선언된다() {
        // When
        val basicConstructor = BasicConstructor("김찬정", "서울", 41)

        // Then
        assertEquals("서울 특별시", basicConstructor.address)
    }

    @Test
    fun 생성자_오버로딩이_정상적이() {
        // When
        val overLoadingConstructor = OverLoadingConstructor("김찬정")
        val overLoadingSecondConstructor = OverLoadingConstructor("촨", "서울", 10)
        val overLoadingConstructorWithoutInit = OverLoadingConstructorWithoutInit("김찬정")

        // Then
        assertEquals("김찬정", overLoadingConstructor.name)
        assertEquals("촨", overLoadingSecondConstructor.name)
        assertEquals("김찬정", overLoadingConstructorWithoutInit.name)
    }


    @Test
    fun 정적팩토리_생성자가_정상적으로_작동된다() {
        // Given
        val privateDefaultConstructor = PrivateDefaultConstructor.of("김찬정")
        val of = PrivateDefaultConstructorForJava.of("김찬정")
        val ofNew = PrivateDefaultConstructorForJava.ofNew("촨")

        // Then
        assertEquals("서울", PrivateDefaultConstructor.address)
        assertEquals(20, PrivateDefaultConstructorForJava.age)
        assertEquals("김찬정", privateDefaultConstructor.name)
        assertEquals("김찬정", of.name)
        assertEquals("촨", ofNew.name)

    }

    @Test
    fun 기본_패턴_클래스가_정상적으로_작동한다() {
        // Given
        val of = BasicPatternClass.of("김찬정", "서울", 20)

        // When
        of.address = "부산"

        // Then
        assertEquals("김찬정", of.name)
        assertEquals("부산 특별시",of.address)
        assertEquals("촨",of.changeName("촨"))
        assertTrue(of.isAdult())
    }
}