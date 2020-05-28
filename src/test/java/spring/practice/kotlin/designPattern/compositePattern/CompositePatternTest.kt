package spring.practice.kotlin.designPattern.compositePattern

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * Created by kimchanjung on 2020-05-08 5:30 오후
 */
internal class CompositePatternTest {

    @Test
    fun 컴포지트패턴이_정상적으로_동작한다() {
        // Given
        val riderList = mutableListOf(FullTimeRider(), PartTimeRider(), ConnectRider())
        val allTypeRider = AllTypeRider(riderList)
        val riderService = RiderService(allTypeRider)

        // When
        val delivery = riderService.deliveryAllRiders("자전거")

        // Then
        assertEquals("정규직자전거배달시간제자전거배달커넥트자전거배달", delivery)
    }
}
