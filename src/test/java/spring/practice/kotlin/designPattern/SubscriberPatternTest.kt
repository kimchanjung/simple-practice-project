package spring.practice.kotlin.designPattern

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * Created by kimchanjung on 2020-05-05 10:16 오후
 */
internal class SubscriberPatternTest {

    @Test
    fun 배달상태변경_이벤트를_정상적으로_수신받는다() {
        // Given
        val notificationService = DeliveryStatusPublisher()
        val deliveryStatusListener = DeliveryStatusSubscriber()
        val deliveryStatusListener2 = DeliveryStatusSubscriber()
        notificationService.add(deliveryStatusListener)
        notificationService.add(deliveryStatusListener2)

        // When
        notificationService.update("COMPLETE")

        // Then
        assertTrue(deliveryStatusListener.isSent)
        assertTrue(deliveryStatusListener2.isSent)
    }
}