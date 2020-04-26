package spring.practice.kotlin.basicSyntaxPractice

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * Created by kimchanjung on 2020-04-25 4:14 오후
 */
internal class DataClassTest{

    @Test
    fun 데어터클래스가_정상적으로_선언된다() {
        // Given
        val responseDto = ResponseDto(1, "김찬정")
        val entity = Entity(1, "김찬정")


        // When
        val dtoClass = DataClass.fromDto(responseDto)
        val entityClass = DataClass.fromEntity(entity)
        print(dtoClass.toString())

        // Then
        assertEquals(1, dtoClass.id)
        assertEquals("김찬정님", dtoClass.name)
        assertEquals(1, entity.id)
        assertEquals("김찬정", entity.name)
    }
}