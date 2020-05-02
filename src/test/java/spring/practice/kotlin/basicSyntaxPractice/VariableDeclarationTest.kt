package spring.practice.kotlin.basicSyntaxPractice

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

/**
 * Created by kimchanjung on 2020-04-29 2:42 오후
 */

internal class VariableDeclarationTest {

    @Test
    fun 변수_선언이_정삭적으로_동작한다() {
        // Given
        val name: String = "김찬정" // 불변
        var age: Int = 10

        // When
        // name = "홍길동" 컴파일 오류 발
        age = 20

        // Then
        assertEquals("김찬정", name)
        assertEquals(20, age)
    }

    @Test
    fun NULLABLE_선언이_정상적으로_동작한다() {
        // Given
        // null 값 허용 변수 선언
        var name: String? = null
        // null 값을 허용하지 않는 변수에 null을 선언 할 수 없다.
        // var age: Int = null

        // When
        // name 이 null이 아니면 length 를 반환
        // java 에서  Integer nameLength = name != null ? name.length() : null; 같음
        val nameLength = name?.length

        // Then
        assertEquals(null, nameLength)

    }

    @Test
    fun NULL이면_예외가_발생한다() {
        // Given
        val name: String? = null
        val age: Int? = name as? Int? // 타입케스팅이 불가능한 경우 예외를 발생시키지 않고 null 반환한다.

        // When & Then
        assertNull(age)
        assertThrows<NullPointerException> {
            val nameLength = name!!.length
        }
    }
}