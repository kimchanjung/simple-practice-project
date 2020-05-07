package spring.practice.kotlin.designPattern.factoryMethodPattern

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * Created by kimchanjung on 2020-05-07 5:26 오후
 */
internal class FactoryMethodPatternTest {

    @Test
    fun 팩토리메소드_패턴이_올바로_동작한다() {
        // Given
        val riderFactory:RiderFactory = FoodDeliveryRiderFactory()

        // When
        val fullTimeRider = riderFactory.createRider("fulltime")
        val partTimeRider = riderFactory.createRider("parttime")

        // Then
        assertEquals("오토바이배달", fullTimeRider.delivery())
        assertEquals("자전거배달", partTimeRider.delivery())
    }
}