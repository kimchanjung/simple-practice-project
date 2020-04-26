package spring.practice.kotlin.basicSyntaxPractice

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * Created by kimchanjung on 2020-04-26 6:23 오후
 */
internal class EnumClassTest {

    @Test
    fun ENUM_클래스가_정상적으로_동작한다() {
        // Given & When & Then
        assertEquals("COMPLETE_DELIVERY", EnumClass.COMPLETE_DELIVERY.toString())
        assertEquals(4, EnumClass.COMPLETE_DELIVERY.number)
        assertEquals("전달완료", EnumClass.COMPLETE_DELIVERY.desc)
        assertEquals("COMPLETE_DELIVERY", EnumClass.COMPLETE_DELIVERY.name)
        assertEquals("전달완료(4)", EnumClass.COMPLETE_DELIVERY.getStatus())
    }


    @Test
    fun ENUM_와_WHEN_사용이_정상적으로_동작한() {
        // Given & When
        val selectStatus = selectStatus(EnumClass.COMPLETE_DELIVERY)
        val selectStatuses = selectStatus(EnumClass.CONSIGN, EnumClass.COMPLETE_PICKUP)

        // Then
        assertEquals("COMPLETE_DELIVERY", selectStatus)
        assertEquals("CONSIGN or COMPLETE_PICKUP", selectStatuses)
    }
}