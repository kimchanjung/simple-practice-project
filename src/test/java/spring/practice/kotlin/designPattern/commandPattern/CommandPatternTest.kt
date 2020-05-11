package spring.practice.kotlin.designPattern.commandPattern

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * Created by kimchanjung on 2020-05-11 4:28 오후
 */
internal class CommandPatternTest {

    @Test
    fun 커맨드패턴이_정상적으로_동작한다() {
        // Given
        val motorCycleCommand = MotorCycleCommand(MotorCycle())
        val bikeCommand = BikeCommand(Bike())
        val motorCycleRider = Rider(motorCycleCommand)
        val bikeRider = Rider(bikeCommand)

        // When
        val delivery = motorCycleRider.delivery()
        val delivery1 = bikeRider.delivery()
        val delivery2 = bikeRider
                .changeDeliveryCommand(motorCycleCommand)
                .delivery()
        // Then
        assertEquals("오토바이출발", delivery)
        assertEquals("자전거출발", delivery1)
        assertEquals("오토바이출발", delivery2)
    }
}