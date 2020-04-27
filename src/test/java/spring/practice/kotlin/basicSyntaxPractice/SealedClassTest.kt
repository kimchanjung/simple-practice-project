package spring.practice.kotlin.basicSyntaxPractice

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * Created by kimchanjung on 2020-04-27 5:39 오후
 */
internal class SealedClassTest {

    @Test
    fun 오브젝트의_멤버로_선언한_배달상태가_올바로_선택된다() {
        // Given & When
        val selectDeliveryStatus = selectDeliveryStatus(DeliveryStatus.PICKUP)

        // Then
        assertEquals("픽업(3)", selectDeliveryStatus)
    }

    @Test
    fun ENUM_CLASS로_선언한_배달상태가_올바로_선택된다() {
        // Given & When
        val selectDeliveryStatus = selectEnumDeliveryStatus(EnumDeliveryStatus.PICKUP)
        val selectDeliveryStatus2 = selectEnumDeliveryStatus2(EnumDeliveryStatus.PICKUP)

        // Then
        assertEquals("픽업(3)", selectDeliveryStatus)
        assertEquals("픽업(3)", selectDeliveryStatus2)
    }

    @Test
    fun SEALED_CLASS로_선언한_배달상태가_올바로_선택된다() {
        // Given & When
        val selectDeliveryStatus = selectSealedDeliveryStatus(CONSIGN(1, "배차", "김찬정"))

        // Then
        assertEquals("김찬정", selectDeliveryStatus)
    }
}